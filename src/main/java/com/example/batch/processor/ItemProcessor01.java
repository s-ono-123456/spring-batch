package com.example.batch.processor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.example.batch.bean.ItemReaderBean01;
import com.example.batch.bean.ItemWriterBean01;

@Component
public class ItemProcessor01 implements ItemProcessor<ItemReaderBean01, ItemWriterBean01> {

	@Override
	public ItemWriterBean01 process(ItemReaderBean01 item) throws Exception {
		ItemWriterBean01 output = new ItemWriterBean01();
		output.setTest(item.getTest());
		System.out.println(item.getTest());
		return output;
	}

}
