package com.example.demo.controller;

import com.example.demo.common.MessageCode;
import com.example.demo.model.base.BaseResponse;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value="/add", method = RequestMethod.POST)
    public BaseResponse addUser(@RequestBody @NonNull User user){
        BaseResponse baseResponse = new BaseResponse(MessageCode.SUCCESS, MessageCode.SUCCESS_MSG);
        int result = userService.insert(user);
        if(result != 1){
            baseResponse.setCode(MessageCode.FAIL);
            baseResponse.setMessage(MessageCode.FAIL_MSG);
        }
        return baseResponse;
    }

}
