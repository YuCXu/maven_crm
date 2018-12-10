package com.xyc.service;

import com.xyc.pojo.Customer;
import com.xyc.pojo.QueryVo;
import com.xyc.utils.Page;

public interface CustomerService {
	
	/**
	 * 根据条件分页查询客户
	 * @return
	 */
	public Page<Customer> queryCustomerByQueryVo(QueryVo queryVo);
	
	/**
	 * 根据id查找客户
	 * @param id
	 * @return
	 */
	public Customer queryCustomerById(Long id);
	
	/**
	 * 根据id更新用户
	 * @param customer
	 */
	public void updateCustomerById(Customer customer);
	
	/**
	 * 根据id删除客户
	 * @param id
	 */
	public void deleteCustomerById(Long id);
}
