package com.light.datadispose.utils;

import com.light.datadispose.lightAnnotation.ShowFunAble;
import com.light.datadispose.model.ShowFun;
import org.reflections.Reflections;
import org.reflections.scanners.Scanners;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Method;
import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class FunUrlUtil {
    private static final String packName="com.light.datadispose.controller";

    /**
     * 控制层可显示的功能列表
     */
    public static List<ShowFun> controllerShowList=getShowFunList(packName);

    /**
     * 获取对应包下可显示功能列表
     * @param packName 包名
     * @return 可显示功能列表
     */
    public static List<ShowFun> getShowFunList(String packName) {
        Reflections reflections = new Reflections(packName);
        Set<Class<?>> classes = reflections.get(Scanners.TypesAnnotated.of(ShowFunAble.class).asClass());
        List<ShowFun> showFuns = classes.stream().map(aClass -> {
            RequestMapping annotation = aClass.getAnnotation(RequestMapping.class);
            ShowFunAble showFunAnn = aClass.getAnnotation(ShowFunAble.class);
            //类的功能组
            ShowFun showFun = new ShowFun();
            showFun.setName(showFunAnn.name());
            showFun.setDescription(showFunAnn.description());

            //获取所有方法对应的子功能url
            List<ShowFun> subUrls = Arrays.stream(aClass.getMethods()).mapMulti((Method method, Consumer<ShowFun> c) -> {
                ShowFunAble subShowFunAnn = method.getAnnotation(ShowFunAble.class);
                if (subShowFunAnn == null) return;

                var ra = method.getAnnotation(RequestMapping.class);
                if (ra != null && Arrays.stream(ra.method()).anyMatch(requestMethod -> requestMethod == RequestMethod.GET)) {

                    for (String s : ra.value()) {
                        c.accept(new ShowFun(subShowFunAnn.name(), subShowFunAnn.description(), s, null));
                    }
                    if (ra.value().length == 0) {
                        c.accept(new ShowFun(subShowFunAnn.name(), subShowFunAnn.description(), "", null));
                    }
                }
                var rg = method.getAnnotation(GetMapping.class);
                if (rg != null) {
                    for (String s : rg.value()) {
                        c.accept(new ShowFun(subShowFunAnn.name(), subShowFunAnn.description(), s, null));
                    }
                    if (rg.value().length == 0) {

                        c.accept(new ShowFun(subShowFunAnn.name(), subShowFunAnn.description(), "", null));
                    }
                }

            }).toList();
            if (subUrls.isEmpty())
                return null;


            //如果有根url
            if (annotation != null) {
                ArrayList<ShowFun> urls = new ArrayList<>();
                String[] value = annotation.value();
                if (value.length > 0) {
                    for (String s : value) {

                        urls.addAll(subUrls.stream().peek(s1 -> s1.setUrl(urlSlashDisposal(s, s1.getUrl()))).toList());
                    }
                    showFun.setShowFuns(urls);
                    return showFun;
                }
            }
            showFun.setShowFuns(subUrls);
            return showFun;
        }).filter(Objects::nonNull).toList();
        return showFuns;
    }

    public static String urlSlashDisposal(String... urls) {
        return Arrays.stream(urls).map(s -> {
            if (s.isEmpty())
                return s;
            else if (s.length() > 1 && s.charAt(0) == '/' && s.charAt(s.length() - 1) == '/') {
                return s.substring(1, s.length() - 1);
            } else if (s.charAt(0) == '/')
                return s.substring(1);
            else if (s.charAt(s.length() - 1) == '/')
                return s.substring(0, s.length() - 1);
            else
                return s;
        }).collect(Collectors.joining("/", "/", ""));
    }

}
