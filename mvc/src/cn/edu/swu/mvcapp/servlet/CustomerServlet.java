package cn.edu.swu.mvcapp.servlet;

import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import cn.edu.swu.mvcapp.dao.CustomerDAO;
import cn.edu.swu.mvcapp.dao.impl.CustomerDAOJdbcImpl;
import cn.edu.swu.mvcapp.domain.CriteriaCustomer;
import cn.edu.swu.mvcapp.domain.Customer;

public class CustomerServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
    private CustomerDAO customerDao = new CustomerDAOJdbcImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    private void update(HttpServletRequest request, HttpServletResponse response) {
    	int qw = Integer.parseInt(request.getParameter("id"));
    	System.out.println(qw);
    	System.out.println("update...");
    	String name = request.getParameter("name");
    	String address = request.getParameter("address");
    	String phone = request.getParameter("phone");
    	Customer customer = new Customer();
    	customer.setId(8);
    	customer.setName(name);
    	customer.setAddress(address);
    	customer.setPhone(phone);
    	System.out.print(customer);
    	customerDao.update(customer);
    	try {
			response.sendRedirect("query.do");
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
    }
    private void add(HttpServletRequest request, HttpServletResponse response) {
    	String name = request.getParameter("name");
    	String address = request.getParameter("address");
    	String phone = request.getParameter("phone");
    	Customer customer = new Customer();
    	customer.setName(name);
    	customer.setAddress(address);
    	customer.setPhone(phone);
    	customerDao.save(customer);
    	try {
			response.sendRedirect("query.do");
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    private void query(HttpServletRequest request, HttpServletResponse response) {
    	// 封装查询条件
    	String name = request.getParameter("name");
    	String address = request.getParameter("address");
    	String phone = request.getParameter("phone");
    	CriteriaCustomer cc = new CriteriaCustomer();
    	cc.setName(name);
    	cc.setAddress(address);
    	cc.setPhone(phone);
    	List<Customer> customers = customerDao.getForListWithCriteriaCustomer(cc);
    	request.setAttribute("customers", customers);
    	try {
			request.getRequestDispatcher("index.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			try {
				response.sendRedirect("error.jsp");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
    }
    private void delete(HttpServletRequest request, HttpServletResponse response) {
    	int id = Integer.parseInt(request.getParameter("id"));
    	customerDao.delete(id);
    	try {
			response.sendRedirect("query.do");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获取方法名
		String  path = request.getServletPath();
		String methodName = path.substring(1,path.length()-3);
		System.out.println(methodName);
		try {
			// 获取方法
			Method method = this.getClass().getDeclaredMethod(methodName, HttpServletRequest.class,
					HttpServletResponse.class);
			// 执行方法
			method.invoke(this,request,response);			
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			response.sendRedirect("error.jsp");
			e.printStackTrace();
		}
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}


}
