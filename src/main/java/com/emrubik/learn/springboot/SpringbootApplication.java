package com.emrubik.learn.springboot;

import com.emrubik.learn.springboot.config.DBConfig1;
import com.emrubik.learn.springboot.config.DBConfig2;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PropertySourceFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@EnableCaching // 开启缓存注解
//可以在配置类里面使用 EnableConfigurationProperties  也可以  @Configuration
//@PropertySource 导入配置文件
@EnableConfigurationProperties(value = {DBConfig1.class, DBConfig2.class})
//@MapperScan(basePackages = {"com.emrubik.learn.springboot"})
@SpringBootApplication
public class SpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class, args);
    }



}
