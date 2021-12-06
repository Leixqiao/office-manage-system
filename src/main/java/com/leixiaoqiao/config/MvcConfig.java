package com.leixiaoqiao.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @description: webmvc的配置类
 * @company: 云桥之上
 * @author: 萌萌居家好男人
 * @version: 1.0
 * @create: 2021-11-29 17:27:32
 */
@Configuration
public class MvcConfig {

    //配置跨域
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")//指定跨域映射地址
                        .allowedOrigins("*")//实际开发中需要指定客户端具体url
                        .allowedMethods("GET","POST","PUT", "DELETE","OPTIONS")
                        .allowedHeaders("*")//设置允许的请求头
                        //设置需要暴露给客户端获取的响应头内容
//                        .exposedHeaders("access-control-allow-headers",
//                            "access-control-allow-methods",
//                            "access-control-allow-origin",
//                            "access-control-max-age",
//                            "X-Frame-Options")
                        .allowCredentials(true)//设置是否允许客户端跨域携带验证数据，如Cookie值
                        .maxAge(3600);//跨域请求超时
            }
        };
    }
}
