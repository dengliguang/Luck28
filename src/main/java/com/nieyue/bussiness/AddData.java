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
	/**大白API
	  */
	 public   String BEIJING_URL =   "http://api.dabai28.com/api28.php?name=pc28&type=json";
	 public   String JIANADA_URL =   "http://api.dabai28.com/api28.php?name=jnd28&type=json";
	 
	 /**
	  * PC蛋蛋28 调用地址: https://api.zao28.com/News?name=xy28&type=json
	  *加拿大28 调用地址: https://api.zao28.com/News?name=jnd28&type=json
	  *新加坡28 调用地址: https://api.zao28.com/News?name=xjp28&type=json
	  *CQ时时彩 调用地址: https://api.zao28.com/News?name=cqssc&type=json
	  *北京PK10 调用地址: https://api.zao28.com/News?name=bjpk10&type=json
	  */
	 public   String BEIJING_URL2 =   "https://api.zao28.com/News?name=xy28&type=json";
	 public   String JIANADA_URL2 =   "https://api.zao28.com/News?name=jnd28&type=json";
	 /**
	  * 大白北京API
	  */
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
	 /**
	  * 找28 北京API
	  */
	 public  boolean addBeijingData2() throws Exception{
		 boolean boo=false;
		 String beijingdata = HttpClientUtil.doGet(BEIJING_URL2);
			JSONObject jo = JSONObject.fromObject(beijingdata);
			if(jo.getInt("code")==1){
				JSONArray ja = jo.getJSONArray("datas");
				for (int i = 0; i < 1; i++) {
					Beijing beijing = new Beijing();
					JSONObject json = (JSONObject) ja.get(i);
					String issue = json.getString("issue");
					beijing.setBeijingId(Integer.valueOf(issue));
					String time = json.getString("time");
					beijing.setTime(DateUtil.parseDate(time));
					String kjcodes = json.getString("kjcodes");
					String[] code = kjcodes.split(",");
					beijing.setOne(Integer.valueOf(code[0]));
					beijing.setTwo(Integer.valueOf(code[1]));
					beijing.setThree(Integer.valueOf(code[2]));
					String kjcode = json.getString("kjcode");
					beijing.setCode(Integer.valueOf(kjcode));
					boo=beijingService.addBeijing(beijing);
				}
			}
		 return boo;
	 }
	 /**
	  * 大白加拿大API
	  */
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
	 /**
	  * 找28 加拿大API
	  */
	 public  boolean addJianadaData2() throws Exception{
		 boolean boo=false;
		 String jianadadata = HttpClientUtil.doGet(JIANADA_URL2);
			JSONObject jo = JSONObject.fromObject(jianadadata);
			if(jo.getInt("code")==1){
				JSONArray ja = jo.getJSONArray("datas");
				for (int i = 0; i < 1; i++) {
					Jianada jianada = new Jianada();
					JSONObject json = (JSONObject) ja.get(i);
					String issue = json.getString("issue");
					jianada.setJianadaId(Integer.valueOf(issue));
					String time = json.getString("time");
					jianada.setTime(DateUtil.parseDate(time));
					String kjcodes = json.getString("kjcodes");
					String[] code = kjcodes.split(",");
					jianada.setOne(Integer.valueOf(code[0]));
					jianada.setTwo(Integer.valueOf(code[1]));
					jianada.setThree(Integer.valueOf(code[2]));
					String kjcode = json.getString("kjcode");
					jianada.setCode(Integer.valueOf(kjcode));
					boo=jianadaService.addJianada(jianada);
				}
			}
		 return boo;
	 }
}
