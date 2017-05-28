package com.nieyue.bussiness;

import javax.annotation.Resource;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Component;

import com.nieyue.bean.Beijing;
import com.nieyue.bean.Jianada;
import com.nieyue.service.BeijingService;
import com.nieyue.service.JianadaService;
import com.nieyue.util.DateUtil;
import com.nieyue.util.HttpClientUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 存储数据
 * @author Administrator
 *
 */
@Component
public class AddData {
	@Resource
	BeijingService beijingService;
	@Resource
	JianadaService jianadaService;
	
	 public   String BEIJING_URL =   "http://api.dabai28.com/api28.php?name=pc28&type=json";
	 public   String JIANADA_URL =   "http://api.dabai28.com/api28.php?name=jnd28&type=json";
	 
	 public  boolean addBeijingData() throws Exception{
		 boolean boo=false;
		 String beijingdata = HttpClientUtil.doGet(BEIJING_URL);
	    	Document b = Jsoup.parse(beijingdata);
			String bj = b.select("pre").text();
			bj="["+bj+"]";
			//bj=MyStringUtils.replaceBlank(bj);
			bj=bj.replace("\r", "");
			JSONArray jsonarray = JSONArray.fromObject(bj);
			//for (int i = 0,js=jsonarray.size(); i < js; i++) {
			for (int i = 0; i < 1; i++) {
				JSONObject json = (JSONObject) jsonarray.get(i);
				String issue = json.getString("issue");
				String time = json.getString("time");
				String one = json.getString("one");
				String two = json.getString("two");
				String three = json.getString("three");
				String code = json.getString("code");
				Beijing beijing = new Beijing();
				beijing.setBeijingId(Integer.valueOf(issue));
				beijing.setTime(DateUtil.parseDate(time));
				beijing.setOne(Integer.valueOf(one));
				beijing.setTwo(Integer.valueOf(two));
				beijing.setThree(Integer.valueOf(three));
				beijing.setCode(Integer.valueOf(code));
				boo=beijingService.addBeijing(beijing);
			}
		 return boo;
	 }
	 public  boolean addJianadaData() throws Exception{
		 boolean boo=false;
		 String jianadadata = HttpClientUtil.doGet(JIANADA_URL);
		 Document b = Jsoup.parse(jianadadata);
		 String bj = b.select("pre").text();
		 bj="["+bj+"]";
		 //bj=MyStringUtils.replaceBlank(bj);
		 bj=bj.replace("\r", "");
		 JSONArray jsonarray = JSONArray.fromObject(bj);
		 //for (int i = 0,js=jsonarray.size(); i < js; i++) {
		 for (int i = 0; i < 1; i++) {
			 JSONObject json = (JSONObject) jsonarray.get(i);
			 String issue = json.getString("issue");
			 String time = json.getString("time");
			 String one = json.getString("one");
			 String two = json.getString("two");
			 String three = json.getString("three");
			 String code = json.getString("code");
			 Jianada jianada = new Jianada();
			 jianada.setJianadaId(Integer.valueOf(issue));
			 jianada.setTime(DateUtil.parseDate(time));
			 jianada.setOne(Integer.valueOf(one));
			 jianada.setTwo(Integer.valueOf(two));
			 jianada.setThree(Integer.valueOf(three));
			 jianada.setCode(Integer.valueOf(code));
			 boo=jianadaService.addJianada(jianada);
		 }
		 return boo;
	 }
}
