package cn.edu.whu.job;

import java.util.Date;
import java.util.Set;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.edu.whu.model.SMSValidatePair;
import cn.edu.whu.utils.Config;
import cn.edu.whu.utils.SMSJob;

public class MobileValidationJob implements Job {

	private static final Logger log = LoggerFactory.getLogger(SMSJob.class);
	private Config config = Config.getConfig("schoolFellow.properties");

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		log.debug("--check MobileValidation--");
		Set<String> keySet = SMSValidatePair.SMSPair.keySet();
		for (String key : keySet) {
			Date date = SMSValidatePair.SMSPair.get(key).getTime();
			Date now = new Date();
			if (now.getTime() - date.getTime() > config.getInt("expireTime")*1000) {
				SMSValidatePair.SMSPair.remove(key);
				log.info(key + "has expired");
			}
			log.info(SMSValidatePair.SMSPair.toString());
		}
	}
}
