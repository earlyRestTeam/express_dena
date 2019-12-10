package com.example.express_dena.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author 王志坚
 * @createTime 2019.12.07.10:43
 */
@Configuration
@MapperScan("com.example.express_dena.mapper")
public class MybatisConfig {
}
