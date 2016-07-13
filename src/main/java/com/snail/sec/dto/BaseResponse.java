package com.snail.sec.dto;

import java.io.Serializable;

/**
 * 基础的vo返回
 * @author snail
 *
 * @param <T>
 */
public class BaseResponse<T> implements Serializable{
	
	private boolean flag;
	
	private T data;
	
	private String errorinfo;

	
	public BaseResponse(boolean flag, String errorinfo) {
		super();
		this.flag = flag;
		this.errorinfo = errorinfo;
	}

	public BaseResponse(boolean flag, T data) {
		super();
		this.flag = flag;
		this.data = data;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getErrorinfo() {
		return errorinfo;
	}

	public void setErrorinfo(String errorinfo) {
		this.errorinfo = errorinfo;
	}
	
	
	
	

}
