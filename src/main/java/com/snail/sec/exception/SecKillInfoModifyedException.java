package com.snail.sec.exception;

/**
 * 秒杀信息被篡改异常
 * @author snail
 *
 */
public class SecKillInfoModifyedException extends RuntimeException{

	public SecKillInfoModifyedException(String message, Throwable cause) {
		super(message, cause);
	}

	public SecKillInfoModifyedException(String message) {
		super(message);
	}


	
}
