package cn.edu.swu;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class LoginServlet implements Servlet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}
	private ServletConfig servletConfig;
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		this.servletConfig = config;
	}

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("请求来了");
		System.out.println(request);
		String user = request.getParameter("user");
		String password = request.getParameter("password");
		System.out.println("user:"+user+"password:"+password);
		//这种方法对于checkbox传过来的多个参数只能获取到第一个
		String interesting = request.getParameter("interesting");
		System.out.println(interesting);
		//getParameterValues函数获取到所以参数循环打印
		String [] interestings = request.getParameterValues("interesting");
		for(String interest: interestings) {
			System.out.println(interest);
		}
		//getParameterNames返回参数迭代器函数
		Enumeration<String> names = request.getParameterNames();
		while(names.hasMoreElements()) {
			String name = names.nextElement();
			String value = request.getParameter(name);
			System.out.println(name+":"+value);
		}
		//获取一个参数有多个值的情况适用
		Map<String, String[]> map = request.getParameterMap();
		for(Map.Entry<String, String[]> entry: map.entrySet()) {
			System.out.println("**"+entry.getKey()+":"+ Arrays.asList(entry.getValue()));			
		}
		
		//获取httpservletrequest的参数，这个是Servlet的子接口
		HttpServletRequest httpServletRequest = (HttpServletRequest)request;
		//父接口转子接口？？？
		String requestURI = httpServletRequest.getRequestURI();
		System.out.println(requestURI);
		String method = httpServletRequest.getMethod();
		System.out.println(method);
		String queryString = httpServletRequest.getQueryString();
		System.out.println(queryString);
		String servletPath = httpServletRequest.getServletPath();
		System.out.println(servletPath);
		//设置响应的内容类型
		//response.setContentType("application/msword");//word格式
		PrintWriter out = response.getWriter();//返回PrintWriter对象
		String xmluser = this.servletConfig.getInitParameter("user");
		System.out.println("xmluser:"+xmluser);
		String xmlpassword = this.servletConfig.getInitParameter("password");
		System.out.println("xmlpassword:"+xmlpassword);
		if(user.equals(xmluser) && password.equals(xmlpassword)) {
			out.println("hello world....");
		}
		else {
			out.println("failed...");
		}
	}

}
