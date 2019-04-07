package cn.edu.swu;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class HelloServlet implements Servlet{

	@Override
	public void destroy() {
		System.out.println("destory...");
	}

	@Override
	public ServletConfig getServletConfig() {
		System.out.println("getServletConfig...");
		return null;
	}

	@Override
	public String getServletInfo() {
		System.out.println("getServletInfo...");
		return null;
	}

	@Override
	public void init(ServletConfig servletconfig) throws ServletException {
		System.out.println("init...");
		String user = servletconfig.getInitParameter("user");
		System.out.println("user:"+user);
		Enumeration<String> names = servletconfig.getInitParameterNames();
		while(names.hasMoreElements()) {
			String name = names.nextElement();
			String value = servletconfig.getInitParameter(name);
			System.out.println("name:"+name+"  value:"+value);
		}
		String servletname = servletconfig.getServletName();
		System.out.println(servletname);
		//获取ServletContext对象
		ServletContext servletContext = servletconfig.getServletContext();
		String driver = servletContext.getInitParameter("driver");
		System.out.println("driver:"+driver);
		//获取xml配置的全局初始化参数
		Enumeration<String> names2 = servletContext.getInitParameterNames();
		while(names2.hasMoreElements()) {
				String name = names2.nextElement();
				System.out.println("--->"+name);
		}
		//获取当前WEB的名称
		String contextPath = servletContext.getContextPath();
		System.out.println(contextPath);
		
	}

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		System.out.println("service...");
		
	}
	public HelloServlet() {
		System.out.println("HelloServlet's constructor...");
	}
	

}
