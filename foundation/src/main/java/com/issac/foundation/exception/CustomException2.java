package com.issac.foundation.exception;

public class CustomException2 extends BaseException {

    /**
	 * 
	 */
	private static final long serialVersionUID = -107201681629521962L;

	static String CUSTOM_EXCEPTION_2 = "this is custom exception 2";
	
	public CustomException2() {
        super(CUSTOM_EXCEPTION_2);
    }
}
