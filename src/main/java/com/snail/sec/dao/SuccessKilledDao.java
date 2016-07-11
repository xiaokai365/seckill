package com.snail.sec.dao;

import org.apache.ibatis.annotations.Param;

import com.snail.sec.entity.SuccessKilled;

/**
 * 
 * @author snail
 *
 */
public interface SuccessKilledDao {

	/**
	 * 
	 * @param successKilled
	 * @return 插入的行数 0表示失败
	 */
	int insertSuccess(SuccessKilled successKilled);
	
	/**
	 * 
	 * @param secGoodsid
	 * @param userphone
	 * @return 插入的行数 0表示失败
	 */
	int insertSuccess(@Param("secGoodsid")Long secGoodsid,@Param("userphone")String userphone);
	
	/**
	 * 
	 * @param secGoodsid
	 * @return
	 */
   SuccessKilled	 querySuccessWithSecGoods(@Param("secGoodsid")Long secGoodsid,@Param("userphone")String userphone);
	
}
