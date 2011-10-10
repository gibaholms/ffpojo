package org.ffpojo.file.processor.record.handler;

import org.ffpojo.exception.RecordProcessorException;

public class DefaultErrorHandler implements ErrorHandler {

	public void error(RecordProcessorException exception) throws RecordProcessorException {
		throw exception;
	}
	
}
