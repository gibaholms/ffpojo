package org.ffpojo.parser;

import org.ffpojo.exception.RecordParserException;

public interface RecordParser {

	public <T> T parseFromText(Class<T> recordClazz, String text) throws RecordParserException;
	
	public <T> String parseToText(T record) throws RecordParserException;

}
