package com.flyingbiz.user.entity;

public enum FileType {

	// 文本：正本、副本、定稿、草稿、手稿
	// Text: the original , Copies, finalized, the draft, the manuscript

	ORIGINAL("正本"), COPY("副本"), FINALIZE("定稿"), DRAFT("草稿"), MANUSCRITP("手稿");

	private String fileType;

	private FileType(String fileType) {
		this.fileType = fileType;
	}

	@Override
	public String toString() {
		return this.fileType;
	}

	public String getFileType() {
		return this.fileType;
	}
}
