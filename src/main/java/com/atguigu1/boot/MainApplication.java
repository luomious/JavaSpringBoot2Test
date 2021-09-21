package com.atguigu1.boot;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
/*
*        #server.servlet.encoding.charset=GBK
#         debug=true//开启自动配置报告
* SpringBoot会自动加载131个所有自动配置，但是会按要求自动装配
*
*总结：SpringBoot先加载所有的自动配置类
*    每个自动配置类按照条件自动生效，默认会绑定配置文件指定的值。xxxProperties和配置文件里找
*    生效的配置类会给容器中装配很多组件，就会有组件功能
*   用户自己配置的自己会优先
*
*            过程：xxxAutoConfiguration---->组件------->xxxProperties里面拿值------>application.properties
* */
//@SpringBootConfiguration  :
//@EnableAutoConfiguration    ：最重要的合成注解
//@ComponentScan:扫描
@SpringBootApplication(scanBasePackages = "com.atguigu1")//组合注解
public class MainApplication {
    public static void main(String[] args) {
        //1.返回IOC容器
        ConfigurableApplicationContext run = SpringApplication.run(MainApplication.class, args);
        //2.查看容器里的組件
        String[] names = run.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
        //3.从容器中获取组件
//        Pet tomcat01 = run.getBean("tomcat01", Pet.class);
//        Pet tomcat02 = run.getBean("tomcat01", Pet.class);
//        System.out.println(tomcat01 == tomcat02);
//
//
//        //4.如果@configuration(proxyBeanMethods = true),springboot总会检查这个组件是否存在,只能存在一个
//        MyConfig bean = run.getBean(MyConfig.class);
//        System.out.println(bean);
//        User user = bean.user01();
//
//        //5.获取组件
//        String[] beanNamesForType = run.getBeanNamesForType(User.class);
//        System.out.println("*********************************************************************");
//        for (String s : beanNamesForType) {
//            System.out.println(s);
//        }
//        DBHelper bean1 = run.getBean(DBHelper.class);
//        System.out.println(bean1);
//        boolean tom = run.containsBean("tomcat01");
//        System.out.println(tom);
//        Object user01 = run.getBean("user01");
//        System.out.println(user01);


        boolean haha = run.containsBean("haha");
        boolean hehe = run.containsBean("hehe");
        System.out.println("haha" + haha);
        System.out.println("hehe" + hehe);


    }
}
