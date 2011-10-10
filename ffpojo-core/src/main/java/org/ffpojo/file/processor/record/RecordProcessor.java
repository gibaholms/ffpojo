package org.ffpojo.file.processor.record;

import org.ffpojo.exception.RecordProcessorException;
import org.ffpojo.file.processor.record.event.RecordEvent;


public interface RecordProcessor {

	public void processHeader(RecordEvent event) throws RecordProcessorException;
	public void processBody(RecordEvent event) throws RecordProcessorException;
	public void processTrailer(RecordEvent event) throws RecordProcessorException;
	
}
