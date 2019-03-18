package com.dd.o2o.dao;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;

import com.dd.o2o.BaseTest;
import com.dd.o2o.entity.PersonInfo;
import com.dd.o2o.entity.Shop;
import com.dd.o2o.entity.ShopAuthMap;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ShopAuthMapDaoTest extends BaseTest {
	@Autowired
	private ShopAuthMapDao shopAuthMapDao;

	@Test
	public void testAInsertShopAuthMap() throws Exception {
		ShopAuthMap shopAuthMap1 = new ShopAuthMap();
		PersonInfo employee = new PersonInfo();
		employee.setUserId(1L);
		shopAuthMap1.setEmployee(employee);
		Shop shop = new Shop();
		shop.setShopId(1L);
		shopAuthMap1.setShop(shop);
		shopAuthMap1.setTitle("CEO");
		shopAuthMap1.setTitleFlag(1);
		shopAuthMap1.setCreateTime(new Date());
		shopAuthMap1.setLastEditTime(new Date());
		shopAuthMap1.setEnableStatus(1);
		int effectedNum = shopAuthMapDao.insertShopAuthMap(shopAuthMap1);
		assertEquals(1, effectedNum);
	}

	@Test
	public void testBQueryShopAuth() throws Exception {
		List<ShopAuthMap> shopAuthMapList = shopAuthMapDao.queryShopAuthMapListByShopId(1, 0, 1);
		assertEquals(1, shopAuthMapList.size());
		ShopAuthMap shopAuth = shopAuthMapDao.queryShopAuthMapById(shopAuthMapList.get(0).getShopAuthId());
		assertEquals("CEO", shopAuth.getTitle());
		int count = shopAuthMapDao.queryShopAuthCountByShopId(1);
		assertEquals(1, count);
	}

	@Test
	public void testCUpdateShopAuthMap() throws Exception {
		ShopAuthMap shopAuthMap = new ShopAuthMap();
		shopAuthMap.setShopAuthId(1L);
		shopAuthMap.setTitle("CCO");
		shopAuthMap.setTitleFlag(2);
		int effectedNum = shopAuthMapDao.updateShopAuthMap(shopAuthMap);
		assertEquals(1, effectedNum);
	}

	@Test
	public void testDeleteShopAuthMap() throws Exception {
		long employeeId = 1L;
		int effectedNum = shopAuthMapDao.deleteShopAuthMap(employeeId);
		assertEquals(1, effectedNum);
	}
}
