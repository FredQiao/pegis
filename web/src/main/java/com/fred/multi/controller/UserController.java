package com.fred.multi.controller;

import com.fred.multi.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api
@RequestMapping(value = "user")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "用户操作")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Object listUsers() {
        return userService.listUsers();
    }

}
