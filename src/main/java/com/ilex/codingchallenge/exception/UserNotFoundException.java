package com.ilex.codingchallenge.exception;

/**
 * @author Vincent Geng
 *
 * Created on Dec 19, 2020
 */
public class UserNotFoundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4534182023911545139L;

	public UserNotFoundException(Long id) {
        super("User id not found : " + id);
    }
}
