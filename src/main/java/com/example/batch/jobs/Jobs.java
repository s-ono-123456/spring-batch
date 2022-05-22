package com.example.batch.jobs;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@EnableBatchProcessing
public class Jobs {

	@Autowired
	private JobBuilderFactory jobBuilderFactory;
	
	@Autowired
	private Step step01;

	@Autowired
	private Step step02;
	
	@Bean
	public Job job01() {
		return jobBuilderFactory.get("Job01")
			.incrementer(new RunIdIncrementer())
			.flow(step01)
			.end()
			.build();
	}

	@Bean
	public Job job02() {
		return jobBuilderFactory.get("Job02")
			.incrementer(new RunIdIncrementer())
			.flow(step02)
			.end()
			.build();
	}
}
