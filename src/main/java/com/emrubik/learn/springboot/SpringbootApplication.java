package com.emrubik.learn.springboot;

import com.emrubik.learn.springboot.config.DBConfig1;
import com.emrubik.learn.springboot.config.DBConfig2;
import org.ehcache.config.CacheConfiguration;

import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.CacheManagerBuilder;
import org.ehcache.config.builders.ExpiryPolicyBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;
import org.ehcache.config.units.MemoryUnit;
import org.ehcache.impl.serialization.PlainJavaSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.cache.JCacheManagerCustomizer;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import org.springframework.boot.web.embedded.tomcat.ConfigurableTomcatWebServerFactory;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.jcache.JCacheCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.http.HttpStatus;


import javax.cache.configuration.MutableConfiguration;

import javax.cache.expiry.Duration;
import javax.cache.expiry.TouchedExpiryPolicy;
import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;


@EnableCaching // 开启缓存注解
//可以在配置类里面使用 EnableConfigurationProperties  也可以  @Configuration
//@PropertySource 导入配置文件
@EnableConfigurationProperties(value = {DBConfig1.class, DBConfig2.class})
//@MapperScan(basePackages = {"com.emrubik.learn.springboot"})
@SpringBootApplication
public class SpringbootApplication<CACHE_NAME_XXXX> {



    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class, args);
    }

    /**
     * 嵌入式Servlet容器的配置  这里面配置端口号
     * 自定义的customerTomcatServletWebServerFactory  就失效了
     * @return
     */
    @Bean
    public WebServerFactoryCustomizer<ConfigurableWebServerFactory> webServerFactoryCustomizer(){
        return factory -> {
            factory.setPort(8080);
            factory.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND,"/404.html"));
        };
    }

    /**
     * 对tomcat容器进行配置 bean
     * 命名千万不能写成tomcatServletWebServerFactory
     * org.springframework.boot.autoconfigure.web.servlet.ServletWebServerFactoryAutoConfiguration  有一个
     * @return
     */
    @Bean
    public ConfigurableServletWebServerFactory customerTomcatServletWebServerFactory(){
        TomcatServletWebServerFactory webServerFactory  = new TomcatServletWebServerFactory ();
        webServerFactory.setPort(8090);
        webServerFactory.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND,"/404.html"));
        return webServerFactory;
    }

    //@Bean
    public JCacheManagerCustomizer jCacheManagerCustomizer(){

        return cacheManager -> {
            cacheManager.createCache("userCache1", new MutableConfiguration<>()
                    .setExpiryPolicyFactory(TouchedExpiryPolicy.factoryOf(new Duration(TimeUnit.MINUTES, 30)))
                    .setStoreByValue(false)
                    .setStatisticsEnabled(true));
        };
    }
    //https://www.bbsmax.com/A/KE5QKAwkzL/


    public void a(){
        //RedisCacheManager cacheManager = new RedisCacheManager();
        //EhCacheCacheManager cacheManager = new EhCacheCacheManager();
        JCacheCacheManager jCacheCacheManager = new JCacheCacheManager();
    }


}
