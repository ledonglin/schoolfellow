package com.flyingbiz.user.entity;

public enum SecurityType {
	SECRET("秘密"), CONFIDENTIAL("机密"), TOPSECRET("绝密");

	private String securityType;

	private SecurityType(String securityType) {
		this.securityType = securityType;
	}

	@Override
	public String toString() {
		return this.securityType;
	}

	public String getSecurityType() {
		return this.securityType;
	}
}
