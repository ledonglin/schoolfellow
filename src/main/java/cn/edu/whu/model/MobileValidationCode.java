package cn.edu.whu.model;

import java.util.Date;

public class MobileValidationCode {

	private String mobileCode;
	private Date time;

	public MobileValidationCode(String mobileCode, Date time) {
		super();
		this.mobileCode = mobileCode;
		this.time = time;
	}

	public String getMobileCode() {
		return mobileCode;
	}

	public void setMobileCode(String mobileCode) {
		this.mobileCode = mobileCode;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

}
