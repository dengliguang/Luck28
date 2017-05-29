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

import com.nieyue.bean.Jianada;
import com.nieyue.service.JianadaService;
import com.nieyue.util.ResultUtil;
import com.nieyue.util.StateResult;
import com.nieyue.util.StateResultList;



/**
 * 加拿大控制类
 * @author yy
 *
 */
@RestController
@RequestMapping("/jianada")
public class JianadaController {
	@Resource
	private JianadaService jianadaService;
	
	/**
	 * 加拿大分页浏览
	 * @param orderName 商品排序数据库字段
	 * @param orderWay 商品排序方法 asc升序 desc降序
	 * @return
	 */
	@RequestMapping(value = "/list", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody StateResultList browsePagingJianada(
			@RequestParam(value="pageNum",defaultValue="1",required=false)int pageNum,
			@RequestParam(value="pageSize",defaultValue="10",required=false) int pageSize,
			@RequestParam(value="orderName",required=false,defaultValue="jianada_id") String orderName,
			@RequestParam(value="orderWay",required=false,defaultValue="desc") String orderWay,HttpSession session)  {
			List<Jianada> list = new ArrayList<Jianada>();
			list= jianadaService.browsePagingJianada(pageNum, pageSize, orderName, orderWay);
			if(list.size()>0){
				return ResultUtil.getSlefSRSuccessList(list);
				
			}else{
				return ResultUtil.getSlefSRFailList(list);
			}
	}
	/**
	 * 加拿大时间
	 * @return
	 */
	@RequestMapping(value = "/time", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody StateResultList timeBeijing(HttpSession session)  {
		List<Object> l = new ArrayList<Object>();
		List<Jianada> list = jianadaService.browsePagingJianada(1, 1, "jianada_id", "desc");
		long oldDate=list.get(0).getTime().getTime();
		long nowDate=new Date().getTime();
		long costDate = (nowDate-oldDate);
		long surplusDate = 1000*60*4+1000*10-costDate;
		Map<String,Object> map=new HashMap<String,Object>();
		if(surplusDate<0){
			map.put("time", "维护中");//
		}else{
			map.put("time", surplusDate);//
		}
		l.add(map);
		return ResultUtil.getSlefSRSuccessList(l);
	}
	/**
	 * 加拿大修改
	 * @return
	 */
	@RequestMapping(value = "/update", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody StateResult updateJianada(@ModelAttribute Jianada jianada,HttpSession session)  {
		boolean um = jianadaService.updateJianada(jianada);
		return ResultUtil.getSR(um);
	}
	/**
	 * 加拿大增加
	 * @return 
	 */
	@RequestMapping(value = "/add", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody StateResult addJianada(@ModelAttribute Jianada jianada, HttpSession session) {
		List<Jianada> list = jianadaService.browsePagingJianada(1, 1, "jianada_id", "desc");
		int jianadaId = list.get(0).getJianadaId()+1;
		jianada.setJianadaId(jianadaId);
		long newTime = list.get(0).getTime().getTime()+1000*60*3+1000*30;
		//Date t = DateUtil.timeStamp2Date(String.valueOf(newTime/1000), "yyyy-MM-dd HH:mm:ss");
		Date t = new Date(newTime);
		jianada.setTime(t);
		boolean am = jianadaService.addJianada(jianada);
		return ResultUtil.getSR(am);
	}
	/**
	 * 加拿大删除
	 * @return
	 */
	@RequestMapping(value = "/{jianadaId}/delete", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody StateResult delJianada(@PathVariable("jianadaId") Integer jianadaId,HttpSession session)  {
		boolean dm = jianadaService.delJianada(jianadaId);
		return ResultUtil.getSR(dm);
	}
	/**
	 * 加拿大浏览数量
	 * @return
	 */
	@RequestMapping(value = "/count", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody int countAll(
			HttpSession session)  {
		int count = jianadaService.countAll();
		return count;
	}
	/**
	 * 加拿大单个加载
	 * @return
	 */
	@RequestMapping(value = "/{jianadaId}", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody StateResultList loadJianada(@PathVariable("jianadaId") Integer jianadaId,HttpSession session)  {
		List<Jianada> list = new ArrayList<Jianada>();
		Jianada Jianada = jianadaService.loadJianada(jianadaId);
		if(Jianada!=null &&!Jianada.equals("")){
				list.add(Jianada);
				return ResultUtil.getSlefSRSuccessList(list);
			}else{
				return ResultUtil.getSlefSRFailList(list);
			}
	}
}
