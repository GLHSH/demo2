package com.example.demo.controller;

import com.example.demo.entity.GoodEx;
import com.example.demo.entity.LikeEx;
import com.example.demo.service.IGoodExService;
import com.example.demo.service.ILikeExService;
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
 * @since 2023-04-18
 */
@Controller
@RequestMapping("/goodEx")
public class GoodExController {

    @Resource
    IGoodExService iGoodExService;

    @ResponseBody
    @RequestMapping("/addGoodEx")
    public int addGoodEx(@RequestBody GoodEx goodEx){
        return iGoodExService.addGoodEx(goodEx);
    }

    @ResponseBody
    @RequestMapping("/delGoodEx")
    public int delGoodEx(@RequestBody GoodEx goodEx){
        return iGoodExService.delGoodEx(goodEx);
    }

    @ResponseBody
    @RequestMapping("/selectLike")
    public Integer selectLike(@RequestBody GoodEx goodEx){
        val goodEx1 = iGoodExService.selectLike(goodEx);
        if (goodEx1 == null)
            return 0;
        return goodEx1.getId();
    }
}
