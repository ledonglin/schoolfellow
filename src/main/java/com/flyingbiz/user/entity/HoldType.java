package com.flyingbiz.user.entity;

public enum HoldType {

	FOREVER("永久"), FIXDATE("定期");

	private String holdType;

	private HoldType(String holdType) {
		this.holdType = holdType;
	}

	@Override
	public String toString() {
		return this.holdType;
	}

	public String getHoldType() {
		return this.holdType;
	}
}
