package com.xyc.mapper;

import java.util.List;

import com.xyc.pojo.Customer;
import com.xyc.pojo.QueryVo;

public interface CustomerMapper {
	
	/**
	 * 根据queryvo分页查询数据
	 * @param queryVo
	 * @return
	 */
	public List<Customer> queryCustomerByQueryVo(QueryVo queryVo);
	/**
	 * 根据queryvo查询数据条数
	 * @param queryVo
	 * @return
	 */
	public Integer queryCountByQueryVo(QueryVo queryVo);
	/**
	 * 根据id查询客户
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
