package com.example.batch.step;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class Step01Configuration {
	@Autowired
	private Tasklet tasklet01;
	@Autowired
	private SqlSessionFactory sqlSessionFactory;

	//Step01:基本的なTaklet型のStepの作成
    @Bean
    public Step step01(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
        return new StepBuilder("step01", jobRepository)
                .tasklet(tasklet01, transactionManager)
                .build();
    }
    
}
