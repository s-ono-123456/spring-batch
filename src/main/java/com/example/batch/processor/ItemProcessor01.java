package com.example.batch.processor;

import java.util.ArrayList;
import java.util.List;

import org.springframework.batch.core.ChunkListener;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.SkipListener;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.core.StepListener;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.stereotype.Component;

import com.example.batch.bean.ItemReaderBean01;
import com.example.batch.bean.ItemWriterBean01;
import com.example.batch.common.BaseProcessor;

@Component
public class ItemProcessor01 extends BaseProcessor<ItemReaderBean01, ItemWriterBean01>
         implements SkipListener<ItemReaderBean01, ItemWriterBean01>
                   , StepListener, ChunkListener, StepExecutionListener{
	
	private int chunknum = 0;
	private int skipnum = 0;
	private List<Throwable> exceptions = new ArrayList<>();
	
	@Override
	protected ItemWriterBean01 executeIndividually(ItemReaderBean01 item) {
		ItemWriterBean01 output = new ItemWriterBean01();
		output.setTest(item.getTest());
		output.setData(item.getData());
		output.setId(item.getId());
		return output;
	}
	
	@Override
	public void onSkipInWrite(ItemWriterBean01 item, Throwable t) {
		// TODO 自動生成されたメソッド・スタブ
		SkipListener.super.onSkipInWrite(item, t);
		skipnum++;
		System.out.println("スキップ対象ID:" + item.getId());
		exceptions.add(t);
	}
	
	@Override
	public ExitStatus afterStep(StepExecution stepExecution) {
		// TODO 自動生成されたメソッド・スタブ
		System.out.println("スキップ件数：" + skipnum);
		
		return StepExecutionListener.super.afterStep(stepExecution);
	}
	
	@Override
	public void beforeChunk(ChunkContext context) {
		// TODO 自動生成されたメソッド・スタブ
		chunknum++;
		ChunkListener.super.beforeChunk(context);
		System.out.println(chunknum + "チャンク開始");
	}

}
