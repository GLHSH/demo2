package com.example.demo.controller;

//import com.example.demo.entity.LoginOk;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.entity.Experience;
import com.example.demo.entity.LoginOk;
import com.example.demo.entity.User;
import com.example.demo.service.IExperienceService;
import com.example.demo.service.IUserService;
import lombok.val;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 胡胜辉
 * @since 2023-04-06
 */
@Controller
@RequestMapping("/manager")
public class managerController {

    @Resource
    IUserService userService;
    @Resource
    IExperienceService experienceService;

    @ResponseBody
    @RequestMapping("/update")
    public boolean update(@RequestBody User user) {
        System.out.println("有user更新请求来啦\t"+user);
        return userService.updateById(user);
    }

    @ResponseBody
    @RequestMapping("/selectAll")
    public List<User> selectAll() {
        System.out.println("selectAll");
        return userService.list();
    }

    @ResponseBody
    @RequestMapping("/selectByName")
    public List<User> selectByName(@RequestBody User user) {
        System.out.println("selectByName");
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("nick_name",user.getNickName());
        return userService.list();
    }

    @ResponseBody
    @RequestMapping("/OtherUserSelectOne")
    public LoginOk OtherUserSelectOne(@RequestBody User user) {
        System.out.println("有OtherUserSelectOne来啦"+user);
        LoginOk loginOk = new LoginOk(
                user,
                experienceService.selectLikeEx(user.getId()),
                experienceService.selectMeExperience(user.getId()),
                userService.selectLikeUser(user.getId()),
                userService.selectFans(user.getId())
        );
        System.out.println(loginOk);
        return loginOk;
    }

    @ResponseBody
    @RequestMapping("/findAll")
    public List<Experience> findAll() {
        System.out.println("Controller1 正在find All" );
        return experienceService.SelectAllTest(null);
    }

    @ResponseBody
    @RequestMapping("/updateExperience")
    public boolean updateExperience(@RequestBody Experience experience) {
        System.out.println("updateExperience" + experience);
        return experienceService.updateById(experience);
    }
}
