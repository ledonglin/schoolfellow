package com.flyingbiz.user.entity;

public enum IssueDepartmentType {

	// 发文单位：总后勤部青藏兵站部、总后勤部青藏兵站部司令部、总后勤部青藏兵站部政治部
	STATION_DEPM("总后勤部青藏兵站部"), HEAD_QUATER_DEPM("总后勤部青藏兵站部司令部"), POLITICAL_DEPM(
			"总后勤部青藏兵站部政治部");

	private String isueDepartmentType;

	private IssueDepartmentType(String isueDepartmentType) {
		this.isueDepartmentType = isueDepartmentType;
	}

	@Override
	public String toString() {
		return this.isueDepartmentType;
	}

	public String getIssueDepartmentType() {
		return this.isueDepartmentType;
	}
}
