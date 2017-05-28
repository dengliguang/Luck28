package com.nieyue.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.nieyue.bean.Acount;
import com.nieyue.service.AcountService;
import com.nieyue.util.MyDESutil;
import com.nieyue.util.ResultUtil;
import com.nieyue.util.StateResult;
import com.nieyue.util.StateResultList;



/**
 * 账户控制类
 * @author yy
 *
 */
@RestController
@RequestMapping("/acount")
public class AcountController {
	@Resource
	private AcountService acountService;
	
	/**
	 * 账户分页浏览
	 * @param orderName 商品排序数据库字段
	 * @param orderWay 商品排序方法 asc升序 desc降序
	 * @return
	 */
	@RequestMapping(value = "/list", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody StateResultList browsePagingAcount(
			@RequestParam(value="pageNum",defaultValue="1",required=false)int pageNum,
			@RequestParam(value="pageSize",defaultValue="10",required=false) int pageSize,
			@RequestParam(value="orderName",required=false,defaultValue="acount_id") String orderName,
			@RequestParam(value="orderWay",required=false,defaultValue="desc") String orderWay,HttpSession session)  {
			List<Acount> list = new ArrayList<Acount>();
			list= acountService.browsePagingAcount(pageNum, pageSize, orderName, orderWay);
			if(list.size()>0){
				return ResultUtil.getSlefSRSuccessList(list);
				
			}else{
				return ResultUtil.getSlefSRFailList(list);
			}
	}
	/**
	 * 账户修改
	 * @return
	 */
	@RequestMapping(value = "/update", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody StateResult updateAcount(@ModelAttribute Acount acount,HttpSession session)  {
		boolean um = acountService.updateAcount(acount);
		return ResultUtil.getSR(um);
	}
	/**
	 * 账户增加
	 * @return 
	 */
	@RequestMapping(value = "/add", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody StateResult addAcount(@ModelAttribute Acount acount, HttpSession session) {
		acount.setPassword(MyDESutil.getMD5(acount.getPassword()));
		boolean am = acountService.addAcount(acount);
		return ResultUtil.getSR(am);
	}
	/**
	 * 账户删除
	 * @return
	 */
	@RequestMapping(value = "/{acountId}/delete", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody StateResult delAcount(@PathVariable("acountId") Integer acountId,HttpSession session)  {
		boolean dm = acountService.delAcount(acountId);
		return ResultUtil.getSR(dm);
	}
	/**
	 * 账户浏览数量
	 * @return
	 */
	@RequestMapping(value = "/count", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody int countAll(
			HttpSession session)  {
		int count = acountService.countAll();
		return count;
	}
	/**
	 * 账户单个加载
	 * @return
	 */
	@RequestMapping(value = "/{acountId}", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody StateResultList loadAcount(@PathVariable("acountId") Integer acountId,HttpSession session)  {
		List<Acount> list = new ArrayList<Acount>();
		Acount acount = acountService.loadAcount(acountId);
		if(acount!=null &&!acount.equals("")){
				list.add(acount);
				return ResultUtil.getSlefSRSuccessList(list);
			}else{
				return ResultUtil.getSlefSRFailList(list);
			}
	}
	/**
	 * 管理员登录
	 * @return
	 */
	@RequestMapping(value = "/login", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody StateResultList loginAcount(
			@RequestParam("adminName") String adminName,
			@RequestParam("password") String password,
			HttpSession session)  {
		List<Acount> list = new ArrayList<Acount>();
		Acount acount = acountService.loginAcount(adminName, MyDESutil.getMD5(password));
		System.out.println(acount.getPhone());
		if(acount!=null&&!acount.equals("")){
			acount.setLoginDate(new Date());
			boolean b = acountService.updateAcount(acount);
			if(b){
			session.setAttribute("acount", acount);
			list.add(acount);
			return ResultUtil.getSlefSRSuccessList(list);
			}
		}
		return ResultUtil.getSlefSRFailList(list);
	}
	/**
	 * 登录
	 * @return
	 */
	@RequestMapping(value = "/islogin", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody StateResultList isLoginAcount(
			HttpSession session)  {
		Acount acount = (Acount) session.getAttribute("acount");
		List<Acount> list = new ArrayList<Acount>();
		if(acount!=null && !acount.equals("")){
			list.add(acount);
			return ResultUtil.getSlefSRSuccessList(list);
		}
		return ResultUtil.getSlefSRFailList(list);
	}
	/**
	 * 登出
	 * @return
	 */
	@RequestMapping(value = "/loginout", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody StateResultList loginoutAcount(
			HttpSession session)  {
		session.invalidate();
		return ResultUtil.getSlefSRSuccessList(null);
	}
	
}
