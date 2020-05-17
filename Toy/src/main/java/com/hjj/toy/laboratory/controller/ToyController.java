package com.hjj.toy.laboratory.controller;

import com.hjj.toy.laboratory.service.ToyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;


@RestController
@RequestMapping("/toy")
@Slf4j
public class ToyController {


    @Resource(name = "toyServiceImpl")
    private ToyService toyService;



    @RequestMapping(value = "/call", method = RequestMethod.GET)
    public void call() {
        toyService.call();
    }

    @RequestMapping(value = "/log", method = RequestMethod.GET)
    public void callLog() {
//        String name = UUID.randomUUID().toString().toUpperCase();

//        Thread.currentThread().setName(name);
        log.info("log controller {}",1);
        toyService.testLog();
    }


}
