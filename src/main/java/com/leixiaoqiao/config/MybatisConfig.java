package com.leixiaoqiao.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @description: mybatis的配置类
 * @company: 云桥之上
 * @author: 萌萌居家好男人
 * @version: 1.0
 * @create: 2021-11-29 17:25:20
 */
@Configuration
//扫数据持久层的包
@MapperScan("com.leixiaoqiao.mapper")
public class MybatisConfig {

}
