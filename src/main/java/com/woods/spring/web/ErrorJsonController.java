package com.woods.spring.web;

import com.woods.spring.result.ErrorInfo;
import com.woods.spring.result.GlobalErrorInfoException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ErrorJsonController {

    @RequestMapping("/exception")
    public String exception() throws GlobalErrorInfoException {
        throw new GlobalErrorInfoException(new ErrorInfo("-1", "出错啦！"));
    }
}
