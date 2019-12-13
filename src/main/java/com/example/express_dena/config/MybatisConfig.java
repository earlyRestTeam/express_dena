package com.example.express_dena.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author 王志坚
 * @createTime 2019.12.07.10:43
 */
@Configuration
//开启事务管理
@EnableTransactionManagement
@MapperScan("com.example.express_dena.mapper")
public class MybatisConfig {
}
