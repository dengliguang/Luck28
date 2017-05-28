package com.nieyue.test;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.nieyue.util.DateUtil;
import com.nieyue.util.HttpClientUtil;
import com.nieyue.util.MyStringUtils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class Test1 {
	 public  static String BEIJING_URL =   "http://api.dabai28.com/api28.php?name=pc28&type=json";
	 public  static String JIANADA_URL =   "http://api.dabai28.com/api28.php?name=jnd28&type=json";
	 
public static void main(String[] args) {
	long oldDate=new Date("2017/5/28 15:48:00").getTime();
	long nowDate=new Date().getTime();
	long costDate = (nowDate-oldDate);
	long surplusDate = 1000*60*6-costDate;
	if(surplusDate<0){
		System.out.println(surplusDate);
		
	}
	System.out.println(surplusDate);
	System.out.println("剩余"+surplusDate/1000/60+"分钟，"+surplusDate/1000%60+"秒");
	String beijingdata;
	try {
		beijingdata = HttpClientUtil.doGet(BEIJING_URL);
		Document b = Jsoup.parse(beijingdata);
		String d = b.select("pre").text();
		d="["+d+"]";
		d=d.replace("\r", "");
		JSONArray ja = JSONArray.fromObject(d);
		for (int i = 0; i < ja.size(); i++) {
			System.out.println(ja.get(i));
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
