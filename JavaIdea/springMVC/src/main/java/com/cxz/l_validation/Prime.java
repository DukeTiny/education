package com.cxz.l_validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {PrimeValidator.class})
public @interface Prime {

    String message() default "我要质数啊，这不是质数";

    int min();
    int max();

    Class<?>[] groups() default{};

    Class<? extends Payload>[] payload() default{};

}
