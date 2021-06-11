package pro.scarlet.job;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class HelloJob implements Job {

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        // 当前时间
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd:HH:mm:ss");
        String dateStr = dateFormat.format(date);
        // 工作内容
        System.out.println("正在进行Hello任务的定时执行，执行时间：" + dateStr);
    }
    
}
