package org.ffpojo.metadata;

import org.ffpojo.exception.FieldDecoratorException;



public interface FieldDecorator<T> {

	public String toString(T field) throws FieldDecoratorException;
	
	public T fromString(String field) throws FieldDecoratorException;
	
}
