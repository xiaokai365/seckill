package com.snail.sec.dto;

import java.io.Serializable;

import com.snail.sec.entity.SuccessKilled;

/**
 * 秒杀结果
 * 
 * @author snail
 *
 */
public class SecKillResult implements Serializable {

	// 秒杀物品
	private long secgoodid;
	// 秒杀状态
	private int state;
	// 秒杀状态信息
	private String stateinfo;
	// 秒杀成功的对象
	private SuccessKilled successKilled;

	public SecKillResult(long secgoodid, int state, String stateinfo) {
		super();
		this.secgoodid = secgoodid;
		this.state = state;
		this.stateinfo = stateinfo;
	}

	public SecKillResult(long secgoodid, int state, String stateinfo, SuccessKilled successKilled) {
		super();
		this.secgoodid = secgoodid;
		this.state = state;
		this.stateinfo = stateinfo;
		this.successKilled = successKilled;
	}

	public long getSecgoodid() {
		return secgoodid;
	}

	public void setSecgoodid(long secgoodid) {
		this.secgoodid = secgoodid;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getStateinfo() {
		return stateinfo;
	}

	public void setStateinfo(String stateinfo) {
		this.stateinfo = stateinfo;
	}

	public SuccessKilled getSuccessKilled() {
		return successKilled;
	}

	public void setSuccessKilled(SuccessKilled successKilled) {
		this.successKilled = successKilled;
	}

}
