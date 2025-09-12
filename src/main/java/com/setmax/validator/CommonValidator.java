package com.setmax.validator;

public abstract class CommonValidator {
	private static final int CHAR_LEN_256 = 256;
	protected boolean isStringEmpty(String val) {
		return val == null || val.trim().isEmpty();
	}

	protected boolean isStringValid(String val) {
		return val.length() > CHAR_LEN_256;
	}
}