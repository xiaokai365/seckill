package com.snail.sec.dto;
/**
 * 暴露秒杀url
 * @author snail
 *
 */
public class SecKillInfo {
	//是否开启秒杀
	private boolean isopen;
	//加密措施
	private String md5;
	//秒杀物品id
	private long secgoodid;
	//服务器时间
	private long now;
	//秒杀开启时间
	private long start;
	//秒杀结束时间
	private long end;
	
	
	
	public SecKillInfo(boolean isopen, long secgoodid) {
		super();
		this.isopen = isopen;
		this.secgoodid = secgoodid;
	}



	public SecKillInfo(boolean isopen, String md5, long secgoodid) {
		super();
		this.isopen = isopen;
		this.md5 = md5;
		this.secgoodid = secgoodid;
	}
	
	
	
	public SecKillInfo(boolean isopen, long secgoodid, long now, long start, long end) {
		super();
		this.isopen = isopen;
		this.secgoodid = secgoodid;
		this.now = now;
		this.start = start;
		this.end = end;
	}



	public boolean isIsopen() {
		return isopen;
	}
	public void setIsopen(boolean isopen) {
		this.isopen = isopen;
	}
	public String getMd5() {
		return md5;
	}
	public void setMd5(String md5) {
		this.md5 = md5;
	}
	public long getNow() {
		return now;
	}
	public void setNow(long now) {
		this.now = now;
	}
	public long getStart() {
		return start;
	}
	public void setStart(long start) {
		this.start = start;
	}
	public long getEnd() {
		return end;
	}
	public void setEnd(long end) {
		this.end = end;
	}
	public long getSecgoodid() {
		return secgoodid;
	}
	public void setSecgoodid(long secgoodid) {
		this.secgoodid = secgoodid;
	}



	@Override
	public String toString() {
		return "SecKillInfo [isopen=" + isopen + ", md5=" + md5 + ", secgoodid=" + secgoodid + ", now=" + now
				+ ", start=" + start + ", end=" + end + "]";
	}
	
	
	
	
	
}
