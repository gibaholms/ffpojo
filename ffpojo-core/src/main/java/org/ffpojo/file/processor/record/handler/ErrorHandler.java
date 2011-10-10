package org.ffpojo.file.processor.record.handler;

import org.ffpojo.exception.RecordProcessorException;

public interface ErrorHandler {

	public void error(RecordProcessorException exception) throws RecordProcessorException;
	
}
