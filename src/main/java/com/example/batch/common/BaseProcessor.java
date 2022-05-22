package com.example.batch.common;

import org.springframework.batch.item.ItemProcessor;

public abstract class BaseProcessor<I, O> implements ItemProcessor<I, O> {

	@Override
	public O process(I item) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		O output;
		try {
			output = executeIndividually(item);
		} catch (Exception e) {
			// Exceptionを処理する。
			throw new RuntimeException(e);
		}
		return output;
	}
	
	protected abstract O executeIndividually(I item);

}
