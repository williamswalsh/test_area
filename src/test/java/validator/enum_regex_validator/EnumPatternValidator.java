package validator.enum_regex_validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 * Annotation to validate if a value matches the provided regular expression.
 * This can be used when binding/deserializing a JSON string to an Enum.
 *
 * Sample Usage:
 * {@code @EnumPattern(regexp = "AUDI|VW|PORSCHE")}
 * CarBrand car;
 *
 * @author William Walsh
 * @version 05 Sep 2022
 */
public class EnumPatternValidator implements ConstraintValidator<EnumPattern, Enum<?>> {
    private Pattern pattern;

    @Override
    public void initialize(EnumPattern annotation) {
        try {
            Class<?> aClass = annotation.enumeration();
            // pattern = Pattern.compile();
        } catch (PatternSyntaxException e) {
            throw new IllegalArgumentException("Given regex is invalid", e);
        }
    }

    @Override
    public boolean isValid(Enum<?> value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }

        Matcher m = pattern.matcher(value.name());
        return m.matches();
    }
}
