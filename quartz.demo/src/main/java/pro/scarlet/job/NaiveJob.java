package pro.scarlet.job;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;

public class NaiveJob implements Job {

    private String myParam;

    @Override
    public void execute(JobExecutionContext arg0) throws JobExecutionException {
        // 当前时间
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd:HH:mm:ss");
        String dateStr = dateFormat.format(date);
        // 工作内容
        System.out.println("正在进行数据备份任务的定时执行，执行时间：" + dateStr);

        JobKey jobKey = arg0.getJobDetail().getKey();
        System.out.println(
                "Executing job: " + jobKey + " executing at " + dateStr + ", fired by: " + arg0.getTrigger().getKey());
        if (arg0.getMergedJobDataMap().size() > 0) {
            Set<String> keys = arg0.getMergedJobDataMap().keySet();
            for(String key: keys){
                String val = arg0.getMergedJobDataMap().getString(key);
                System.out.println(" - jobDataMap entry: " + key + " = " + val);
            }
        }
        System.out.println("--以上是循环产生的Map结果--");
        System.out.println("也可以通过函数直接获取我们想要的字段");
        JobDataMap jMap = arg0.getJobDetail().getJobDataMap();
        System.out.println("jMap中myParam对应的值为: " + jMap.getString("myParam"));

        arg0.setResult("执行成功"); // 默认成功
    }

    public String getMyParam() {
        return myParam;
    }

    public void setMyParam(String myParam) {
        this.myParam = myParam;
    }
    
}
