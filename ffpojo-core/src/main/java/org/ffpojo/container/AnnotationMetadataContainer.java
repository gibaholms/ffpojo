package org.ffpojo.container;

import org.ffpojo.exception.MetadataContainerException;
import org.ffpojo.exception.MetadataNotFoundException;
import org.ffpojo.exception.MetadataReaderException;
import org.ffpojo.metadata.RecordDescriptor;
import org.ffpojo.reader.AnnotationMetadataReader;
import org.ffpojo.reader.AnnotationMetadataReaderFactory;


class AnnotationMetadataContainer extends BaseMetadataContainer implements MetadataContainer {

	public RecordDescriptor getRecordDescriptor(Class<?> recordClazz) throws MetadataContainerException {
		RecordDescriptor recordDescriptor = recordDescriptorByClazzMap.get(recordClazz);
		if (recordDescriptor == null) {
			AnnotationMetadataReader annotationMetadataReader;
			try {
				annotationMetadataReader = AnnotationMetadataReaderFactory.createAnnotationMetadataReader(recordClazz);
				recordDescriptor = annotationMetadataReader.readMetadata();
				recordDescriptorByClazzMap.put(recordClazz, recordDescriptor);
			} catch (MetadataNotFoundException e) {
				recordDescriptor = null;
			} catch (MetadataReaderException e) {
				throw new MetadataContainerException("Error while reading annotation metadata for class " + recordClazz, e);
			}
		}
		return recordDescriptor;
	}

}
