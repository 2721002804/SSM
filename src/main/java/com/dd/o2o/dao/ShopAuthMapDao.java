package com.dd.o2o.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dd.o2o.entity.ShopAuthMap;

public interface ShopAuthMapDao {
	List<ShopAuthMap> queryShopAuthMapListByShopId(@Param("shopId") long shopId, @Param("rowIndex") int rowIndex,
			@Param("pageSize") int pageSize);

	// 获取授权总数
	int queryShopAuthCountByShopId(@Param("shopId") long shopId);

	// 新增一条授权关系
	int insertShopAuthMap(ShopAuthMap shopAuthMap);

	int updateShopAuthMap(ShopAuthMap shopAuthMap);

	int deleteShopAuthMap(long shopAuthId);

	ShopAuthMap queryShopAuthMapById(Long shopAuthId);
}
