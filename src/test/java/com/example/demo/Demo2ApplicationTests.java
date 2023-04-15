package com.example.demo;

import com.example.demo.Dao.IUserDao;
import com.example.demo.controller.UserController;
import com.example.demo.mapper.ExperienceMapper;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@SpringBootTest
@MapperScan("com.example.demo.mapper")
class Demo2ApplicationTests {

    @Resource
    IUserDao iUserDao;
    @Resource
    UserController userController;
    @Resource
    ExperienceMapper experienceMapper;

    @Test
    void contextLoads() throws IOException {
        Path path = Paths.get("D:\\upload\\mmexport1679388630044.mp4");
        val type = Files.probeContentType(path);
        System.out.println(type);
    }

}
