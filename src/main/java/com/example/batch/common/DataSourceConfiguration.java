package com.example.batch.common;

import javax.sql.DataSource;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.support.JdbcTransactionManager;

@Configuration
public class DataSourceConfiguration {

	@Bean
	@ConfigurationProperties(prefix = "spring.datasource1")
	public DataSource dataSource() {
		DataSource d = DataSourceBuilder.create().build();
		return d;
	}
	
	@Bean
	public JdbcTransactionManager transactionManager(DataSource dataSource) {
		return new JdbcTransactionManager(dataSource);
	}
	
	@Bean
	public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
	    // Spring Batchと互換性のあるExecutorType.BATCHを設定
	    return new SqlSessionTemplate(sqlSessionFactory, ExecutorType.BATCH);
	}
}
