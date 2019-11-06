package com.bw.controller;

import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.bw.entity.Brand;
import com.bw.entity.Goods;
import com.bw.entity.Goodskind;
import com.bw.service.BrandService;
import com.bw.service.GoodsService;
import com.bw.utils.FileUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * @author wangafei
 *
 * 2019年11月2日
 */
@Controller
public class GoodsController {
	
	@Resource
	private GoodsService service;
	
	@Resource
	private BrandService Bservice;
	
	@RequestMapping("/list")
	public ModelAndView list(@RequestParam(defaultValue="1")Integer pageNum,String lname,String come,String sc){
		ModelAndView mav = new ModelAndView();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("lname", lname);
		map.put("sc", sc);
		map.put("come", come);
		PageHelper pageHelper = new PageHelper();
		pageHelper.startPage(pageNum, 3);
		List<Goods> list = service.selectList(map);
		PageInfo<Goods> page = new PageInfo<Goods>(list);
		mav.setViewName("list");
		mav.getModel().put("list", list);
		mav.getModel().put("page", page);
		
		return mav;
	}
	@RequestMapping("/toadd")
	public String toadd(Model model){
		model.addAttribute("goods", new Goods());
		return "add";
	}
	@RequestMapping("/add")
	public String add(Goods goods,MultipartFile file) throws Exception, Exception{
		String string = FileUtils.upload(file);
		goods.setImgurl(string);
		service.add(goods);
		
		return "redirect:/list";
	}
	@RequestMapping("/selectById")
	@ResponseBody
	public List<Brand> selectById(){
		List<Brand> list = Bservice.selectlist();
		return list;
	}
	@RequestMapping("/selectById1")
	@ResponseBody
	public List<Goodskind> selectById1(){
		List<Goodskind> list = Bservice.selectlist1();
		return list;
	}
	
	@RequestMapping("/lookImg")
	public void lookImg(String path,HttpServletRequest request,HttpServletResponse response){
		FileUtils.lookImg(path, request, response);
	}
	@RequestMapping("/toupdate")
	public String toupdate(Model model,Integer gid,Integer sum){
		Goods goods = service.selectGoodsById(gid);
		List<Brand> list = Bservice.selectlist();
		List<Goodskind> list2 = Bservice.selectlist1();
		model.addAttribute("list", list);
		model.addAttribute("list2", list2);
		model.addAttribute("goods", goods);
		if(sum == 1){
			return "update";			
		}else{
			return "show";
		}
	}
	@RequestMapping("/update")
	public String update(Goods goods,MultipartFile file) throws Exception, Exception{
		System.out.println(goods);
		String string = FileUtils.upload(file);
		goods.setImgurl(string);
		service.update(goods);
		
		return "redirect:/list";
	} 
	
	@RequestMapping("/deleteGoods")
	@ResponseBody
	public Integer deleteGoods(String[] gid){
		Integer integer = service.deleteGoods(gid);
		
		return integer;
	}
	
	@RequestMapping("updateGoods")
	public String updateGoods(Goods goods){
		if(goods.getSum() ==1){
			goods.setSum(0);
			service.updateGoods(goods);
			return "redirect:list";
		}else{
			goods.setSum(1);
			service.updateGoods(goods);
			return "redirect:list";
		}
		
	}
}
