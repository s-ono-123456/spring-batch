package com.example.batch.writer;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.batch.MyBatisBatchItemWriter;
import org.mybatis.spring.batch.builder.MyBatisBatchItemWriterBuilder;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.support.CompositeItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.example.batch.bean.ItemWriterBean01;
import com.example.batch.common.BaseDatabaseItemWriter;

@Component
public class ItemWriter01 {
	@Autowired
	private SqlSessionFactory sqlSessionFactory;

	@Bean
	public CompositeItemWriter<ItemWriterBean01> writer() {
		List<ItemWriter<? super ItemWriterBean01>> writers = new ArrayList<>();
		writers.add(writer01());
		writers.add(writer02());
		CompositeItemWriter<ItemWriterBean01> itemWriter = new CompositeItemWriter<>();

		itemWriter.setDelegates(writers);
		return itemWriter;
	}
	
	private BaseDatabaseItemWriter<ItemWriterBean01> writer01() {
		BaseDatabaseItemWriter<ItemWriterBean01> writer = new BaseDatabaseItemWriter<>();
		writer.setSqlSessionFactory(sqlSessionFactory);
		writer.setStatementId("com.example.batch.mapper.SampleMapper.insert001");
		writer.afterPropertiesSet();
		
		return writer;
	}
	private BaseDatabaseItemWriter<ItemWriterBean01> writer02() {
		BaseDatabaseItemWriter<ItemWriterBean01> writer = new BaseDatabaseItemWriter<>();
		writer.setSqlSessionFactory(sqlSessionFactory);
		writer.setStatementId("com.example.batch.mapper.SampleMapper.insert001");
		writer.afterPropertiesSet();
		
		return writer;
	}
}
