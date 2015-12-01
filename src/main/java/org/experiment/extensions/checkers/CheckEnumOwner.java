// Project:   Deutsche Telekom - SPICA
// Author:    Josef Fuchshuber <josef.fuchshuber@qaware.de>
// Copyright: QAware GmbH
package org.experiment.extensions.checkers;

import org.experiment.extensions.annotation.EnumOwner;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;

/**
 * A constraint validator for string lengths.
 */
public class CheckEnumOwner implements ConstraintValidator<EnumOwner, String> {

    private Class<? extends Enum> enumType;

    /**
     * {@inheritDoc}
     */
    @Override
    public void initialize(EnumOwner enumValue) {
        this.enumType = enumValue.enumType();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isValid(String string, ConstraintValidatorContext constraintValidatorContext) {
        if (StringUtils.isEmpty(string)) {
            return false;
        } else {
            if (enumType.isEnum()) {
                return Arrays.stream(enumType.getEnumConstants()).anyMatch(v -> v.name().equals(string));
            }
            return false;
        }
    }
}
