package com.example.batch.steps;

import org.mybatis.spring.batch.MyBatisBatchItemWriter;
import org.mybatis.spring.batch.MyBatisCursorItemReader;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.batch.bean.ItemReaderBean01;
import com.example.batch.bean.ItemWriterBean01;
import com.example.batch.processor.ItemProcessor01;


@Configuration
public class Steps {
	@Autowired
    private StepBuilderFactory stepBuilderFactory;
	
	@Autowired
	private Tasklet tasklet01;
	@Autowired
	private Tasklet tasklet02;
	
	@Autowired
	private MyBatisCursorItemReader<ItemReaderBean01> reader01;
	@Autowired
	private ItemProcessor01 processor01;
	@Autowired
	private MyBatisBatchItemWriter<ItemWriterBean01> writer01;
	
	
	//Step01:基本的なTaklet型のStepの作成
    @Bean
    public Step step01() {
        return stepBuilderFactory.get("step01")
                .tasklet(tasklet01)
                .build();
    }
    
    //Step02:基本的なChunk型Stepの作成
    @Bean
    public Step step02() {
        return stepBuilderFactory.get("step02")
                .<ItemReaderBean01, ItemWriterBean01>chunk(10)
                .reader(reader01)
                .processor(processor01)
                .writer(writer01)
                .build();
    }
}
