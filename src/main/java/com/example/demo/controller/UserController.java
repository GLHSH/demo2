package com.example.demo.controller;

//import com.example.demo.entity.LoginOk;
import com.example.demo.entity.Experience;
import com.example.demo.entity.LoginOk;
import com.example.demo.entity.User;
import com.example.demo.service.IExperienceService;
import com.example.demo.service.IUserService;
import lombok.val;
import lombok.var;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
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
@RequestMapping("/user")
public class UserController {

    @Resource
    IUserService userService;
    @Resource
    IExperienceService experienceService;
    @Resource
    private Environment environment;

    @ResponseBody
    @RequestMapping("/login")
    public LoginOk login(@RequestBody User user) {
        System.out.println("有login请求来啦"+user);
        var baseModel = userService.login(user);
        System.out.println("Controller " + baseModel);
        switch (baseModel.getCode()) {
            case -1:
                user.setId(-1);
                return new LoginOk(
                        user,
                        null,
                        null,
                        null,
                        null
                );
                case 0:
                user.setId(0);
                return new LoginOk(
                        user,
                        null,
                        null,
                        null,
                        null
                );
            case 1:
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
    @RequestMapping("/selectUser")
    public LoginOk selectUser(@RequestBody User user) {
        System.out.println("Controller 个人界面" + user);
            return new LoginOk(
                    user,
                    experienceService.selectLikeEx(user.getId()),
                    experienceService.selectMeExperience(user.getId()),
                    userService.selectLikeUser(user.getId()),
                    userService.selectFans(user.getId())
            );
    }

    @ResponseBody
    @RequestMapping("/register")
    public User register(@RequestBody User user) {
        System.out.println("有注册请求来啦"+user);
        val user1 = userService.register(user);
        if (user1 == null){
            return new User();
        }
        user = user1;
        return user;
    }

    @ResponseBody
    @RequestMapping("/update")
    public int update(@RequestBody User user) {
        System.out.println("有user更新请求来啦\t"+user);
        return userService.update(user);
    }
    @ResponseBody
    @RequestMapping("/upload")
    public Boolean upload(@RequestParam("userId") int userId,
                          @RequestParam MultipartFile file) throws IOException {
        System.out.println("userId"+userId);
        val user = new User();
        user.setId(userId);
        val originalFilename = file.getOriginalFilename().substring( file.getOriginalFilename().lastIndexOf(".")+1);
        String fileName = "user_logo."+originalFilename;
        String firstPath = environment.getProperty("spring.web.resources.static-locations").substring(5)+"/";
        String userPath = firstPath+userId;
        File file1 = new File(userPath);
        if (!file1.exists()) {
            System.out.println("创建文件 "+userPath+":"+file1.mkdir());
        }
        File dest = new File(userPath +"/"+ fileName);
        if (dest.exists()){
            dest.delete();
        }
        file.transferTo(dest);
        user.setImgUrl(fileName);
        val i = userService.update(user);
        if (i>0) {
            System.out.println("userLogo上传成功");
            return true;
        }
        return false;
    }
    @ResponseBody
    @RequestMapping("/exSelectOne")
    public User exSelectOne(@RequestBody User user) {
        System.out.println("帖子分享者\t"+user);
        user = userService.exSelectOne(user);
        System.out.println(user);
        return user;
    }
    @ResponseBody
    @RequestMapping("/OtherUserSelectOne")
    public LoginOk OtherUserSelectOne(@RequestBody User user) {
        System.out.println("其他用户主页信息"+user);
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
    @RequestMapping("/selectAll")
    public List<User> selectAll() {
        System.out.println("selectAll");
        return userService.list();
    }
}
