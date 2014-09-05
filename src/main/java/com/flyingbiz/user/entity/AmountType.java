package com.flyingbiz.user.entity;

public enum AmountType {

	// 数量单位：张、页、卷、册、盒、盘
	PIECE("张"), PAGE("页"), VOLUME("卷"), BOOK("册"), BOX("盒"), DISK("盘");

	private String amountType;

	private AmountType(String amountType) {
		this.amountType = amountType;
	}

	@Override
	public String toString() {
		return this.amountType;
	}

	public String getAmountType() {
		return this.amountType;
	}
}
