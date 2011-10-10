package org.ffpojo;

import org.ffpojo.container.HybridMetadataContainer;
import org.ffpojo.container.MetadataContainer;
import org.ffpojo.exception.FFPojoException;
import org.ffpojo.metadata.RecordDescriptor;
import org.ffpojo.parser.RecordParser;
import org.ffpojo.parser.RecordParserFactory;


public class FFPojoHelper {

	private static FFPojoHelper singletonInstance;
	
	private MetadataContainer metadataContainer;
	
	private FFPojoHelper() throws FFPojoException {
		this.metadataContainer = new HybridMetadataContainer();
	}
	
	public static FFPojoHelper getInstance() throws FFPojoException {
		if (singletonInstance == null) {
			singletonInstance = new FFPojoHelper();
		}
		return singletonInstance;
	}
	
	public <T> T createFromText(Class<T> recordClazz, String text) throws FFPojoException {
		RecordDescriptor recordDescriptor = metadataContainer.getRecordDescriptor(recordClazz);
		RecordParser recordParser = RecordParserFactory.createRecordParser(recordDescriptor);
		return recordParser.parseFromText(recordClazz, text);
	}
	
	public <T> String parseToText(T record) throws FFPojoException {
		RecordDescriptor recordDescriptor = metadataContainer.getRecordDescriptor(record.getClass());
		RecordParser recordParser = RecordParserFactory.createRecordParser(recordDescriptor);
		return recordParser.parseToText(record);
	}
	
	public RecordParser getRecordParser(Class<?> recordClazz) throws FFPojoException {
		RecordDescriptor recordDescriptor = metadataContainer.getRecordDescriptor(recordClazz);
		return RecordParserFactory.createRecordParser(recordDescriptor);
	}
	
}
