package cn.edu.whu.exception;

public class TimeExpireException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TimeExpireException() {
		super();
	}

	public TimeExpireException(String msg) {
		super(msg);
	}

	public TimeExpireException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public TimeExpireException(Throwable cause) {
		super(cause);
	}
}
