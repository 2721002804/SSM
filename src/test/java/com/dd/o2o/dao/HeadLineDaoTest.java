package com.dd.o2o.dao;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;

import com.dd.o2o.BaseTest;
import com.dd.o2o.entity.HeadLine;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HeadLineDaoTest extends BaseTest {
	@Autowired
	private HeadLineDao headLineDao;

	@Test
	@Ignore
	public void testAInsertHeadLine() throws Exception {
		HeadLine headLine = new HeadLine();
		headLine.setLineName("头条1");
		headLine.setLineLink("头条1");
		headLine.setLineImg("test1");
		headLine.setPriority(1);
		headLine.setCreateTime(new Date());
		headLine.setLastEditTime(new Date());
		headLine.setEnableStatus(1);
		int effectedNum = headLineDao.insertHeadLine(headLine);
		assertEquals(1, effectedNum);
	}

	@Test
	public void testBQueryHeadLine() throws Exception {
		List<HeadLine> headLineList = headLineDao.queryHeadLine(new HeadLine());
		assertEquals(1, headLineList.size());
	}

	@Test
	@Ignore
	public void testCUpdateHeadLine() throws Exception {
		HeadLine headLine = new HeadLine();
		headLine.setLineId(1L);
		headLine.setLineName("未来头条");
		headLine.setLastEditTime(new Date());
		int effectedNum = headLineDao.updateHeadLine(headLine);
		assertEquals(1, effectedNum);
	}

	@Test
	@Ignore
	public void testDDeleteHeadLine() throws Exception {
		long lineId = -1;
		List<HeadLine> headLineList = headLineDao.queryHeadLine(new HeadLine());
		for (HeadLine headLine : headLineList) {
			if ("头条1".equals(headLine.getLineName())) {
				lineId = headLine.getLineId();
			}
		}
		int effectedNum = headLineDao.deleteHeadLine(lineId);
		assertEquals(1, effectedNum);
	}
}
