package blog.utils;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;

import blog.model.Article;

public class Form2Bean {


	public static Article articleForm2Bean(HttpServletRequest request) throws FailException {

		Map value = new HashMap();

		value.put("title", request.getParameter("title"));
		value.put("time", request.getParameter("time"));
		value.put("author", request.getParameter("author"));
		value.put("sort", request.getParameter("sort"));
		// String tags = request.getParameter("tags");
		value.put("content", request.getParameter("content"));
		value.put("star", 0);
		value.put("comment", 0);
		value.put("visit", 0);

		Article bean = new Article();

		try {
			BeanUtils.populate(bean, value);
		} catch (Exception e) {
			e.printStackTrace();

		}
		if (vilidate(bean)) {
			return bean;
		}
		throw new FailException("Create Fail!");

	}

	private static boolean vilidate(Article a) {
		boolean result = true;

		if (a.getSort() == null || a.getTitle() == null || a.getAuthor() == null || a.getTime() == null) {
			result = false;
		}

		return result;
	}

}
