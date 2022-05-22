package com.example.batch.reader;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.batch.MyBatisCursorItemReader;
import org.mybatis.spring.batch.builder.MyBatisCursorItemReaderBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.example.batch.bean.ItemReaderBean01;

@Component
public class ItemReader01 {
	@Autowired
	private SqlSessionFactory sqlSessionFactory;

	@Bean
	public MyBatisCursorItemReader<ItemReaderBean01> reader() {
		// SELECTにバインド変数を利用したい場合は以下を設定する。
		//Map<String, Object> parameterValues = new HashMap<String, Object>();
		
		return new MyBatisCursorItemReaderBuilder<ItemReaderBean01>()
				.queryId("com.example.batch.mapper.SampleMapper.select001")
				.sqlSessionFactory(sqlSessionFactory)
				//.parameterValues(parameterValues)
			    .build();
	}
}
