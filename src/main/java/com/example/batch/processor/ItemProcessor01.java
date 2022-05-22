package com.example.batch.processor;

import org.springframework.stereotype.Component;

import com.example.batch.bean.ItemReaderBean01;
import com.example.batch.bean.ItemWriterBean01;
import com.example.batch.common.BaseProcessor;

@Component
public class ItemProcessor01 extends BaseProcessor<ItemReaderBean01, ItemWriterBean01> {

	@Override
	protected ItemWriterBean01 executeIndividually(ItemReaderBean01 item) {
		ItemWriterBean01 output = new ItemWriterBean01();
		output.setTest(item.getTest());
		System.out.println(item.getTest());
		return output;
	}

}
