package com.example.demo.controller;

import com.example.demo.entity.LikeTalk;
import com.example.demo.service.ILikeTalkService;
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
 * @since 2023-04-18
 */
@Controller
@RequestMapping("/likeTalk")
public class LikeTalkController {

    @Resource
    ILikeTalkService iLikeTalkService;

    @ResponseBody
    @RequestMapping("/addLikeTalk")
    public int addLikeTalk(@RequestBody LikeTalk likeTalk){
        return iLikeTalkService.addLikeTalk(likeTalk);
    }

    @ResponseBody
    @RequestMapping("/delLikeTalk")
    public int delLikeTalk(@RequestBody LikeTalk likeTalk){
        return iLikeTalkService.delLikeTalk(likeTalk);
    }

    @ResponseBody
    @RequestMapping("/selectLike")
    public LikeTalk selectLike(@RequestBody LikeTalk likeTalk){
        return iLikeTalkService.selectLike(likeTalk);
    }
}
