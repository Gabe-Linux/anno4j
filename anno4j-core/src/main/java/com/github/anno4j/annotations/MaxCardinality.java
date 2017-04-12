package com.github.anno4j.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * An annotation specifying how many values a property must at most have.
 * Corresponds to <a href="https://www.w3.org/TR/owl-ref/#maxCardinality-def">owl:maxCardinality</a>.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD, ElementType.METHOD})
public @interface MaxCardinality {

    /**
     * @return Returns the number of values that the property can at most have.
     */
    int value();
}
