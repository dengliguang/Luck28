package com.nieyue.scheduled;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.nieyue.bussiness.AddData;

@Component
public class DataJob {
	 public final static long ONE_Minute =   20*1000;
	 public final static long TEN_SECONDS =   10*1000;
	 public  static long BEIJING_TIME =   60*1000;
	 public  static long JIANADA_TIME =   60*1000;
	 @Resource
	AddData addData;
	  /**
	     * 获取北京/加拿大数据任务
	 * @throws Exception 
	     */
	    @Scheduled(fixedDelay=TEN_SECONDS)
	    public void dataJob() throws Exception{
	    	boolean bd = addData.addBeijingData();
	    	//boolean bd = addData.addBeijingData2();
	    	//System.out.println("北京"+bd);
	    	boolean jd = addData.addJianadaData();
	    	//boolean jd = addData.addJianadaData2();
	    	//System.out.println("加拿大"+jd);
	    }
	    /**
	  /**
	     * 任务完后执行
	     * @throws InterruptedException
	     */
	    //@Scheduled(fixedDelay=ONE_Minute)
	    public void fixedDelayJob() throws InterruptedException{
	    	
	    	System.out.println(new Date().toLocaleString()+" >>fixedDelay执行....");
	    }
	    /**
	     * 没有延时
	     * @throws InterruptedException
	     */
	   // @Scheduled(fixedRate=ONE_Minute)
	    public void fixedRateJob() throws InterruptedException{
	    	Thread.sleep(1000);
	        System.out.println(new Date().toLocaleString()+" >>fixedRate执行....");
	    }

	   // @Scheduled(cron="0/1 * * * * ?")
	    public void cronJob() throws InterruptedException{
	    	if(BEIJING_TIME<=0){
	    		BEIJING_TIME=5000;
	    	}
	    	if(JIANADA_TIME<=0){
	    		JIANADA_TIME=3500;
	    	}
	    	BEIJING_TIME=BEIJING_TIME-1000;
	    	JIANADA_TIME=JIANADA_TIME-1000;
	    	
	        System.out.println(new Date().toLocaleString()+" >>cron执行....");
	        System.out.println("BEIJING_TIME:"+BEIJING_TIME);
	        System.out.println("JIANADA_TIME:"+JIANADA_TIME);
	    }
	   //@Scheduled(cron="*/1 * * * * ?")
	    public void cronJob2() throws InterruptedException{
	    	if(BEIJING_TIME<=0){
	    		System.out.println(BEIJING_TIME+" >>北京数据拉取执行....");
	        }
	    	if(JIANADA_TIME<=0){
	    		System.out.println(new Date().toLocaleString()+" >>加拿大数据拉取执行....");
	    	}
	    }
}
