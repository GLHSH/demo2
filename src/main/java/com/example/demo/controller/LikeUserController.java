package com.example.demo.controller;

import com.example.demo.entity.LikeUser;
import com.example.demo.service.ILikeUserService;
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
 * @since 2023-04-14
 */
@Controller
@RequestMapping("/likeUser")
public class LikeUserController {
    @Resource
    ILikeUserService iLikeUserService;

    @ResponseBody
    @RequestMapping("/addLikeUser")
    public int addLikeUser(@RequestBody LikeUser likeUser){
        return iLikeUserService.addLikeUser(likeUser);
    }

    @ResponseBody
    @RequestMapping("/addLikeUser1")
    public LikeUser addLikeUser1(){
        return new LikeUser();
    }

    @ResponseBody
    @RequestMapping("/delLikeUser")
    public int delLikeUser(@RequestBody LikeUser likeUser){
        return iLikeUserService.delLikeUser(likeUser);
    }
}
