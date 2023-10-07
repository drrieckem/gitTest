package com.example.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

//、当Controller是存在返回页面的控制器时，不可以使用@RestController
//
//2、当需要同时返回页面和字符串时，需要使用@Controller，在返回字符串的方法上使用@ResponseBody
//
//3、当不需要返回页面时，可以直接使用@RestController来代替@Controller和@ResponseBody，即可直接返回结果
@Controller
public class WebController {
    @ResponseBody
    @RequestMapping("/")
    public String hello() {
        return "hell1";
    }

//    @RequestMapping("/test")
//    public String test() {
//        return "test";
//    }
//
//    @GetMapping("/test1")
//    public String test1() {
//        return "test";
//    }
    @RequestMapping("/index")
    public String index(){
        return "index1";
    }


}
