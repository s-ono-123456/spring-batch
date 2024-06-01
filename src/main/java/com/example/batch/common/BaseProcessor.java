package com.example.batch.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.item.ItemProcessor;

public abstract class BaseProcessor<I, O> implements ItemProcessor<I, O>, JobExecutionListener {

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
	
	@Override
	public void beforeJob(JobExecution jobExecution) {
		// TODO 自動生成されたメソッド・スタブ
		JobExecutionListener.super.beforeJob(jobExecution);
		Logger logger = LoggerFactory.getLogger(this.getClass());
		logger.info("aaaa");
	}

}
