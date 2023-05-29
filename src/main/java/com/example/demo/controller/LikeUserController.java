package com.example.demo.controller;

import com.example.demo.entity.LikeUser;
import com.example.demo.service.ILikeUserService;
import lombok.val;
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
    @RequestMapping("/selectLike")
    public Integer selectLike(@RequestBody LikeUser likeUser){
        val likeUser1 = iLikeUserService.selectLike(likeUser);
        if (likeUser1 == null)
            return 0;
        return likeUser1.getUserId();
    }

    @ResponseBody
    @RequestMapping("/delLikeUser")
    public int delLikeUser(@RequestBody LikeUser likeUser){
        return iLikeUserService.delLikeUser(likeUser);
    }
}
