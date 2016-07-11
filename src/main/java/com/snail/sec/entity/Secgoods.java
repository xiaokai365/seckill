package com.snail.sec.entity;

import java.util.Date;

/**
 * 秒杀库存表
 */
public class Secgoods{

    private Long secgoodid;//

    private String name;

    private int number;

    private Date starttime;

    private Date endtime;

    private Date createtime;


   

    public Long getSecgoodid() {
		return secgoodid;
	}

	public void setSecgoodid(Long secgoodid) {
		this.secgoodid = secgoodid;
	}

	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

	@Override
	public String toString() {
		return "Secgoods [secgoodid=" + secgoodid + ", name=" + name + ", number=" + number + ", starttime=" + starttime
				+ ", endtime=" + endtime + ", createtime=" + createtime + "]";
	}
    
    
}
