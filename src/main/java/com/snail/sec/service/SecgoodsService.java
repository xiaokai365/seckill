package com.snail.sec.service;

import java.util.List;

import com.snail.sec.dto.SecKillInfo;
import com.snail.sec.dto.SecKillResult;
import com.snail.sec.entity.Secgoods;

/**
 * 秒杀service
 * @author snail
 *
 */
public interface SecgoodsService {

	//查询所有的秒杀物品
	List<Secgoods>   queryall();
	
	//根据物品id查询
	Secgoods    queryById(long secgoodsid);
	
	//秒杀开启输入秒杀地址
	//否则输出系统时间，秒杀时间
	SecKillInfo     exportSecKillUrl(long secgoodid);
	
	//执行秒杀
	SecKillResult executeSecKill(long secgoodid,String userphone,String md5);
	
}
