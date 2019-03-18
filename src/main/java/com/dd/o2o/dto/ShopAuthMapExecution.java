package com.dd.o2o.dto;

import java.util.List;

import com.dd.o2o.entity.ShopAuthMap;
import com.dd.o2o.enums.ShopAuthMapStateEnum;

public class ShopAuthMapExecution {
	// 结果状态
	private int state;
	// 状态标识
	private String stateInfo;
	// 店铺数量
	private int count;
	// 操作的店铺
	private ShopAuthMap shopAuthMap;
	// 店铺列表（查询时用）
	private List<ShopAuthMap> shopAuthMapList;

	public ShopAuthMapExecution() {

	}

	// 失败的构造器
	public ShopAuthMapExecution(ShopAuthMapStateEnum stateEnum) {
		this.state = stateEnum.getState();
		this.stateInfo = stateEnum.getStateInfo();
	}

	// 成功的构造器
	public ShopAuthMapExecution(ShopAuthMapStateEnum stateEnum, ShopAuthMap shopAuthMap) {
		this.state = stateEnum.getState();
		this.stateInfo = stateEnum.getStateInfo();
		this.shopAuthMap = shopAuthMap;
	}

	// 成功的构造器
	public ShopAuthMapExecution(ShopAuthMapStateEnum stateEnum, List<ShopAuthMap> shopAuthMapList) {
		this.state = stateEnum.getState();
		this.stateInfo = stateEnum.getStateInfo();
		this.shopAuthMapList = shopAuthMapList;
	}

	public int getState() {
		return state;
	}

	public String getStateInfo() {
		return stateInfo;
	}

	public int getCount() {
		return count;
	}

	public ShopAuthMap getShopAuthMap() {
		return shopAuthMap;
	}

	public List<ShopAuthMap> getShopAuthMapList() {
		return shopAuthMapList;
	}

	public void setState(int state) {
		this.state = state;
	}

	public void setStateInfo(String stateInfo) {
		this.stateInfo = stateInfo;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public void setShopAuthMap(ShopAuthMap shopAuthMap) {
		this.shopAuthMap = shopAuthMap;
	}

	public void setShopAuthMapList(List<ShopAuthMap> shopAuthMapList) {
		this.shopAuthMapList = shopAuthMapList;
	}

}
