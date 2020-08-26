package com.emrubik.learn.springboot;

import com.emrubik.learn.springboot.config.DBConfig1;
import com.emrubik.learn.springboot.config.DBConfig2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.cache.JCacheManagerCustomizer;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

import javax.cache.CacheManager;
import javax.cache.configuration.MutableConfiguration;

import javax.cache.expiry.Duration;
import javax.cache.expiry.TouchedExpiryPolicy;
import java.util.concurrent.TimeUnit;


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

    //@Bean
    public JCacheManagerCustomizer jCacheManagerCustomizer(){

        return cacheManager -> cacheManager.createCache("userCache1", new MutableConfiguration<>()
                .setExpiryPolicyFactory(TouchedExpiryPolicy.factoryOf(new Duration(TimeUnit.MINUTES, 30)))
                .setStoreByValue(false)
                .setStatisticsEnabled(true));
    }
    //https://www.bbsmax.com/A/KE5QKAwkzL/

}
