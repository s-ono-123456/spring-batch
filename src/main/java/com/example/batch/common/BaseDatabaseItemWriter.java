package com.example.batch.common;

import java.util.List;

import org.mybatis.spring.batch.MyBatisBatchItemWriter;

public class BaseDatabaseItemWriter<T> extends MyBatisBatchItemWriter<T> {
	@Override
	public void write(List<? extends T> items) {
		// TODO 自動生成されたメソッド・スタブ
		try {
			super.write(items);
		} catch (Exception e) {
			System.out.println(e);
			throw new RuntimeException(e);
		}
		
	}
}
