package blog.dao;

import java.util.List;
import java.util.Map;

import blog.model.Article;

public interface ArticleDao {

	static final String SEARCH_ARTICLE = "article";
	static final String SEARCH_SORT = "sort";

	static final int LESS = 1;
	static final int MORE = 2;

	/**
	 * ��������� �������µ��������
	 * 
	 * @param article_id
	 */
	void addVisit(int article_id);

	/**
	 * ��ȡ��һ���� �� ��һ����
	 * 
	 * @param time
	 * @param less_or_more
	 * @return
	 */
	Article getANearArticle(String time, int less_or_more);

	/**
	 * ����ĳһ������ ����ÿ����Ĵ�С ����Map
	 * 
	 * @param search_column
	 * @return
	 */
	Map getColumAndCount(String search_column);

	/**
	 * �������е����
	 * 
	 * @return
	 */
	List getAllSort();

	/**
	 * �µ�����
	 * 
	 * @param a
	 * @return
	 */
	Article addArticle(Article a);

	/**
	 * ɾ������
	 * 
	 * @param id
	 * @return
	 */
	boolean deleteArticle(String id);

	/**
	 * ��ȡ���е�����
	 * 
	 * @return
	 */
	List getAllArticle();

	/**
	 * ��ȡ�Ķ����������б�
	 * 
	 * @return
	 */
	List getVisitRank();

	/**
	 * ͨ��ĳһ�в�ѯ����
	 * 
	 * @param column
	 * @param value
	 * @return
	 */
	List<Article> getArticleByColumn(String column, String value);

	/**
	 * ��ȡ���µ�����������������
	 * 
	 * @param search_key
	 * @return
	 */
	int getCount(String search_key);

	/**
	 * ����������
	 * 
	 * @param id
	 * @return
	 */
	int star_article(int id);

	/**
	 * ���������
	 * 
	 * @param old_sort
	 * @param new_sort
	 * @return
	 */
	boolean updateSort(String old_sort, String new_sort);

	/**
	 * ɾ�����������
	 * 
	 * @param sort
	 * @return
	 */
	boolean delelteSort(String sort);

}