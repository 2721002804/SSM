package com.dd.o2o.service;

import com.dd.o2o.dto.ShopAuthMapExecution;
import com.dd.o2o.entity.ShopAuthMap;
import com.dd.o2o.exceptions.ShopAuthMapOperationException;

public interface ShopAuthMapService {
	/**
	 * 
	 * @param shopId
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	ShopAuthMapExecution listShopAuthMapByShopId(Long shopId, Integer pageIndex, Integer pageSize);

	/**
	 * 
	 * @param shopAuthMap
	 * @return
	 * @throws RuntimeException
	 */
	ShopAuthMapExecution addShopAuthMap(ShopAuthMap shopAuthMap) throws ShopAuthMapOperationException;

	/**
	 * 更新授权信息，包括职位等
	 * 
	 * @param shopAuthId
	 * @param title
	 * @param titleFlag
	 * @param enableStatus
	 * @return
	 * @throws RuntimeException
	 */
	ShopAuthMapExecution modifyShopAuthMap(ShopAuthMap shopAuthMap) throws ShopAuthMapOperationException;

	/**
	 * 
	 * @param shopAuthMapId
	 * @return
	 * @throws RuntimeException
	 */
	ShopAuthMapExecution removeShopAuthMap(Long shopAuthMapId) throws ShopAuthMapOperationException;

	/**
	 * 
	 * @param shopAuthId
	 * @return
	 */
	ShopAuthMap getShopAuthMapById(Long shopAuthId);

}
