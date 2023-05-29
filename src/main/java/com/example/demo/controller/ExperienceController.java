package com.example.demo.controller;

import com.example.demo.entity.Experience;
import com.example.demo.mapper.ExperienceMapper;
import com.example.demo.service.IExperienceService;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
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
    Environment environment;

    @ResponseBody
    @RequestMapping("/findAll")
    public List<Experience> findAll() {
        System.out.println("Controller1 正在find All" );
        return experienceService.SelectAllTest(null);
    }
    @ResponseBody
    @RequestMapping("/findAllByCity")
    public List<Experience> findAllByCity(@RequestParam String city) {
        System.out.println("Controller1 正在查询 城市 结果\t" +city);
        val s = city.replace("\"", "");
        return experienceService.SelectAllTest(s);
    }
    @ResponseBody
    @RequestMapping("/findAllBySearch")
    public List<Experience> findAllBySearch(@RequestParam String search) {
        System.out.println("Controller1 正在查询搜索结果\t" +search);
        val s = search.replace("\"", "");
        return experienceService.SelectAllBySearch(s);
    }

    @ResponseBody
    @RequestMapping("/addExperience")
    public Experience addExperience(@RequestBody Experience experience) {
        System.out.println("Controller 正在添加Experience" + experience );
        if (experience.getId() != null){
            String firstPath = environment.getProperty("spring.web.resources.static-locations").substring(5)+"/";
            String savePath = firstPath + experience.getUserId()+"/"+experience.getId();
            List<String> imgUrlList=new ArrayList<>();
            if ( experience.getMediaUrl() == null){
                for (int i = 0; i < experience.getImgCount(); i++) {
                    imgUrlList.add("img_"+i+1+".png");
                }
            }else{
                if(experience.getImgCount() == 1) {
                    imgUrlList.add(experience.getMediaUrl());
                }
                else {
                    imgUrlList = Arrays.asList(experience.getMediaUrl().split(" "));
                }
            }
            for (String s :
                    imgUrlList) {
                File dest = new File(savePath +"/"+ s);
                if (dest.exists()){
                    dest.delete();
                }
            }

        }
        experienceService.addExperience(experience);
        return experience;
    }
    @ResponseBody
    @RequestMapping("/updateExperience")
    public Experience updateExperience(@RequestBody Experience experience) {
        System.out.println("updateExperience" + experience);
        val oldExperience = experienceService.getById(experience.getId());
        System.out.println("oldExperience : "+oldExperience);
        deleteExFile(oldExperience);

        val update = experienceService.updateById(experience);
        if (update) {
            return experience;
        } else {
            return new Experience();
        }
    }

    @ResponseBody
    @RequestMapping("/upload")
    public Boolean upload(@RequestParam("userId") int userId,
                       @RequestParam("experienceId") int experienceId,
                       @RequestParam("imgCount") int imgCount,
                       @RequestParam MultipartFile[] files) {
        int i = 1;
        String firstPath = environment.getProperty("spring.web.resources.static-locations").substring(5)+"/";
        String userPath = firstPath + userId;
        String exPath = userPath+"/"+ experienceId;
        File userFile = new File(userPath);
        File exFile = new File(exPath);
        if (!userFile.exists()) {
            System.out.print("创建用户文件夹 :"+userFile.mkdir());
        }
        if (!exFile.exists()) {
            System.out.println("创建帖子文件夹 :"+exFile.mkdir());
        }
        for (MultipartFile file : files) {
            System.out.println("多媒体FileName:" + file.getOriginalFilename());
            try {
                i++;
                File filePath = new File(exPath +"/"+ file.getOriginalFilename());
                if (filePath.exists()){
                    filePath.delete();
                }
                file.transferTo(filePath);
                System.out.println("上传成功 \n");
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    @ResponseBody
    @RequestMapping("/updateExGood")
    public int updateExGood(@RequestBody Experience experience) {
        System.out.println("Controller 正在更新点赞" + experience);
        return experienceService.updateExperience(experience);
    }
    @ResponseBody
    @RequestMapping("/updateExStar")
    public int updateExStar(@RequestBody Experience experience) {
        System.out.println("Controller 正在更新收藏" + experience);
        return experienceService.updateExperienceStar(experience);
    }
    @ResponseBody
    @RequestMapping("/delExperience")
    public int delExperience(@RequestBody Experience experience) {
        System.out.println("delExperience" + experience);
        String firstPath = environment.getProperty("spring.web.resources.static-locations").substring(5)+"/";
        String exFile = firstPath+experience.getUserId()+"/"+experience.getId();
        deleteExFile(experience);
        File file = new File(exFile);
        System.out.println("delete帖子文件夹: "+file.delete());
        return experienceService.delExperience(experience);
    }

    private void deleteExFile(@RequestBody Experience experience) {
        String firstPath = environment.getProperty("spring.web.resources.static-locations").substring(5)+"/";
        String exFile = firstPath+experience.getUserId()+"/"+experience.getId();
        if (experience.getImgCount()<=1){
            File file = new File(exFile+"/"+experience.getMediaUrl());
            System.out.println("delete图片 "+file.getName()+" "+file.delete());
        } else {
            val s = experience.getMediaUrl().split(" ");
            for (String s1 : s){
                File file = new File(exFile+"/"+s1);
                System.out.println("delete图片 "+file.getName()+" "+file.delete());
            }
        }
    }
}
