package com.flyingbiz.user.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "FILE_INFO")
public class FileInfo {

	private String fileId;
	private String fileName;
	private SecurityType securityType;
	private MediaType mediaType;
	private NoticeType noticeType;
	private FileType fileType;
	private IssueDepartmentType issueDepartmentType;
	private AmountType amountType;
	private HoldType holdType;
	private String keyword;
	private Timestamp uploadTime;
	private Timestamp lastModified;
	private String uploadUserId;

	@Id
	@Column(name = "FILE_ID")
	public String getFileId() {
		return fileId;
	}

	public void setFileId(String fileId) {
		this.fileId = fileId;
	}

	@Column(name = "FILE_NAME")
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "SECURITY_TYPE", nullable = false)
	public SecurityType getSecurityType() {
		return securityType;
	}

	public void setSecurityType(SecurityType securityType) {
		this.securityType = securityType;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "MEDIA_TYPE", nullable = false)
	public MediaType getMediaType() {
		return mediaType;
	}

	public void setMediaType(MediaType mediaType) {
		this.mediaType = mediaType;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "NOTICE_TYPE", nullable = false)
	public NoticeType getNoticeType() {
		return noticeType;
	}

	public void setNoticeType(NoticeType noticeType) {
		this.noticeType = noticeType;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "FILE_TYPE", nullable = false)
	public FileType getFileType() {
		return fileType;
	}

	public void setFileType(FileType fileType) {
		this.fileType = fileType;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "ISSUED_DEPARTMENT", nullable = false)
	public IssueDepartmentType getIssueDepartmentType() {
		return issueDepartmentType;
	}

	public void setIssueDepartmentType(IssueDepartmentType issueDepartmentType) {
		this.issueDepartmentType = issueDepartmentType;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "AMOUNT_TYPE", nullable = false)
	public AmountType getAmountType() {
		return amountType;
	}

	public void setAmountType(AmountType amountType) {
		this.amountType = amountType;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "HOLD_TYPE", nullable = false)
	public HoldType getHoldType() {
		return holdType;
	}

	public void setHoldType(HoldType holdType) {
		this.holdType = holdType;
	}

	@Column(name = "KEYWORD")
	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	@Column(name = "UPLOAD_DATE")
	public Timestamp getUploadTime() {
		return uploadTime;
	}

	public void setUploadTime(Timestamp uploadTime) {
		this.uploadTime = uploadTime;
	}

	@Column(name = "LAST_MODIFIED")
	public Timestamp getLastModified() {
		return lastModified;
	}

	public void setLastModified(Timestamp lastModified) {
		this.lastModified = lastModified;
	}

	@Column(name = "UPLOAD_USER_ID")
	public String getUploadUserId() {
		return uploadUserId;
	}

	public void setUploadUserId(String uploadUserId) {
		this.uploadUserId = uploadUserId;
	}

}
