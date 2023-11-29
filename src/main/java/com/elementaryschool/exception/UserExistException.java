/**
 * 
 */
package com.elementaryschool.exception;

/**
 * @author sebad
 *
 */
public class UserExistException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5126952231381595695L;

	public UserExistException() {
		super();
	}
    public UserExistException(String message) {
        super(message);
    }
	public UserExistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
	public UserExistException(String message, Throwable cause) {
		super(message, cause);

	}
	public UserExistException(Throwable cause) {
		super(cause);

	}
    
}
