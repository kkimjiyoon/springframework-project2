package com.nhnacademy.edu.springframework.project.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = "com.nhnacademy.edu.springframework.project")
@PropertySource("classpath:value.properties")
public class ConfigMain {
}
