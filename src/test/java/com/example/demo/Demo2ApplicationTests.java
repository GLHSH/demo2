package com.example.demo;

import com.example.demo.Dao.ILikeExDao;
import com.example.demo.Dao.ILoginDao;
import com.example.demo.controller.UserController;
import com.example.demo.entity.Experience;
import com.example.demo.entity.User;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
@MapperScan("com.example.demo.mapper")
class Demo2ApplicationTests {

    @Resource
    ILoginDao iLoginDao;
    @Resource
    UserController userController;

    @Test
    void contextLoads() {
        val user = new User();
        user.setName("aaa");
        user.setPassword("111");
        val loginok = userController.login(user);
        System.out.println(loginok);
    }

}
