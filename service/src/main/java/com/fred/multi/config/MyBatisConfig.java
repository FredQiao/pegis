package com.fred.multi.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.annotation.PreDestroy;

@Configuration
@EnableConfigurationProperties({DataBaseProperties.class})
@MapperScan(basePackages = {"com.fred.multi.dao"})
public class MyBatisConfig {

    @Autowired
    private DataBaseProperties dataBaseProperties;

    private DataSource dataSource;

    @Bean(destroyMethod = "close")
    public DataSource createDataSource() {
        DataBaseProperties config = this.dataBaseProperties;

        this.dataSource = new DataSource();
        this.dataSource.setDriverClassName(config.getDriverClassName());
        this.dataSource.setUrl(config.getUrl());
        this.dataSource.setUsername(config.getUsername());
        this.dataSource.setPassword(config.getPassword());

        return this.dataSource;
    }

    @PreDestroy
    public void close(){
        if(this.dataSource != null){
            this.dataSource.close();
        }
    }

    @Bean
    @Lazy
    public SqlSessionFactory sqlSessionFactoryBean() throws Exception{
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(createDataSource());

        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:com/fred/multi/dao/mapper/*Mapper.xml"));

        return sqlSessionFactoryBean.getObject();
    }

    @Bean
    @Lazy
    public PlatformTransactionManager transactionManager(){
        return new DataSourceTransactionManager((createDataSource()));
    }
}
