package com.light.datadispose.service.funService;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;



@Service
public class TestFunService {

    @Async("MainExecutor")
    public void test1(){
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
