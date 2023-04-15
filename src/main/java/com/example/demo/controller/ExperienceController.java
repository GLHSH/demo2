package com.example.demo.controller;

import com.example.demo.entity.Experience;
import com.example.demo.mapper.ExperienceMapper;
import com.example.demo.service.IExperienceService;
import lombok.val;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
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
    @Resource
    ExperienceMapper experienceMapper;

    @ResponseBody
    @RequestMapping("/findAll")
    public List<Experience> findAll() {
        System.out.println("Controller1 正在find All" );
        return experienceService.SelectAllTest();
    }

    @ResponseBody
    @RequestMapping("/addExperience")
    public Experience addExperience(@RequestParam() String title,
                                    @RequestParam() String text,
                                    @RequestParam() int userId,
                                    @RequestParam MultipartFile[] files) {
        System.out.println("Controller 正在添加Experience" );
        val experience =new Experience();
        if (title.startsWith("\"")){
            title = title.substring(1,title.length()-1);
            text = text.substring(1,text.length()-1);
        }
        experience.setTitle(title);
        experience.setText(text);
        experience.setUserId(userId);
        experience.setTime(LocalDateTime.now());
        experience.setImgCount(files.length);
        experienceService.addExperience(experience);
        System.out.println(experience);
        int i = 1;
        StringBuilder imgUrl = new StringBuilder();
        for (MultipartFile file : files) {
            try {
                val originalFilename = file.getOriginalFilename().substring( file.getOriginalFilename().lastIndexOf(".")+1);
                String fileName = "img_"+ i +"."+originalFilename;
                if (file.getContentType().startsWith("video")){
                    fileName = "video_"+ i +"."+originalFilename;
                    experience.setImgCount(0);
                }
                if (i == 1) imgUrl.append(fileName);
                else imgUrl.append(" ").append(fileName);
                i++;
                String savePath = "D:/upload/"+experience.getUserId();
                String savePath2 = savePath+"/"+experience.getId();
                File file1 = new File(savePath);
                File file2 = new File(savePath2);
                if (!file1.exists()) {
                    System.out.println("创建文件file1 "+file1.mkdir());
                }
                if (!file2.exists()) {
                    System.out.println("创建文件file2 "+file2.mkdir());
                }
                File dest = new File(savePath2 +"/"+ fileName);
                file.transferTo(dest);
                System.out.println("上传成功");
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (Exception e) {
                e.getMessage();
            }
        }
        experience.setMediaUrl(imgUrl.toString());
        experienceMapper.updateById(experience);
        return experience;
    }

}
