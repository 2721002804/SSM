package com.dd.o2o.service;

import static org.junit.Assert.assertEquals;

import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;

import com.dd.o2o.BaseTest;
import com.dd.o2o.dto.LocalAuthExecution;
import com.dd.o2o.entity.LocalAuth;
import com.dd.o2o.entity.PersonInfo;
import com.dd.o2o.enums.LocalAuthStateEnum;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LocalAuthServiceTest extends BaseTest {
	@Autowired
	private LocalAuthService localAuthService;

	@Test
	@Ignore
	public void testABindLocalAuth() {
		LocalAuth localAuth = new LocalAuth();
		PersonInfo personInfo = new PersonInfo();
		String username = "testusername";
		String password = "testpassword";
		personInfo.setUserId(1L);
		localAuth.setPersonInfo(personInfo);
		localAuth.setUsername(username);
		localAuth.setPassword(password);
		LocalAuthExecution lae = localAuthService.bindLocalAuth(localAuth);
		assertEquals(LocalAuthStateEnum.SUCCESS.getState(), lae.getState());
		localAuth = localAuthService.getLocalAuthByUserId(personInfo.getUserId());
		System.out.println("用户昵称：" + localAuth.getPersonInfo().getName());
		System.out.println("密码：" + localAuth.getPassword());
	}

	@Test
	public void testBModifyLocalAuth() {
		long userId = 1L;
		String username = "testusername";
		String password = "testpassword";
		String newPassword = "testnewpassword";
		LocalAuthExecution lae = localAuthService.modifyLocalAuth(userId, username, password, newPassword);
		assertEquals(LocalAuthStateEnum.SUCCESS.getState(), lae.getState());
		LocalAuth localAuth = localAuthService.getLocalAuthByUserNameAndPwd(username, newPassword);
		System.out.println(localAuth.getPersonInfo().getName());
	}
}
