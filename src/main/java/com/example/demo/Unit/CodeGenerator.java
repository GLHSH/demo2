package com.example.demo.Unit;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

public class CodeGenerator {
    public static void main(String[] args) {
        String url ="jdbc:mysql://localhost:3306/bs?serverTimezone=UTC&characterEncoding=utf-8";
        String username ="root";
        String password ="12345678";
        String path = System.getProperty("user.dir") + "\\src\\main\\java";
        FastAutoGenerator.create(url, username, password)
                .globalConfig(builder -> {
                    builder.author("胡胜辉") // 设置作者
//                            .enableSwagger() // 开启 swagger 模式
                            .outputDir(path); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("com.example.demo") // 设置父包名
                            .pathInfo(Collections.singletonMap(OutputFile.xml, path+"\\com\\example\\demo\\mapper\\xml")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude("like_ex"); // 设置需要生成的表名
//                            .addTablePrefix("t_", "c_"); // 设置过滤表前缀
                })
                .execute();
    }
}
