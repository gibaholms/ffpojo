package org.ffpojo.metadata.delimited.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.ffpojo.metadata.DefaultFieldDecorator;
import org.ffpojo.metadata.FieldDecorator;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface DelimitedField {
	int positionIndex();
	Class<? extends FieldDecorator<?>> decorator() default DefaultFieldDecorator.class;
}
