package com.dd.o2o.enums;

public enum ShopAuthMapStateEnum {
	CHECK(0, "审核中"), OFFLINE(-1, "非法店铺"), SUCCESS(1, "操作成功"), PASS(2, "通过认证"), INNER_ERROR(-1001,
			"操作失败"), NULL_SHOPAUTH_ID(-1002, "shopAuthId为空"), NULL_SHOPAUTH_INFO(-1003, "shopAuth信息为空");
	private int state;
	private String stateInfo;

	private ShopAuthMapStateEnum(int state, String stateInfo) {
		this.state = state;
		this.stateInfo = stateInfo;
	}

	// 根据传入的state返回相应的enum值
	public static ShopAuthMapStateEnum stateOf(int state) {
		for (ShopAuthMapStateEnum stateEnum : values()) {
			if (stateEnum.getState() == state) {
				return stateEnum;
			}
		}
		return null;
	}

	public int getState() {
		return state;
	}

	public String getStateInfo() {
		return stateInfo;
	}

}
