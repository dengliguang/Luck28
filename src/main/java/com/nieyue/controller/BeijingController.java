package com.nieyue.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.nieyue.bean.Beijing;
import com.nieyue.service.BeijingService;
import com.nieyue.util.ResultUtil;
import com.nieyue.util.StateResult;
import com.nieyue.util.StateResultList;



/**
 * 北京控制类
 * @author yy
 *
 */
@RestController
@RequestMapping("/beijing")
public class BeijingController {
	@Resource
	private BeijingService beijingService;
	
	/**
	 * 北京分页浏览
	 * @param orderName 商品排序数据库字段
	 * @param orderWay 商品排序方法 asc升序 desc降序
	 * @return
	 */
	@RequestMapping(value = "/list", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody StateResultList browsePagingBeijing(
			@RequestParam(value="pageNum",defaultValue="1",required=false)int pageNum,
			@RequestParam(value="pageSize",defaultValue="10",required=false) int pageSize,
			@RequestParam(value="orderName",required=false,defaultValue="beijing_id") String orderName,
			@RequestParam(value="orderWay",required=false,defaultValue="desc") String orderWay,HttpSession session)  {
			List<Beijing> list = new ArrayList<Beijing>();
			list= beijingService.browsePagingBeijing(pageNum, pageSize, orderName, orderWay);
			if(list.size()>0){
				return ResultUtil.getSlefSRSuccessList(list);
				
			}else{
				return ResultUtil.getSlefSRFailList(list);
			}
	}
	/**
	 * 北京时间
	 * @return
	 */
	@RequestMapping(value = "/time", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody StateResultList timeBeijing(HttpSession session)  {
		List<Object> l = new ArrayList<Object>();
		List<Beijing> list = beijingService.browsePagingBeijing(1, 1, "beijing_id", "desc");
		long oldDate=list.get(0).getTime().getTime();
		long nowDate=new Date().getTime();
		long costDate = (nowDate-oldDate);
		long surplusDate = 1000*60*4+1000*40-costDate;
		//long surplusDate = 1000*60*5-costDate;
		Map<String,Object> map=new HashMap<String,Object>();
		if(surplusDate<0){
			map.put("time", "获取数据中");//
		}else{
			map.put("time", surplusDate);//
		}
		l.add(map);
		return ResultUtil.getSlefSRSuccessList(l);
	}
	/**
	 * 北京修改
	 * @return
	 */
	@RequestMapping(value = "/update", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody StateResult updateBeijing(@ModelAttribute Beijing beijing,HttpSession session)  {
		boolean um = beijingService.updateBeijing(beijing);
		return ResultUtil.getSR(um);
	}
	/**
	 * 北京增加
	 * @return 
	 */
	@RequestMapping(value = "/add", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody StateResult addBeijing(@ModelAttribute Beijing beijing, HttpSession session) {
		List<Beijing> list = beijingService.browsePagingBeijing(1, 1, "beijing_id", "desc");
		int beijingId = list.get(0).getBeijingId()+1;
		beijing.setBeijingId(beijingId);
		long newTime = list.get(0).getTime().getTime()+1000*60*5;
		//Date t = DateUtil.timeStamp2Date(String.valueOf(newTime/1000), "yyyy-MM-dd HH:mm:ss");
		Date t = new Date(newTime);
		beijing.setTime(t);
		boolean am = beijingService.addBeijing(beijing);
		return ResultUtil.getSR(am);
	}
	/**
	 * 北京删除
	 * @return
	 */
	@RequestMapping(value = "/{beijingId}/delete", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody StateResult delBeijing(@PathVariable("beijingId") Integer beijingId,HttpSession session)  {
		boolean dm = beijingService.delBeijing(beijingId);
		return ResultUtil.getSR(dm);
	}
	/**
	 * 北京浏览数量
	 * @return
	 */
	@RequestMapping(value = "/count", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody int countAll(
			HttpSession session)  {
		int count = beijingService.countAll();
		return count;
	}
	/**
	 * 北京单个加载
	 * @return
	 */
	@RequestMapping(value = "/{beijingId}", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody StateResultList loadBeijing(@PathVariable("beijingId") Integer beijingId,HttpSession session)  {
		List<Beijing> list = new ArrayList<Beijing>();
		Beijing beijing = beijingService.loadBeijing(beijingId);
		if(beijing!=null &&!beijing.equals("")){
				list.add(beijing);
				return ResultUtil.getSlefSRSuccessList(list);
			}else{
				return ResultUtil.getSlefSRFailList(list);
			}
	}
}
