package com.flyingbiz.user.entity;

public enum NoticeType {

	// 文种：通知、通报、报告 、请示、批复、命令、通令、决定、指示、通告、函、会议纪要

	// Practice: notice, CALL, report, ask for instructions and approval,
	// command, orders, decisions, instructions, notices, letter, meeting
	// minutes

	NOTICE("通知"), CALL("通报"), REPORT("报告"), ASK_FOR_INSTRUCTION("请示"), ASK_FOR_APPROVAL(
			"批复"), COMMAND("命令"), ORDER("通令"), DECISION("决定"), INSTRUCTION("指示"), NOTICES(
			"通告"), LETTER("函"), MEETING_MINUTES("会议纪要");

	private String noticeType;

	private NoticeType(String noticeType) {
		this.noticeType = noticeType;
	}

	@Override
	public String toString() {
		return this.noticeType;
	}

	public String getNoticeType() {
		return this.noticeType;
	}
}
