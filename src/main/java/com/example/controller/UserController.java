package com.example.controller;

import com.example.commom.Result;
import com.example.mapper.UserMapper;
import com.example.pojo.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin//解决跨域问题
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserMapper userMapper;


    @RequestMapping("/{name}")
    @ResponseBody
    public Result queryUserNameLike(@PathVariable("name") String name) {
        List<User> users = userMapper.queryUserNameLike(name);
        if (users.isEmpty()) {
            return Result.error("No users found");
        } else {
            return Result.success(users);
        }

    }

    @ResponseBody
    @RequestMapping("/all")
    public List<User> queryUserList() {
        return userMapper.queryUserList();
    }
//    测试优选
    public void GitCheeryTest(){
        System.out.println("GitCheeryTest");
    }


//返回查询结果的json字符串
//    @RequestMapping("/{name}")
//    @ResponseBody
//    public ResponseEntity<String> queryUserNameLike(@PathVariable("name") String name) {
//        List<User> users = userMapper.queryUserNameLike(name);
//        ObjectMapper objectMapper = new ObjectMapper();
//        try {
//            String jsonResult = objectMapper.writeValueAsString(users);
//
//            // 返回 JSON 响应
//            return ResponseEntity.ok(jsonResult);
//        } catch (JsonProcessingException e) {
//            // 处理 JSON 转换异常
//            e.printStackTrace();
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error converting to JSON");
//        }
//    }
//
////    @ResponseBody
//    @RequestMapping("/all")
////    返回一个所有用户的json字符串
//    public ResponseEntity<String> queryUserList(){
//        List<User> users=userMapper.queryUserList();
//        try {
//            return ResponseEntity.ok(new ObjectMapper().writeValueAsString(users));
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error converting to JSON");
//        }
//    }
}
