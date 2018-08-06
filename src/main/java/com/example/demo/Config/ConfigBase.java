package com.example.demo.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource(locations = {"classpath:config/application-mvc.xml"})
public class ConfigBase {

}
