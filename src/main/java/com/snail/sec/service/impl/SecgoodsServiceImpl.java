package com.snail.sec.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import com.snail.sec.constant.CommonConstant;
import com.snail.sec.dao.SecgoodsDao;
import com.snail.sec.dao.SuccessKilledDao;
import com.snail.sec.dto.SecKillInfo;
import com.snail.sec.dto.SecKillResult;
import com.snail.sec.entity.Secgoods;
import com.snail.sec.entity.SuccessKilled;
import com.snail.sec.exception.RepeatSecKillException;
import com.snail.sec.exception.SecKillCloseException;
import com.snail.sec.exception.SecKillInfoModifyedException;
import com.snail.sec.service.SecgoodsService;

@Service
public class SecgoodsServiceImpl implements SecgoodsService {
	
	private final Logger  logger=LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private SecgoodsDao secgoodsDao;
	@Autowired
	private SuccessKilledDao successKilledDao;

	private final String secret = "sdjfdkjs76s8*9809ds??><";

	@Override
	public List<Secgoods> queryall() {
		return secgoodsDao.queryall(0, 100);
	}

	@Override
	public Secgoods queryById(long secgoodsid) {
		return secgoodsDao.queryById(secgoodsid);
	}

	@Override
	public SecKillInfo exportSecKillUrl(long secgoodid) {
		Secgoods secgood = secgoodsDao.queryById(secgoodid);
		if (secgood == null) {
			return new SecKillInfo(false, secgoodid);// 没有该秒杀物品
		}
		Date start = secgood.getStarttime();
		Date end = secgood.getEndtime();
		Date now = new Date();
		if (now.getTime() > end.getTime() || now.getTime() < start.getTime()) {
			return new SecKillInfo(false, secgoodid, now.getTime(), start.getTime(), end.getTime());
		}

		String md5 = getMd5(secgoodid);
		return new SecKillInfo(true, md5, secgoodid);
	}

	private String getMd5(long secgoodid) {
		String data = secret + "/" + secgoodid;
		return DigestUtils.md5DigestAsHex(data.getBytes());
	}

	@Override
	/**
	 * 执行秒杀
	 */
	@Transactional
	public SecKillResult executeSecKill(long secgoodid, String userphone, String md5) {
		Secgoods secgood = secgoodsDao.queryById(secgoodid);
		if (secgood == null || !getMd5(secgoodid).equals(md5)) {
			logger.info("", "秒杀信息被篡改异常");
			throw new SecKillInfoModifyedException("秒杀信息被篡改异常");
		}
		// 执行秒杀逻辑减库存增加记录
		int updatecount = secgoodsDao.reducenumber(secgoodid, new Date());
		if (updatecount <= 0) {
			// 减库存失败
			throw new SecKillCloseException("秒杀已经关闭");
		}else{
			//减库存成功  执行插入记录
			int insertcont=successKilledDao.insertSuccess(secgoodid, userphone);
			if(insertcont<=0){
				//重复秒杀或者秒杀失败
				throw new RepeatSecKillException("重复秒杀");
			}else{
				//秒杀成功
				SuccessKilled  successKilled=successKilledDao.querySuccessWithSecGoods(secgoodid, userphone);
				return new SecKillResult(secgoodid, CommonConstant.SUCCESS_CODE, CommonConstant.SUCCESS_INFO, successKilled);
			}
		}
	}
}
