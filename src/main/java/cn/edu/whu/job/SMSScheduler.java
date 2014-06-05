package cn.edu.whu.job;

import static org.quartz.TriggerBuilder.newTrigger;

import java.util.Date;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

import cn.edu.whu.model.MobileValidationCode;
import cn.edu.whu.model.SMSValidatePair;

public class SMSScheduler {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			SMSValidatePair.SMSPair.put("13349886987-" + i,
					new MobileValidationCode("123456", new Date()));
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// SMSValidatePair.SMSPair.put("15042311248", new
		// MobileValidationCode("111111", new Date()));

		SchedulerFactory sf = new StdSchedulerFactory();
		Scheduler scheduler;
		try {
			scheduler = sf.getScheduler();
			JobDetail job = JobBuilder.newJob(MobileValidationJob.class)
					.withIdentity("job1", "group1").build();
			Trigger tirgger = newTrigger().withIdentity("trigger1", "group1")
					.withSchedule(SimpleScheduleBuilder.simpleSchedule()
					// .withIntervalInMinutes(1)
							.withIntervalInSeconds(1).repeatForever())
					.startNow().build();

			scheduler.start();
			scheduler.scheduleJob(job, tirgger);
		} catch (SchedulerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
