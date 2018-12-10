package com.xyc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xyc.pojo.BaseDict;
import com.xyc.pojo.Customer;
import com.xyc.pojo.QueryVo;
import com.xyc.service.BaseDictService;
import com.xyc.service.CustomerService;
import com.xyc.utils.Page;

@Controller
@RequestMapping("customer")
public class CustomerController {
	
	@Autowired
	private BaseDictService baseDictService;
	@Autowired
	private CustomerService customerService;
	
	//客户行业
	@Value("${CUSTOMER_INDUSTRY_TYPE}")
	private String CUSTOMER_INDUSTRY_TYPE;
	//客户来源
	@Value("${CUSTOMER_FROM_TYPE}")
	private String CUSTOMER_FROM_TYPE;
	//客户级别
	@Value("${CUSTOMER_LEVEL_TYPE}")
	private String CUSTOMER_LEVEL_TYPE;
	
	//查找列表
	@RequestMapping("/list")
	public String queryCustomerList(Model model,QueryVo queryVo) {
		//所属行业
		List<BaseDict> industryType = baseDictService.queryBaseDictByTypeCode(CUSTOMER_INDUSTRY_TYPE);
		//客户来源
		List<BaseDict> fromType = baseDictService.queryBaseDictByTypeCode(CUSTOMER_FROM_TYPE);
		//客户级别
		List<BaseDict> levelType = baseDictService.queryBaseDictByTypeCode(CUSTOMER_LEVEL_TYPE);
		model.addAttribute("industryType",industryType);
		model.addAttribute("fromType",fromType);
		model.addAttribute("levelType",levelType);
		
		//分页查询数据
		Page<Customer> page = customerService.queryCustomerByQueryVo(queryVo);
		model.addAttribute("page", page);
		
		model.addAttribute("custName", queryVo.getCustName());
		model.addAttribute("custIndustry", queryVo.getCustIndustry());
		model.addAttribute("custSource", queryVo.getCustSource());
		model.addAttribute("custLevel", queryVo.getCustLevel());
		
		return "customer";
	}
	
	//编辑客户
	@RequestMapping("edit")
	public @ResponseBody
	Customer queryCustomerById(Long id) {
		Customer customer = customerService.queryCustomerById(id);
		return  customer;
	}
	//更新客户
	@RequestMapping("update")
	public @ResponseBody
	String updateCustomerById(Customer customer) {
		customerService.updateCustomerById(customer);
		return "OK";
	}
	
	//删除客户
	@RequestMapping("delete")
	public @ResponseBody
	String deleteCustomerById(Long id) {
		customerService.deleteCustomerById(id);
		return "OK";
	}
}
