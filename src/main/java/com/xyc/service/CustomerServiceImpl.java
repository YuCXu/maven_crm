package com.xyc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xyc.mapper.CustomerMapper;
import com.xyc.pojo.Customer;
import com.xyc.pojo.QueryVo;
import com.xyc.utils.Page;

@Service
public class CustomerServiceImpl implements CustomerService{

	
	@Autowired
	private CustomerMapper customerMapper;
	@Override
	/**
	 * 根据条件分页查询客户
	 */
	public Page<Customer> queryCustomerByQueryVo(QueryVo queryVo) {
		//设置每页从哪个数据开始查询
		queryVo.setStart((queryVo.getPage()-1)*queryVo.getSize());
		
		//封装page对象
		Page<Customer> page = new Page<Customer>();
		//封装总条数
		Integer total = customerMapper.queryCountByQueryVo(queryVo);
		page.setTotal(total);
		//封装当前页
		page.setPage(queryVo.getPage());
		//封装每页显示的条数
		page.setSize(queryVo.getSize());
		//封装每页显示的数据
		List<Customer> list = customerMapper.queryCustomerByQueryVo(queryVo);
		page.setRows(list);
		
		return page;
	}
	@Override
	/**
	 * 根据id查找客户
	 */
	public Customer queryCustomerById(Long id) {
		return customerMapper.queryCustomerById(id);
		 
	}
	@Override
	/**
	 * 根据id更新用户
	 */
	public void updateCustomerById(Customer customer) {
		customerMapper.updateCustomerById(customer);
	}
	
	@Override
	/**
	 * 根据id删除客户
	 */
	public void deleteCustomerById(Long id) {
		customerMapper.deleteCustomerById(id);
	}

}
