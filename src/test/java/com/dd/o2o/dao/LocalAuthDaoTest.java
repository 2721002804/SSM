package com.dd.o2o.dao;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;

import com.dd.o2o.BaseTest;
import com.dd.o2o.entity.LocalAuth;
import com.dd.o2o.entity.PersonInfo;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LocalAuthDaoTest extends BaseTest {
	@Autowired
	private LocalAuthDao localAuthDao;
	private static final String username = "testusername";
	private static final String password = "testpassword";

	@Test
	public void testAInsertLocalAuth() {
		LocalAuth localAuth = new LocalAuth();
		PersonInfo personInfo = new PersonInfo();
		personInfo.setUserId(1L);
		localAuth.setPersonInfo(personInfo);
		localAuth.setUsername(username);
		localAuth.setPassword(password);
		localAuth.setCreateTime(new Date());
		int effectedNum = localAuthDao.insertLocalAuth(localAuth);
		assertEquals(1, effectedNum);
	}

	@Test
	public void testBQueryLocalByUserNameAndPwd() {
		LocalAuth localAuth = localAuthDao.queryLocalByUserNameAndPwd(username, password);
		assertEquals("测试", localAuth.getPersonInfo().getName());
	}

	@Test
	public void testCQueryLocalByUserId() {
		LocalAuth localAuth = localAuthDao.queryLocalByUserId(1L);
		assertEquals("测试", localAuth.getPersonInfo().getName());
	}

	@Test
	public void testDUpdateLocalAuth() {
		Date now = new Date();
		int effectedNum = localAuthDao.updateLocalAuth(1L, username, password, password + "new", now);
		assertEquals(1, effectedNum);
		LocalAuth localAuth = localAuthDao.queryLocalByUserId(1L);
		System.out.println(localAuth.getPassword());
	}
}
