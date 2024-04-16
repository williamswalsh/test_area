//package validator.enum_regex_validator;
//
//import javax.validation.Constraint;
//import javax.validation.Payload;
//import java.lang.annotation.ElementType;
//import java.lang.annotation.Retention;
//import java.lang.annotation.RetentionPolicy;
//import java.lang.annotation.Target;
//
///**
// * @author William Walsh
// * @version 07 Sep 2022
// */
//@Constraint(validatedBy = EnumPatternValidator.class)
//@Target({ ElementType.FIELD})
//@Retention(RetentionPolicy.RUNTIME)
//public @interface EnumPattern {
//    Class <?> enumeration();
//    String regexp();
//    String message() default "must match \"{regexp}\"";
//    Class<?>[] groups() default {};
//    Class<? extends Payload>[] payload() default {};
//}
