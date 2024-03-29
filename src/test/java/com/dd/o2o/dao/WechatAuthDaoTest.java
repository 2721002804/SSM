package com.dd.o2o.dao;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;

import com.dd.o2o.BaseTest;
import com.dd.o2o.entity.PersonInfo;
import com.dd.o2o.entity.WechatAuth;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class WechatAuthDaoTest extends BaseTest {
	@Autowired
	private WechatAuthDao wechatAuthDao;

	@Test
	public void testAInsertWechatAuth() throws Exception {
		WechatAuth wechatAuth = new WechatAuth();
		PersonInfo personInfo = new PersonInfo();
		personInfo.setUserId(1L);
		wechatAuth.setPersonInfo(personInfo);
		wechatAuth.setOpenId("dafahizhfdhaih");
		wechatAuth.setCreateTime(new Date());
		int effectedNum = wechatAuthDao.insertWechatAuth(wechatAuth);
		assertEquals(1, effectedNum);
	}

	@Test
	public void testBQueryWechatAuthByOpenId() throws Exception {
		WechatAuth wechatAuth = wechatAuthDao.queryWechatInfoByOpenId("dafahizhfdhaih");
		assertEquals("测试", wechatAuth.getPersonInfo().getName());
	}
}
