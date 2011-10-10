package org.ffpojo.file.processor;

import org.ffpojo.file.processor.record.RecordProcessor;
import org.ffpojo.file.processor.record.handler.ErrorHandler;


public interface FlatFileProcessor {

	public void processFlatFile(RecordProcessor processor);
	
	public void setErrorHandler(ErrorHandler errorHandler);
	
}
