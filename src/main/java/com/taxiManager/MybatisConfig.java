package com.taxiManager;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MybatisConfig {
	 @Bean
	    public SqlSessionFactory sqlSessionFactory() throws IOException {
	        String resource = "mybatis/mybatis-config.xml";
	        InputStream inputStream = Resources.getResourceAsStream(resource);
	        return new SqlSessionFactoryBuilder().build(inputStream);
	    }
  
}
