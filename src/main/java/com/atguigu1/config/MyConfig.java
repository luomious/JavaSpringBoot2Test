package com.atguigu1.config;


import ch.qos.logback.core.db.DBHelper;
import com.atguigu1.boot.bean.Car;
import com.atguigu1.boot.bean.Pet;
import com.atguigu1.boot.bean.User;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.*;
import org.springframework.web.filter.CharacterEncodingFilter;

/*
 * 默认单实例的
 *
 *配置类本身是组件
 *  Full   proxyBeanMethods = true组件依赖性
 *   lite proxyBeanMethods = false
 *
 * */
@Import({User.class, DBHelper.class})//给容器自动创建组件
@Configuration(proxyBeanMethods = false)//告诉SpringBoot这是一个配置类==配置文件
@ConditionalOnMissingBean(name = "tom")
@ImportResource("classpath:beans.xml")//导入springboot的配置文件
@EnableConfigurationProperties(Car.class)
//1.开启Car的属性配置绑定功能
//2.把Car组件自动注册到容器中
public class MyConfig {

    @ConditionalOnBean(name = "tomcat01")                //条件装配
    @Bean
    public User user01() {
        return new User("zhangsan", 14);
    }

    //    @Bean("tomcat01")
    public Pet tomcat() {

        return new Pet("tomcat");
    }

//    @Bean
//    public CharacterEncodingFilter filter() {
//
//        return null;
//    }
}
