package org.cgenh.springBoot.activiti;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Configuration
@SpringBootApplication
@RequestMapping("/hello")
public class HelloWorld {


    @RequestMapping("hello1")
    @ResponseBody
    public String haha() {
        return "helloworld";

    }

    public static void main(String[] args) {
        SpringApplication.run(HelloWorld.class, args);
    }

}
