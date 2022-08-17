package com.light.datadispose.utils;

import com.light.datadispose.lightAnnotation.ShowFunAble;
import lombok.val;
import org.reflections.Reflections;
import org.reflections.scanners.Scanners;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class funUrlUtil {
    public static void main(String[] args) {

        Reflections reflections = new Reflections("com.light.datadispose.controller");
        Set<Class<?>> classes = reflections.get(Scanners.TypesAnnotated.of(ShowFunAble.class).asClass());
        classes.stream().flatMap(aClass -> {
            RequestMapping annotation = aClass.getAnnotation(RequestMapping.class);
            //获取所有方法对应的url
            List<String> subUrls = Arrays.stream(aClass.getMethods()).mapMulti((Method method, Consumer<String> c) -> {

                var ra = method.getAnnotation(RequestMapping.class);
                if (ra != null && Arrays.stream(ra.method()).anyMatch(requestMethod -> requestMethod == RequestMethod.GET)) {

                    for (String s : ra.value()) {
                        c.accept(s);
                    }
                    if (ra.value().length == 0) {
                        c.accept("");
                    }
                }
                var rg = method.getAnnotation(GetMapping.class);
                if (rg != null) {
                    for (String s : rg.value()) {
                        c.accept(s);
                    }
                    if (rg.value().length == 0) {

                        c.accept("");
                    }
                }

            }).toList();
            //如果有根url
            if (annotation!=null){
                ArrayList<String> urls = new ArrayList<>();
                String[] value = annotation.value();
                if (value.length>0){
                    for (String s : value) {
                        urls.addAll(subUrls.stream().map(s1 -> urlSlashDisposal(s,s1)).toList());
                    }
                    return urls.stream();
                }
            }
            return subUrls.stream();
        }).toList();

    }

    public static String urlSlashDisposal(String... urls) {
        return Arrays.stream(urls).map(s -> {
            if (s.isEmpty())
                return s;
            else if (s.length() > 1 && s.charAt(0) == '/' && s.charAt(s.length() - 1) == '/') {
                return s.substring(1, s.length() - 1);
            } else if (s.charAt(0) == '/')
                return s.substring(1);
            else if (s.charAt(s.length()-1)=='/')
                return s.substring(0,s.length()-1);
            else
                return s;
        }).collect(Collectors.joining("/", "/", ""));
    }

}
