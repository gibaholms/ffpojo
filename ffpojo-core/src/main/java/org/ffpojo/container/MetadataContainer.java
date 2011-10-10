package org.ffpojo.container;

import org.ffpojo.exception.MetadataContainerException;
import org.ffpojo.metadata.RecordDescriptor;

public interface MetadataContainer {

	public RecordDescriptor getRecordDescriptor(Class<?> recordClazz) throws MetadataContainerException;
	
}
