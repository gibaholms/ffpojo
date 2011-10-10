package org.ffpojo.reader;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.ffpojo.exception.MetadataReaderException;
import org.ffpojo.metadata.FieldDecorator;
import org.ffpojo.metadata.positional.PositionalFieldDescriptor;
import org.ffpojo.metadata.positional.PositionalRecordDescriptor;
import org.ffpojo.metadata.positional.annotation.PositionalField;
import org.ffpojo.util.ReflectUtil;

class PositionalRecordAnnotationMetadataReader extends AnnotationMetadataReader {

	public PositionalRecordAnnotationMetadataReader(Class<?> clazz) {
		super(clazz);
	}

	@Override
	public PositionalRecordDescriptor readMetadata() throws MetadataReaderException {
		List<PositionalFieldDescriptor> fieldDescriptors = new ArrayList<PositionalFieldDescriptor>();
		Method[] methods = recordClazz.getMethods();
		for (Method method : methods) {
			if(ReflectUtil.isGetter(method)) {
				PositionalField positionalFieldAnnotation = method.getAnnotation(PositionalField.class);								
				if (positionalFieldAnnotation != null) {
					PositionalFieldDescriptor fieldDescriptor = new PositionalFieldDescriptor();
					fieldDescriptor.setInitialPosition(positionalFieldAnnotation.initialPosition());
					fieldDescriptor.setFinalPosition(positionalFieldAnnotation.finalPosition());
					fieldDescriptor.setGetter(method);
					FieldDecorator<?> decorator;
					try {
						decorator = positionalFieldAnnotation.decorator().newInstance();
					} catch (Exception e) {
						throw new MetadataReaderException("Error while instantiating decorator class, make sure that is provided a default constructor for class " + positionalFieldAnnotation.decorator(), e);
					}
					fieldDescriptor.setDecorator(decorator);
					fieldDescriptor.setPaddingAlign(positionalFieldAnnotation.paddingAlign());
					fieldDescriptor.setPaddingCharacter(positionalFieldAnnotation.paddingCharacter());
					fieldDescriptor.setTrimOnRead(positionalFieldAnnotation.trimOnRead());
					fieldDescriptors.add(fieldDescriptor);
				}
			}
		}
		
		PositionalRecordDescriptor recordDescriptor = new PositionalRecordDescriptor(recordClazz, fieldDescriptors);
		recordDescriptor.sortFieldDescriptors();
		recordDescriptor.assertValid();
		
		return recordDescriptor;
	}

}
