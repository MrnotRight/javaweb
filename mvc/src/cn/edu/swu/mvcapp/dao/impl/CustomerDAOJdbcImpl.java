package cn.edu.swu.mvcapp.dao.impl;

import java.util.List;

import cn.edu.swu.mvcapp.dao.CustomerDAO;
import cn.edu.swu.mvcapp.dao.DAO;
import cn.edu.swu.mvcapp.domain.CriteriaCustomer;
import cn.edu.swu.mvcapp.domain.Customer;

public class CustomerDAOJdbcImpl extends DAO<Customer> implements CustomerDAO{

	@Override
	public List<Customer> getAll() {
		// TODO Auto-generated method stub
		String sql = "select id,name,address,phone from customers";
		return getForList(sql);
	}

	@Override
	public void save(Customer customer) {
		// TODO Auto-generated method stub
		String sql = "insert into customers(name,address,phone) values(?,?,?)";
		update(sql,customer.getName(),customer.getAddress(),customer.getPhone());
	}

	@Override
	public void update(Customer customer) {
		// TODO Auto-generated method stub
		String sql = "UPDATE customers SET name=?,address=?,phone=? WHERE id=?";
		update(sql,customer.getName(),customer.getAddress(),customer.getPhone(),customer.getId());
	}

	@Override
	public Customer get(Integer id) {
		// TODO Auto-generated method stub
		String sql = "SELECT id,name,address,phone FROM customers WHERE id=?";
		return get(sql,id);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM customers WHERE id=?";
		update(sql,id);
	}

	@Override
	public List<Customer> getForListWithCriteriaCustomer(CriteriaCustomer cc) {
		// TODO Auto-generated method stub
		String sql = "SELECT id,name,address,phone FROM customers WHERE "
				+ "name like ? and address like ? and phone like ?";
		return getForList(sql, cc.getName(), cc.getAddress(), cc.getPhone());

	}

	@Override
	public long getCountWithName(String name) {
		// TODO Auto-generated method stub
		String sql = "select count(id) FROM customers WHERE name=?";
		return getForValue(sql,name);
	}
	

}
