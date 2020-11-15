package pro.scarlet.trig;

import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.SchedulerMetaData;
import org.quartz.impl.StdSchedulerFactory;

public class QuartzPluginDemo {
    public void run() throws Exception{
        SchedulerFactory sf = new StdSchedulerFactory();
        Scheduler sched = null;
        try{
            sched = sf.getScheduler();
        } catch (NoClassDefFoundError e){
            System.out.println(" Unable to load a class - most likely you do not have jta.jar on the classpath. If not present in the examples/lib folder, please " +
            "add it there for this sample to run. " + e);
            return;
        }
        System.out.println("------- Initialization Complete -----------");

        System.out.println("------- (Not Scheduling any Jobs - relying on XML definitions --");
    
        System.out.println("------- Starting Scheduler ----------------");
    
        // start the schedule
        sched.start();
    
        System.out.println("------- Started Scheduler -----------------");
    
        System.out.println("------- Waiting ... minutes... -----------");
    
        // wait one minutes to give our jobs a chance to run
        try {
          Thread.sleep(600L * 1000L);
          // 300L * 1000L
        } catch (Exception e) {
          //
        }
    
        // shut down the scheduler
        System.out.println("------- Shutting Down ---------------------");
        sched.shutdown(true);
        System.out.println("------- Shutdown Complete -----------------");
    
        SchedulerMetaData metaData = sched.getMetaData();
        System.out.println("Executed " + metaData.getNumberOfJobsExecuted() + " jobs.");
    }
    public static void main(String[] args) throws Exception {
        QuartzPluginDemo example = new QuartzPluginDemo();
        example.run();
    }
}
