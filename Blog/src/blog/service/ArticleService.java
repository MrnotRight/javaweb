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
	 * ��ȡʵ��
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
	 * ��ȡ��һƪ����
	 * 
	 * @param time
	 * @return
	 */
	public Article getPreviousArticle(String time) {
		return dao.getANearArticle(time, dao.LESS);
	}

	/**
	 * ��ȡ��һƪ
	 * 
	 * @param time
	 * @return
	 */
	public Article getNextArticle(String time) {
		return dao.getANearArticle(time, dao.MORE);
	}

	/**
	 * ��ȡ���µ����� �� ���������
	 * 
	 * @param search_key
	 * @return
	 */
	public int getCount(String search_key) {
		return dao.getCount(search_key);
	}

	/**
	 * ͨ�������Ի�ȡ����
	 * 
	 * @param column
	 * @param value
	 * @return
	 */
	public List<Article> getArticle(String column, String value) {
		return dao.getArticleByColumn(column, value);
	}

	/**
	  * ��ȡ���༰�÷������������
	 * 
	 * @return
	 */
	public Map getSortAndCount() {
		// TO DO
		return dao.getColumAndCount(dao.SEARCH_SORT);
	}

	/**
	 * ��ȡ �������� ��ȡ���³��� ��ȡһ��ʱ�� ȥ��ʱ ���� ��
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
	 * ��ȡ�������������
	 * 
	 * @return
	 */
	public Map getSortAndAirticle(String sort_name) {

		Map map = new HashMap();
		List<Article> articleBySort = null;

		// ��ȡ���з���
		if (sort_name.equals("all") || StringUtils.isEmpty(sort_name)) {
			List<String> sorts = dao.getAllSort();

			for (int i = 0; i < sorts.size(); i++) {
				String sort = sorts.get(i);
				articleBySort = dao.getArticleByColumn("sort", sort);
				ArticleUtils.cutTime(articleBySort);
				map.put(sort, articleBySort);//articleBySort ��һ��list
			}
		} else {
			// ��ȡ��������
			articleBySort = dao.getArticleByColumn("sort", sort_name);
			ArticleUtils.cutTime(articleBySort);
			map.put(sort_name, articleBySort);
		}
		return map;
	}

	public List getVisitRank() {
		List list = dao.getVisitRank();//��ȡ��װ�Ķ������ݼ����������list
		//��ʾǰʮ������
		if (list.size() > 10) {
			for (int i = 10; i < list.size(); i++) {
				list.remove(i);
			}
		}
		for (int y = 0; y < list.size(); y++) {

			Article a = (Article) list.get(y);
			//��ʾ�������ݵ�ǰ20���ַ�
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
