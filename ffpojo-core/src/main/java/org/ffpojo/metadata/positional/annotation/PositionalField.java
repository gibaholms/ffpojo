package org.ffpojo.metadata.positional.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.ffpojo.metadata.DefaultFieldDecorator;
import org.ffpojo.metadata.FieldDecorator;
import org.ffpojo.metadata.positional.PaddingAlign;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface PositionalField {
	int initialPosition();
	int finalPosition();
	PaddingAlign paddingAlign() default PaddingAlign.RIGHT;
	char paddingCharacter() default ' ';
	boolean trimOnRead() default true;
	Class<? extends FieldDecorator<?>> decorator() default DefaultFieldDecorator.class; 
}
