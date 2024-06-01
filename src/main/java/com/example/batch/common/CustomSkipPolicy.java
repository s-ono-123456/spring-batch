package com.example.batch.common;

import org.springframework.batch.core.step.skip.SkipLimitExceededException;
import org.springframework.batch.core.step.skip.SkipPolicy;

public class CustomSkipPolicy implements SkipPolicy {

	@Override
	public boolean shouldSkip(Throwable t, long skipCount) throws SkipLimitExceededException {
		// TODO 自動生成されたメソッド・スタブ
        if (t instanceof Exception) {
            return true; // スキップする
        }
        return false; // スキップしない
	}
}