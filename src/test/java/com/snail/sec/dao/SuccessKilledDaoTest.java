package com.snail.sec.dao;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.snail.sec.entity.SuccessKilled;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-dao.xml")
public class SuccessKilledDaoTest {

	@Resource
	private SuccessKilledDao  successKilledDao;
	
	@Test
	public void insertSuccess(){
		int num=successKilledDao.insertSuccess(1l, "13541284259");
		System.out.println(num);
	}
	
	@Test
	public void testquerySuccessWithSecGoods(){
		SuccessKilled killed=  successKilledDao.querySuccessWithSecGoods(1l, "13541284259");
		System.out.println(killed);
	}
}
