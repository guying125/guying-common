package com.guying.msgcenter.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 描述：数据源属性
 *
 * @author CODE POTER
 * @version 1.0
 * @date 2020-07-22 03:08 星期三
 */
@Data
@ConfigurationProperties(prefix = "spring.datasource.druid")
public class DruidDataSourceProperties {

    /**
     * jdbc
     */
    private String driverClassName;
    private String url;
    private String username;
    private String password;
    /**
     * jdbc connection pool
     */
    private int initialSize;
    private int minIdle;
    private int maxActive = 100;
    private long maxWait;
    private long timeBetweenEvictionRunsMillis;
    private long minEvictableIdleTimeMillis;
    private String validationQuery;
    private boolean testWhileIdle;
    private boolean testOnBorrow;
    private boolean testOnReturn;
    private boolean poolPreparedStatements;
    private int maxPoolPreparedStatementPerConnectionSize;
    /**
     * filter
     */
    private String filters;
}