package com.snail.sec.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.snail.sec.dao.redis.RedisSecgoodsDao;
import com.snail.sec.entity.Secgoods;

/**
 * 配置spring和junit整合
 * @author snail
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-dao.xml")
public class SecgoodsRedisTest {
	
	@Resource
	private RedisSecgoodsDao   redisSecgoodsDao;
	
	//注入dao依赖
	@Resource
	private SecgoodsDao  secgoodsDao;
	
	@Test
	public  void testRedis() throws ParseException{
		long secgoodsid=3;
		Secgoods  secgoods=  redisSecgoodsDao.getSecgoods(secgoodsid);
		if(secgoods==null){//redis内存里面不存在
			//放入redis
			Secgoods  data= secgoodsDao.queryById(secgoodsid);
			String   result=redisSecgoodsDao.setSecgoods(data);
			System.out.println("放入到redis--->"+result);
		}else{
			System.out.println("从redis获取"+secgoods);
		}
	}

	
}
