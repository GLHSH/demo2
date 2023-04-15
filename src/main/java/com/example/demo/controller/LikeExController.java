package com.example.demo.controller;

import com.example.demo.entity.LikeEx;
import com.example.demo.service.ILikeExService;
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
@RequestMapping("/likeEx")
public class LikeExController {

    @Resource
    ILikeExService iLikeExService;

    @ResponseBody
    @RequestMapping("/addLikeEx")
    public int addLikeEx(@RequestBody LikeEx likeEx){
        return iLikeExService.addLikeEx(likeEx);
    }

    @ResponseBody
    @RequestMapping("/delLikeEx")
    public int delLikeEx(@RequestBody LikeEx likeEx){
        return iLikeExService.delLikeEx(likeEx);
    }
}
