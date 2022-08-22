package com.light.datadispose.service.funService;

import com.light.datadispose.service.IFunService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;



@Service
public class TestFunService implements IFunService {

    @Async("MainExecutor")
    public void test1(){
        try {
            Thread.sleep(10000);
            System.out.println("线材");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
