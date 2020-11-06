package com.example.demo.domain.core;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;

public abstract class EntityBase {
	public <T extends EntityBase> Set<ConstraintViolation<T>> getErrors() {
		return Validation.buildDefaultValidatorFactory().getValidator().validate((T)this);
	}
	
	public boolean isValid() {
		return getErrors().size() == 0;
	}

	public boolean isInvalid() {
		return !isValid();
	}

}
