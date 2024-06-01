package com.example.batch.jobs;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import com.example.batch.common.DataSourceConfiguration;


@Configuration
@EnableBatchProcessing
@Import(DataSourceConfiguration.class)
public class Job02Configuration {

	@Autowired
	private Step step02;

	@Bean
	public Job job02(JobRepository jobRepository) {
		return new JobBuilder("Job02", jobRepository)
			.incrementer(new RunIdIncrementer())
			.start(step02)
			.build();
	}
    

}
