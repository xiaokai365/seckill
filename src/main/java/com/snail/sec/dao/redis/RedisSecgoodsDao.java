package com.snail.sec.dao.redis;

import com.dyuproject.protostuff.LinkedBuffer;
import com.dyuproject.protostuff.ProtostuffIOUtil;
import com.dyuproject.protostuff.runtime.RuntimeSchema;
import com.snail.sec.entity.Secgoods;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class RedisSecgoodsDao {

	// redisip
	private String ipaddress;
	// redis port
	private int port;

	private final JedisPool jedisPool;

	private RuntimeSchema<Secgoods> schema = RuntimeSchema.createFrom(Secgoods.class);

	public RedisSecgoodsDao(String ipaddress, int port) {
		jedisPool = new JedisPool(ipaddress, port);
	}

	public String setSecgoods(Secgoods secgoods) {
		try {
			Jedis jedis = jedisPool.getResource();
			//Jedis jedis = new Jedis("192.168.186.135");
			try {
				String key = "secgoodsid:" + secgoods.getSecgoodid();
				byte[] datas = ProtostuffIOUtil.toByteArray(secgoods, schema,
						LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE));
				// 超时缓存 1小时后过期
				String  result= jedis.setex(key.getBytes(), 60 * 60, datas);
				return result;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				jedis.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "系统错误";
	}

	public Secgoods getSecgoods(Long secgoodsid) {
		try {
			Jedis jedis = jedisPool.getResource();
			//Jedis jedis = new Jedis("192.168.186.135");
			try {
				String key = "secgoodsid:" + secgoodsid;
				byte[] bs = jedis.get(key.getBytes());
				if(bs!=null){
					Secgoods secgoods=schema.newMessage();
					ProtostuffIOUtil.mergeFrom(bs, secgoods, schema);
					return secgoods;
				}
			} catch (Exception e) {
			}finally {
				jedis.close();
			}
		} catch (Exception e) {

		}
		return null;
	}

}
