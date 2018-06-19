package com.issac.foundation.exception;

public class CustomException1 extends BaseException {

    /**
	 * 
	 */
	private static final long serialVersionUID = -4269792675107233054L;

	static String CUSTOM_EXCEPTION_1 = "this is custom exception 1";
	
	public CustomException1() {
        super(CUSTOM_EXCEPTION_1);
    }
}
