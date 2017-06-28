package com.autoiq.common.utility;

/**
 * This class is created for handle the custom exception
 * 
 * @author bharatp : 11/04/2017
 *
 */
public class HandleException extends Exception {
	private static final long serialVersionUID = 1L;

	public HandleException(String message) {

		super(message);
		System.out.println(message);
		Log.debug(message);
	}
}
