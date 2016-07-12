package com.snail.sec.exception;

/**
 * 秒杀关闭异常
 * @author snail
 *
 */
public class SecKillCloseException extends RuntimeException{

	public SecKillCloseException(String message, Throwable cause) {
		super(message, cause);
	}

	public SecKillCloseException(String message) {
		super(message);
	}

	
	
}
