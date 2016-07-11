package com.snail.sec.entity;

import java.util.Date;

/**
 * Created by snail on 2016/7/7.
 */
public class SuccessKilled  {

    private long secgoodid;

    private String userphone;

    private short state;

    private Date createtime;

    //多对一
    /**
     * 多个秒杀记录对应一个商品
      */
    private  Secgoods secgoods;

  

  

	public long getSecgoodid() {
		return secgoodid;
	}

	public void setSecgoodid(long secgoodid) {
		this.secgoodid = secgoodid;
	}



	public String getUserphone() {
		return userphone;
	}

	public void setUserphone(String userphone) {
		this.userphone = userphone;
	}

	public short getState() {
        return state;
    }

    public void setState(short state) {
        this.state = state;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Secgoods getSecgoods() {
        return secgoods;
    }

    public void setSecgoods(Secgoods secgoods) {
        this.secgoods = secgoods;
    }

	@Override
	public String toString() {
		return "SuccessKilled [secgoodid=" + secgoodid + ", userphone=" + userphone + ", state=" + state
				+ ", createtime=" + createtime + ", secgoods=" + secgoods + "]";
	}

	

	

   
}
