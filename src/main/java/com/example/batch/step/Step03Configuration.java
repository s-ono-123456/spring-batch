package com.example.batch.step;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.batch.MyBatisCursorItemReader;
import org.mybatis.spring.batch.builder.MyBatisCursorItemReaderBuilder;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.support.CompositeItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import com.example.batch.bean.ItemReaderBean01;
import com.example.batch.bean.ItemWriterBean01;
import com.example.batch.common.BaseDatabaseItemWriter;
import com.example.batch.common.CustomSkipPolicy;
import com.example.batch.processor.ItemProcessor01;
import com.example.batch.processor.ItemProcessor02;

@Configuration
public class Step03Configuration {
	
	@Autowired
	private ItemReader<ItemReaderBean01> csvFileItemReader;
	@Autowired
	private ItemProcessor02 processor02;
	@Autowired
	private SqlSessionFactory sqlSessionFactory;
    //Step02:基本的なChunk型Stepの作成
    @Bean
    public Step step03(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
        return new StepBuilder("step03", jobRepository)
                .<ItemReaderBean01, ItemWriterBean01>chunk(3, transactionManager)
                .reader(reader())
                .processor(processor02)
                .writer(writer())
                .faultTolerant()
                .skipPolicy(new CustomSkipPolicy())
                .build();
    }
    
    public MyBatisCursorItemReader<ItemReaderBean01> reader() {
		// SELECTにバインド変数を利用したい場合は以下を設定する。
		//Map<String, Object> parameterValues = new HashMap<String, Object>();
		
		return new MyBatisCursorItemReaderBuilder<ItemReaderBean01>()
				.queryId("com.example.batch.mapper.SampleMapper.select001")
				.sqlSessionFactory(sqlSessionFactory)
				//.parameterValues(parameterValues)
			    .build();
	}
    
    
	public CompositeItemWriter<ItemWriterBean01> writer() {
		List<ItemWriter<? super ItemWriterBean01>> writers = new ArrayList<>();
		writers.add(writer01());
		CompositeItemWriter<ItemWriterBean01> itemWriter = new CompositeItemWriter<>();

		itemWriter.setDelegates(writers);
		return itemWriter;
	}
	
	private BaseDatabaseItemWriter<ItemWriterBean01> writer01() {
		BaseDatabaseItemWriter<ItemWriterBean01> writer = new BaseDatabaseItemWriter<>();
		writer.setSqlSessionFactory(sqlSessionFactory);
		writer.setStatementId("com.example.batch.mapper.SampleMapper.update001");
		writer.afterPropertiesSet();
		
		return writer;
	}
}
