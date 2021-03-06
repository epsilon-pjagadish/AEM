package com.citraining.core.request.param;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.apache.sling.models.annotations.Source;
import org.apache.sling.models.spi.injectorspecific.InjectAnnotation;

@Target ({ ElementType.FIELD })
@Retention (RetentionPolicy.RUNTIME)
@InjectAnnotation
@Source ("request-parameter")
public @interface RequestParameter {
	boolean optional() default false;

	String regexp() default "";
}
