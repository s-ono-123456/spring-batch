package com.example.batch.reader;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import com.example.batch.bean.ItemReaderBean01;

@Configuration
public class CsvItemReader {

	@Bean
    public ItemReader<ItemReaderBean01> csvFileItemReader() {
        FlatFileItemReader<ItemReaderBean01> reader = new FlatFileItemReader<>();
        reader.setResource(new ClassPathResource("data.csv")); // CSVファイルのパスを指定
        
        LineMapper<ItemReaderBean01> lineMapper = createLineMapper();
        reader.setLineMapper(lineMapper);
        reader.setName("csvFileItemReader");
        
        return reader;
    }

    private LineMapper<ItemReaderBean01> createLineMapper() {
        DefaultLineMapper<ItemReaderBean01> lineMapper = new DefaultLineMapper<>();
        
        DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
        lineTokenizer.setNames("id", "test", "data"); // 使用するCSVカラムの名前を指定
        
        BeanWrapperFieldSetMapper<ItemReaderBean01> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
        fieldSetMapper.setTargetType(ItemReaderBean01.class);
        
        lineMapper.setLineTokenizer(lineTokenizer);
        lineMapper.setFieldSetMapper(fieldSetMapper);
        
        return lineMapper;
    }
}