package blog.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import blog.dao.ArticleDao;
import blog.daoImpl.ArticleDaoImpl;
import blog.model.Article;
import blog.utils.ArticleUtils;
import blog.utils.StringUtils;

public class ArticleService {

	private ArticleDao dao;

	private static ArticleService instance;

	private ArticleService() {
		dao = ArticleDaoImpl.getInstance();
	}

	/**
	 * 获取实例
	 * 
	 * @return
	 */
	public static final ArticleService getInstance() {
		if (instance == null) {
			try {
				instance = new ArticleService();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return instance;
	}

	/**
	 * 获取上一篇文章
	 * 
	 * @param time
	 * @return
	 */
	public Article getPreviousArticle(String time) {
		return dao.getANearArticle(time, dao.LESS);
	}

	/**
	 * 获取下一篇
	 * 
	 * @param time
	 * @return
	 */
	public Article getNextArticle(String time) {
		return dao.getANearArticle(time, dao.MORE);
	}

	/**
	 * 获取文章的数量 或 分类的数量
	 * 
	 * @param search_key
	 * @return
	 */
	public int getCount(String search_key) {
		return dao.getCount(search_key);
	}

	/**
	 * 通过列属性获取文章
	 * 
	 * @param column
	 * @param value
	 * @return
	 */
	public List<Article> getArticle(String column, String value) {
		return dao.getArticleByColumn(column, value);
	}

	/**
	  * 获取分类及该分类的文章数量
	 * 
	 * @return
	 */
	public Map getSortAndCount() {
		// TO DO
		return dao.getColumAndCount(dao.SEARCH_SORT);
	}

	/**
	 * 获取 所有文章 截取文章长度 截取一下时间 去掉时 分钟 秒
	 * 
	 * @return
	 */
	public List getArticle() {
		List<Article> list = dao.getAllArticle();
		for (Article a : list) {
			ArticleUtils.cutContent(list);
			ArticleUtils.cutTime(list);
		}
		return list;
	}

	/**
	 * 获取分类和它的文章
	 * 
	 * @return
	 */
	public Map getSortAndAirticle(String sort_name) {

		Map map = new HashMap();
		List<Article> articleBySort = null;

		// 获取所有分类
		if (sort_name.equals("all") || StringUtils.isEmpty(sort_name)) {
			List<String> sorts = dao.getAllSort();

			for (int i = 0; i < sorts.size(); i++) {
				String sort = sorts.get(i);
				articleBySort = dao.getArticleByColumn("sort", sort);
				ArticleUtils.cutTime(articleBySort);
				map.put(sort, articleBySort);//articleBySort 是一个list
			}
		} else {
			// 获取单个分类
			articleBySort = dao.getArticleByColumn("sort", sort_name);
			ArticleUtils.cutTime(articleBySort);
			map.put(sort_name, articleBySort);
		}
		return map;
	}

	public List getVisitRank() {
		List list = dao.getVisitRank();//获取安装阅读数量递减排序的文章list
		//显示前十个文章
		if (list.size() > 10) {
			for (int i = 10; i < list.size(); i++) {
				list.remove(i);
			}
		}
		for (int y = 0; y < list.size(); y++) {

			Article a = (Article) list.get(y);
			//显示标题内容的前20个字符
			if (a.getTitle().length() > 20) {
				a.setTitle(StringUtils.cutString(a.getTitle(), 0, 19) + "...");
			}

		}

		return list;

	}

	public List getAllSort() {
		return dao.getAllSort();
	}

	public int starArticle(int id) {
		return dao.star_article(id);
	}

	public void addVisit(int article_id) {
		dao.addVisit(article_id);
	}

}
