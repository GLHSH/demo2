package com.example.demo.controller;

import com.example.demo.entity.Experience;
import com.example.demo.service.IExperienceService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 胡胜辉
 * @since 2023-03-30
 */
@Controller
@RequestMapping("/experience")
public class ExperienceController {
    @Resource
    IExperienceService experienceService;

    @ResponseBody
    @RequestMapping("/findAll")
    public List<Experience> findAll() {
        System.out.println("Controller 正在find All" );
        return experienceService.SelectAllTest();
    }

}
