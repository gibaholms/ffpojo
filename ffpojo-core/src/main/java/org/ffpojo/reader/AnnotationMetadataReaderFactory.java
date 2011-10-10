package org.ffpojo.reader;

import org.ffpojo.exception.MetadataNotFoundException;
import org.ffpojo.metadata.delimited.annotation.DelimitedRecord;
import org.ffpojo.metadata.positional.annotation.PositionalRecord;

public class AnnotationMetadataReaderFactory {

	public static AnnotationMetadataReader createAnnotationMetadataReader(Class<?> recordClazz) throws MetadataNotFoundException {
		PositionalRecord positionalRecordAnnotation = recordClazz.getAnnotation(PositionalRecord.class);
		if (positionalRecordAnnotation != null) {
			return new PositionalRecordAnnotationMetadataReader(recordClazz);
		} else {
			DelimitedRecord delimitedRecordAnnotation = recordClazz.getAnnotation(DelimitedRecord.class);
			if (delimitedRecordAnnotation != null) {
				return new DelimitedRecordAnnotationMetadataReader(recordClazz);
			} else {
				throw new MetadataNotFoundException("Annotation metadata not found for class " + recordClazz);
			}
		}
	}
	
}
