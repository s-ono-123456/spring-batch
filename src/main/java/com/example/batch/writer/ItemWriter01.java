package com.example.batch.writer;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.batch.MyBatisBatchItemWriter;
import org.mybatis.spring.batch.builder.MyBatisBatchItemWriterBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.example.batch.bean.ItemWriterBean01;

@Component
public class ItemWriter01 {
	@Autowired
	private SqlSessionFactory sqlSessionFactory;

	@Bean
	public MyBatisBatchItemWriter<ItemWriterBean01> writer() {
		return new MyBatisBatchItemWriterBuilder<ItemWriterBean01>()
				.sqlSessionFactory(sqlSessionFactory)
				.statementId("com.example.batch.mapper.SampleMapper.insert001")
				.build();
	}
}
