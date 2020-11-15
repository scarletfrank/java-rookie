package pro.scarlet.trig;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

import pro.scarlet.job.HelloJob;

public class HelloDemo {
    public static void main(String[] args) throws SchedulerException {
        // 1. 调度器 Schduler，从工厂中获取调度器实例
        Scheduler stdScheduler = StdSchedulerFactory.getDefaultScheduler();

        // 2. 任务实例 JobDetail
        // 参数 1：任务的名称；参数 2：任务组的名称
        JobDetail jobDetail = JobBuilder.newJob(HelloJob.class)
                .withIdentity("job1", "jobGroup1")
                .build();

        // 3. 触发器 Trigger
        // 参数 1：触发器的名称；参数 2：触发器组的名称
        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("trigger1", "triggerGroup1")
                .withSchedule(SimpleScheduleBuilder.simpleSchedule().repeatSecondlyForever(5))
                .startNow()
                .build();

        // 4. 通过调度器将触发器与任务实例关联，保证按照触发器定义的条件执行任务
        stdScheduler.scheduleJob(jobDetail, trigger);

        // 5. 启动
        stdScheduler.start();
    }
}
