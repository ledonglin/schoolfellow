package cn.edu.whu.utils;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SMSJob implements Job {

	private static final Logger log = LoggerFactory.getLogger(SMSJob.class);
	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		log.info("+++++++++++++++++++++++++++someProp ++++++++++++++ ");
//		System.out
//				.println("+++++++++++++++++++++++++++someProp ++++++++++++++ ");
	}

}
