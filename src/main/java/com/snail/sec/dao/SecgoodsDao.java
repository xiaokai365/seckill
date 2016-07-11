package com.snail.sec.dao;

import com.snail.sec.entity.Secgoods;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * Created by snail on 2016/7/7.
 */
public interface SecgoodsDao {


    /**
     * 库存减1
     * @param secgoodsid
     * @param killTime
     * @return 如果影响行数等于1，表示更新行数
     */
    int reducenumber(@Param("secgoodsid")Long secgoodsid, @Param("killTime")Date killTime);

    /**
     * 查询库存根据id
     * @param secgoodsid
     * @return
     */
    Secgoods queryById(Long secgoodsid);


    /**
     * 查询
     * @param offet
     * @param limit
     * @return
     */
    List<Secgoods> queryall(@Param("offet")int offet,@Param("limit")int limit);



}
