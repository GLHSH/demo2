package com.example.demo.controller;

import com.example.demo.entity.BaseModel;
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
            val loginOk = new LoginOk(
                    user1,
                    experienceService.selectLikeEx(user1.getId()),
                    experienceService.selectMeExperience(user1.getId())
            );
            return loginOk;
        }
        return null;
    }
}
