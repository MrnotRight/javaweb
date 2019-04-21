package cn.edu.swu.mvcapp.dao;

import java.util.List;

import cn.edu.swu.mvcapp.domain.CriteriaCustomer;
import cn.edu.swu.mvcapp.domain.Customer;

public interface CustomerDAO {
	public List<Customer> getAll();
	public void save(Customer customer);
	public void update(Customer customer);
	public Customer get(Integer id);
	public void delete(Integer id);
	public List<Customer> getForListWithCriteriaCustomer(CriteriaCustomer cc);
	
	public long getCountWithName(String name);
}
