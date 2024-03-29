package com.ballad;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.ApplicationPidFileWriter;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;


/**
 * @author: don't know who is.
 */
@SpringBootApplication(exclude = DruidDataSourceAutoConfigure.class)
@ServletComponentScan
@EnableScheduling
@Configuration
public class MyStateMachineApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(MyStateMachineApplication.class);
        application.addListeners(new ApplicationPidFileWriter("spring_my_state_machine_practice.pid"));
        application.run(args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(MyStateMachineApplication.class);
    }
}
