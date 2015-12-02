// Project:   Deutsche Telekom - SPICA
// Author:    Josef Fuchshuber <josef.fuchshuber@qaware.de>
// Copyright: QAware GmbH
package org.experiment.extensions.annotation;

import org.experiment.extensions.checkers.CheckEnumOwner;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * An annotation to validate the length of {@link java.net.URI}
 */
@Target({METHOD, FIELD, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = CheckEnumOwner.class)
@Documented
public @interface EnumOwner {

    /**
     * Returns the error message.
     */
    //see resources/ValidationMessages.properties
    String message() default "{org.experiment.utils.annotation.enums}";

    /**
     * Returns the validation groups.
     * @return the validation groups.
     */
    Class<?>[] groups() default {};

    /**
     * Returns the payloads.
     * @return the the payloads.
     */
    Class<? extends Payload>[] payload() default {};

    /**
     * Returns an expected enum value
     * @return the maximum length of acceptable string representation.
     */
    Class<? extends Enum> enumType() default Enum.class;
}
