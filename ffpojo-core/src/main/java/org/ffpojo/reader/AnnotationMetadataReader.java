package org.ffpojo.reader;

import org.ffpojo.exception.MetadataReaderException;
import org.ffpojo.metadata.RecordDescriptor;

public abstract class AnnotationMetadataReader {
	
	protected Class<?> recordClazz;

	protected AnnotationMetadataReader(Class<?> recordClazz) {
		this.recordClazz = recordClazz;
	}
	
	public abstract RecordDescriptor readMetadata() throws MetadataReaderException;
	
}
