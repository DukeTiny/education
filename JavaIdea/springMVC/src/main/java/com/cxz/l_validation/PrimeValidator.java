package com.cxz.l_validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PrimeValidator implements ConstraintValidator<Prime,Integer> {
    private int min;
    private int max;
    @Override
    public void initialize(Prime p) {
        this.min = p.min();
        this.max = p.max();
    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext constraintValidatorContext) {
        if( value==null || value%2==0 ) return false;
        if( value>=min && value<=max ){
            for( int i=2; i*i<=value; i++ ) {
                if(value % i == 0) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
