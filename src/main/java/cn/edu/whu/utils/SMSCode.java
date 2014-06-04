package cn.edu.whu.utils;

import static org.quartz.TriggerBuilder.newTrigger;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

public class SMSCode {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		SchedulerFactory sf = new StdSchedulerFactory();
		Scheduler scheduler;
		try {
			scheduler = sf.getScheduler();
			JobDetail job = JobBuilder.newJob(SMSJob.class)
					.withIdentity("job1", "group1").build();
			Trigger tirgger = newTrigger()
					.withIdentity("trigger1", "group1")
					.withSchedule(
							SimpleScheduleBuilder.simpleSchedule()
									.withIntervalInSeconds(5).repeatForever())
					.startNow().build();

			scheduler.start();
			scheduler.scheduleJob(job, tirgger);
		} catch (SchedulerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Thread.sleep(90L * 1000L);
		// scheduler.shutdown();
	}

}
