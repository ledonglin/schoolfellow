package cn.edu.whu.model;

import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.edu.whu.exception.TimeExpireException;
import cn.edu.whu.utils.Config;

public class SMSValidatePair extends ConcurrentHashMap<String, String> {
	private static final Logger logger = LoggerFactory
			.getLogger(SMSValidatePair.class);

	private String mobileCode;
	private String mobile;
	private Config config = Config.getConfig("schoolFellow.properties");

	public static ConcurrentHashMap<String, MobileValidationCode> SMSPair = new ConcurrentHashMap<String, MobileValidationCode>();

	@SuppressWarnings("deprecation")
	public synchronized void add(String mobile, String mobileCode)
			throws TimeExpireException {
		MobileValidationCode code = SMSPair.get(mobile);
		if (null != code) {
			int expireTime = Integer.parseInt(config.get("expireTiem"));
			Date date = code.getTime();
			Date now = new Date();
			if ((now.getTime() - date.getTime() > expireTime * 1000)) {
				throw new TimeExpireException(
						"the validation code have sent to your phone, plesas wait...");

			}
		} else {
			MobileValidationCode validator = new MobileValidationCode(
					mobileCode, new Date());
			SMSPair.put(mobile, validator);
			logger.info("validation code has been put into SMSPair at"
					+ validator.getTime());
		}

	}

	public MobileValidationCode getMobileValidationCode(String mobile) {
		return SMSPair.get(mobile);
	}

	public synchronized void remove(String mobile) {
		if (null != getMobileValidationCode(mobile))
			SMSPair.remove(mobile);
	}
}
