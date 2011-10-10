package org.ffpojo.container;

import java.io.IOException;
import java.io.InputStream;

import org.ffpojo.exception.MetadataContainerException;
import org.ffpojo.exception.MetadataReaderException;
import org.ffpojo.metadata.RecordDescriptor;
import org.ffpojo.reader.XmlMetadataReader;


class XmlMetadataContainer extends BaseMetadataContainer implements MetadataContainer {

	public XmlMetadataContainer(InputStream xmlMetadataInputStream) throws MetadataContainerException {
		XmlMetadataReader xmlMetadataReader = new XmlMetadataReader(xmlMetadataInputStream);
		try {
			this.recordDescriptorByClazzMap = xmlMetadataReader.readMetadata();
			xmlMetadataInputStream.close();
		} catch (MetadataReaderException e) {
			throw new MetadataContainerException("Error while reading ffpojo-ofm xml metadata", e);
		} catch (IOException e) {
			throw new MetadataContainerException("Error while reading ffpojo-ofm xml metadata", e);
		}
	}
	
	public RecordDescriptor getRecordDescriptor(Class<?> recordClazz) {
		return recordDescriptorByClazzMap.get(recordClazz);
	}

}
