package org.ffpojo.parser;

import org.ffpojo.metadata.RecordDescriptor;
import org.ffpojo.metadata.delimited.DelimitedRecordDescriptor;
import org.ffpojo.metadata.positional.PositionalRecordDescriptor;

public class RecordParserFactory {

	public static RecordParser createRecordParser(RecordDescriptor recordDescriptor) {
		if (recordDescriptor instanceof PositionalRecordDescriptor) {
			return new PositionalRecordParser((PositionalRecordDescriptor)recordDescriptor);
		} else if (recordDescriptor instanceof DelimitedRecordDescriptor) {
			return new DelimitedRecordParser((DelimitedRecordDescriptor)recordDescriptor);
		} else {
			throw new IllegalArgumentException("RecordParser not found for class " + recordDescriptor.getClass());
		}
	}
	
}
