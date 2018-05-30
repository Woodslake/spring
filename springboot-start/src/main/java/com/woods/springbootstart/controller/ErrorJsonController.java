package com.woods.springbootstart.controller;

import com.woods.springbootstart.result.ErrorInfo;
import com.woods.springbootstart.result.GlobalErrorInfoException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ErrorJsonController {

    @RequestMapping("/exception")
    public String exception() throws Exception {
        throw new GlobalErrorInfoException(new ErrorInfo("-1", "出错啦！"));
    }
}
