package com.flyingbiz.user.entity;

public enum MediaType {

	PAPER("纸张"), PAINTING("印刷本"), PHOTO("照片"), PHOTOGRAPHICFILM("胶片"), FILE(
			"胶卷"), TAPE("磁带"), DISK("磁盘"), CD("光盘");

	private String mediaType;

	private MediaType(String mediaType) {
		this.mediaType = mediaType;
	}

	@Override
	public String toString() {
		return this.mediaType;
	}

	public String getMediaType() {
		return this.mediaType;
	}
}
