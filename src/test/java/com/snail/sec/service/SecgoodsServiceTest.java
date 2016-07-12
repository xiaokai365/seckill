package com.snail.sec.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.snail.sec.dto.SecKillInfo;
import com.snail.sec.dto.SecKillResult;
import com.snail.sec.entity.Secgoods;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-dao.xml"
		,"classpath:spring-service.xml"})
public class SecgoodsServiceTest {

	@Autowired
	private SecgoodsService  secgoodsService;
	
	@Test
	public void queryall(){
		List<Secgoods>  list= secgoodsService.queryall();
		System.out.println(list);
	}
	
	@Test
	public void queryById(){
		long secgoodsid=1;
		Secgoods  secgoods=secgoodsService.queryById(secgoodsid);
		System.out.println(secgoods);
	}
	
	@Test
	public void exportSecKillUrl(){
		long secgoodid=3;
		SecKillInfo secgoods=  secgoodsService.exportSecKillUrl(secgoodid);
		System.out.println(secgoods);
	}
	@Test
	public void executeSecKill(){
		long secgoodid=3;
		String userphone="13541284259";
		String md5="4ab299523cb0d1e2388f54c71d3d6c92";
		SecKillResult result= secgoodsService.executeSecKill(secgoodid, userphone, md5);
		System.out.println(result);
	}
	
}
