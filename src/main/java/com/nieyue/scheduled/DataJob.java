package com.nieyue.scheduled;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.nieyue.bussiness.AddData;

@Component
public class DataJob {
	 public final static long ONE_Minute =   20*1000;
	 public  static long BEIJING_TIME =   60*1000;
	 public  static long JIANADA_TIME =   60*1000;
	 /**
	  * PC蛋蛋28 调用地址: https://api.zao28.com/News?name=xy28&type=json
	  *加拿大28 调用地址: https://api.zao28.com/News?name=jnd28&type=json
	  *新加坡28 调用地址: https://api.zao28.com/News?name=xjp28&type=json
	  *CQ时时彩 调用地址: https://api.zao28.com/News?name=cqssc&type=json
	  *北京PK10 调用地址: https://api.zao28.com/News?name=bjpk10&type=json
	  */
	 public  static String BEIJING_URL =   "http://api.dabai28.com/api28.php?name=pc28&type=json";
	 public  static String JIANADA_URL =   "http://api.dabai28.com/api28.php?name=jnd28&type=json";
	 
	 @Resource
	AddData addData;
	  /**
	     * 获取北京/加拿大数据任务
	 * @throws Exception 
	     */
	    @Scheduled(fixedDelay=ONE_Minute)
	    public void dataJob() throws Exception{
	    	boolean bd = addData.addBeijingData();
	    	//System.out.println("北京"+bd);
	    	boolean jd = addData.addJianadaData();
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
