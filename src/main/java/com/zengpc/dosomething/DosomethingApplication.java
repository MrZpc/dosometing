package com.zengpc.dosomething;

import com.zengpc.dosomething.config.JdbcConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 引导类
 */
@RestController //相当于 @Controller 和 @ResponseBody
@SpringBootApplication  //@EnableAutoConfiguration @ComponentScan
public class DosomethingApplication {

    @Autowired
    private JdbcConfig jdbcConfig;

    public static void main(String[] args) {
        SpringApplication.run(DosomethingApplication.class, args);
    }

    @RequestMapping("/index")
    public String index(){

        return "hello world";
    }

}
