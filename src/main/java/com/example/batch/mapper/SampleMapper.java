package com.example.batch.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.batch.bean.ItemReaderBean01;
import com.example.batch.bean.ItemWriterBean01;

@Mapper
public interface SampleMapper {
	public List<ItemReaderBean01> select001();
    public int insert001(ItemWriterBean01 itemwWriterBean01);
}
