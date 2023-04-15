package com.example.demo.controller;

//import com.example.demo.entity.LoginOk;
import com.example.demo.entity.LoginOk;
import com.example.demo.entity.User;
import com.example.demo.service.IExperienceService;
import com.example.demo.service.IUserService;
import lombok.val;
import lombok.var;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 胡胜辉
 * @since 2023-04-06
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    IUserService userService;
    @Resource
    IExperienceService experienceService;

    @ResponseBody
    @RequestMapping("/login")
    public LoginOk login(@RequestBody User user) {
        System.out.println("有请求来啦"+user);
        var baseModel = userService.login(user);
        System.out.println("Controller " + baseModel);
        if (baseModel.getCode() == 1){
            val user1 = baseModel.getT();
            return new LoginOk(
                    user1,
                    experienceService.selectLikeEx(user1.getId()),
                    experienceService.selectMeExperience(user1.getId()),
                    userService.selectLikeUser(user1.getId()),
                    userService.selectFans(user1.getId())
            );
        }
        return null;
    }

    @ResponseBody
    @RequestMapping("/register")
    public User register(@RequestBody User user) {
        System.out.println("有注册请求来啦"+user);
        userService.register(user);
        if (user.getId() == null || user.getId() <= 0){
            return new User();
        }
        return user;
    }

    @ResponseBody
    @RequestMapping("/update")
    public int update(@RequestBody User user) {
        System.out.println("有更新请求来啦"+user);
        return userService.update(user);
    }
}
