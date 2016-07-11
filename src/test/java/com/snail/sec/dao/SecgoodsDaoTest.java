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

import com.snail.sec.entity.Secgoods;

/**
 * 配置spring和junit整合
 * @author snail
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-dao.xml")
public class SecgoodsDaoTest {
	
	//注入dao依赖
	@Resource
	private SecgoodsDao  secgoodsDao;
	
	@Test
	public  void testReducenumber() throws ParseException{
		SimpleDateFormat  format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date  date=  format.parse("2016-07-06 15:45:44");
		int  num=secgoodsDao.reducenumber(2l, date);
		System.out.println(num);
	}

	@Test
	public void testQueryById(){
		Long secgoodsid=1l;
		Secgoods  secgoods=  secgoodsDao.queryById(secgoodsid);
		System.out.println(secgoods);
	}
	@Test
	public void queryall(){
		List<Secgoods>  all= secgoodsDao.queryall(0, 100);
		System.out.println(all);
	}
}
