package com.snail.sec.exception;

/**
 * 重复秒杀异常
 * @author snail
 *
 */
public class RepeatSecKillException extends RuntimeException{

	public RepeatSecKillException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public RepeatSecKillException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	
	
}
