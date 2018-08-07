package com.example.demo.controller;

import com.example.demo.common.MessageCode;
import com.example.demo.model.User;
import com.example.demo.model.base.BaseResponse;
import com.example.demo.service.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    //编程式事务
    @Autowired
    private TransactionTemplate transactionTemplate;

    @Autowired
    private UserService userService;

    @Transactional//注解式事务
    @ApiOperation(value="添加用户基础信息", notes="根据User对象创建用户。")
    @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    @RequestMapping(value="/add", method = RequestMethod.POST)
    public BaseResponse addUser(@RequestBody @NonNull User user){
        BaseResponse baseResponse = new BaseResponse(MessageCode.SUCCESS, MessageCode.SUCCESS_MSG);
        int result = userService.insert(user);
        int a = 5/0;
//        int result = transactionTemplate.execute((TransactionStatus transactionStatus) -> {
//            int r = userService.insert(user);
//            int a = 5/0;
//            return r;
//        });
        if(result != 1){
            baseResponse.setCode(MessageCode.FAIL);
            baseResponse.setMessage(MessageCode.FAIL_MSG);
        }
        return baseResponse;
    }

}
