package com.example.express_dena;

import com.example.express_dena.config.AliPayConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@EnableScheduling
public class ExpressDenaApplication {
    @Bean
    public AliPayConfig aliPayConfig(){
        return new AliPayConfig();
    }

    public static void main(String[] args) {
        SpringApplication.run(ExpressDenaApplication.class, args);
    }

}
