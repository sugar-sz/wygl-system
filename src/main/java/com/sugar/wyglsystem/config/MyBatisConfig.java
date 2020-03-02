package com.sugar.wyglsystem.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author ：lyj
 * @date ：Created in 2020/2/16 20:33
 * @description： mybatis config
 */
@Configuration
@MapperScan({"com.sugar.wyglsystem.mbg.mapper","com.sugar.wyglsystem.dao"})
public class MyBatisConfig {
}
