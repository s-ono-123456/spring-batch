package com.example.batch.common;

import org.mybatis.spring.batch.MyBatisBatchItemWriter;
import org.springframework.batch.item.Chunk;

public class BaseDatabaseItemWriter<T> extends MyBatisBatchItemWriter<T> {
	@Override
	public void write(Chunk<? extends T> items) {
		// TODO 自動生成されたメソッド・スタブ
		try {
			super.write(items);
		} catch (Exception e) {
			System.out.println(e);
			throw new RuntimeException(e);
		}
		
	}
}
