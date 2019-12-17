package com.example.express_dena.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;


@Configuration
//开启事务管理
@EnableTransactionManagement
@MapperScan("com.example.express_dena.mapper")
public class MybatisConfig {
}
