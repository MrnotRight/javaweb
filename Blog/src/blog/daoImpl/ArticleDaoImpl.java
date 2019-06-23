package blog.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import blog.dao.ArticleDao;
import blog.db.C3P0Connection;
import blog.model.Article;
import blog.utils.DBUtils;

/*
 * 鏂囩珷鏈嶅姟绫�
 *
 */
public class ArticleDaoImpl implements ArticleDao {

	private Connection conn;
	private static ArticleDao instance;

	private ArticleDaoImpl() {
		conn = C3P0Connection.getInstance().getConnection();
	}

	public static final ArticleDao getInstance() {
		if (instance == null) {
			try {
				instance = new ArticleDaoImpl();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return instance;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see blog.daoImpl.ArticleDao#addVisit(int)
	 */
	@Override
	public void addVisit(int article_id) {

		String sql = "update t_article set visit = visit+1 where id = " + article_id;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see blog.daoImpl.ArticleDao#getANearArticle(java.lang.String, int)
	 */
	@Override
	public Article getANearArticle(String time, int less_or_more) {

		Article article = null;
		String sql = null;
		if (less_or_more == this.LESS) {
			sql = " SELECT  * FROM t_article WHERE TIME< '" + time + "'  ORDER BY TIME DESC ";
		} else if (less_or_more == this.MORE) {
			sql = " SELECT  * FROM t_article WHERE TIME > '" + time + "'  ORDER BY TIME ";
		}
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				article = new Article(rs.getInt("id"), rs.getString("title"), rs.getString("author"),
						rs.getString("sort"), rs.getString("time"), rs.getInt("star"), rs.getInt("comment"),
						rs.getInt("visit"), rs.getString("content"));
			}
			DBUtils.Close(ps, rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return article;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see blog.daoImpl.ArticleDao#getColumAndCount(java.lang.String)
	 */
	@Override
	public Map getColumAndCount(String search_column) {

		String sql = " select " + search_column + " ,count(" + search_column + ") as counts  from t_article  group by "
				+ search_column;
		Map map = null;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			map = new HashMap();
			while (rs.next()) {
				map.put(rs.getString(search_column), rs.getInt("counts"));
			}
			DBUtils.Close(ps, rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see blog.daoImpl.ArticleDao#getAllSort()
	 */
	@Override
	public List getAllSort() {

		String sql = " select distinct(sort) from t_article order by sort";
		List list = null;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			list = new ArrayList();
			while (rs.next()) {
				list.add(rs.getString(1));
			}
			DBUtils.Close(ps, rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see blog.daoImpl.ArticleDao#addArticle(blog.model.Article)
	 */
	@Override
	public Article addArticle(Article a) {

		String sql = "insert into t_article values(null,?,?,?,?,?,?,?,?)";
		PreparedStatement ps;
		int result = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, a.getTitle());
			ps.setString(2, a.getAuthor());
			ps.setString(3, a.getSort());
			ps.setString(4, a.getTime());
			ps.setInt(5, a.getStar());
			ps.setInt(6, a.getComment());
			ps.setInt(7, a.getVisit());
			ps.setString(8, a.getContent());
			result = ps.executeUpdate();
			DBUtils.Close(ps);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return this.getLastArticle();

	}

	/**
	 * 灏嗘枃绔犲姞鍒癲elte琛�
	 * 
	 * @param a
	 * @return
	 */
	private boolean addArticle_delet(Article a) {

		String sql = "insert into t_article_delet values(null,?,?,?,?,?,?,?,?)";
		PreparedStatement ps;
		int result = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, a.getTitle());
			ps.setString(2, a.getAuthor());
			ps.setString(3, a.getSort());
			ps.setString(4, a.getTime());
			ps.setInt(5, a.getStar());
			ps.setInt(6, a.getComment());
			ps.setInt(7, a.getVisit());
			ps.setString(8, a.getContent());
			result = ps.executeUpdate();
			DBUtils.Close(ps);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result > 0;

	}

	/**
	 * 鑾峰彇鏈�鏂扮殑鏂囩珷
	 * 
	 * @return
	 */
	private Article getLastArticle() {

		String sql = "SELECT * FROM t_article ORDER BY TIME DESC LIMIT 1";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				Article article = new Article(rs.getInt("id"), rs.getString("title"), rs.getString("author"),
						rs.getString("sort"), rs.getString("time"), rs.getInt("star"), rs.getInt("comment"),
						rs.getInt("visit"), rs.getString("content"));
				DBUtils.Close(ps, rs);
				return article;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see blog.daoImpl.ArticleDao#deleteArticle(java.lang.String)
	 */
	@Override
	public boolean deleteArticle(String id) {

		String sql = "delete from t_article where id=?";
		PreparedStatement ps;
		int result = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			result = ps.executeUpdate();
			// 鍏抽棴杩炴帴
			DBUtils.Close(ps);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result != 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see blog.daoImpl.ArticleDao#getAllArticle()
	 */
	@Override
	public List getAllArticle() {
		List<Article> list = new ArrayList();

		String sql = "select * from t_article";
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			// bean瀹炰緥鍖�
			while (rs.next()) {
				Article article = new Article(rs.getInt("id"), rs.getString("title"), rs.getString("author"),
						rs.getString("sort"), rs.getString("time"), rs.getInt("star"), rs.getInt("comment"),
						rs.getInt("visit"), rs.getString("content"));
				list.add(article);
			}
			// 鍏抽棴杩炴帴
			DBUtils.Close(ps, rs);
			// 鎺掑簭 article compareTo();
			Collections.sort(list);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see blog.daoImpl.ArticleDao#getVisitRank()
	 */
	@Override
	public List getVisitRank() {
		List<Article> list = new ArrayList();

		String sql = "SELECT * FROM t_article ORDER BY visit DESC";
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			// bean瀹炰緥鍖�
			while (rs.next()) {
				Article article = new Article(rs.getInt("id"), rs.getString("title"), rs.getString("author"),
						rs.getString("sort"), rs.getString("time"), rs.getInt("star"), rs.getInt("comment"),
						rs.getInt("visit"), rs.getString("content"));
				list.add(article);
			}
			// 鍏抽棴杩炴帴
			DBUtils.Close(ps, rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see blog.daoImpl.ArticleDao#getArticleByColumn(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public List<Article> getArticleByColumn(String column, String value) {
		List<Article> list = null;
		Article at = null;
		String sql = "select * from t_article where " + column + " = ?";
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, value);
			ResultSet rs = ps.executeQuery();
			// bean瀹炰緥鍖�
			list = new ArrayList();
			while (rs.next()) {
				at = new Article(rs.getInt("id"), rs.getString("title"), rs.getString("author"), rs.getString("sort"),
						rs.getString("time"), rs.getInt("star"), rs.getInt("comment"), rs.getInt("visit"),
						rs.getString("content"));
				list.add(at);
			}
			// 鍏抽棴杩炴帴
			DBUtils.Close(ps, rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see blog.daoImpl.ArticleDao#getCount(java.lang.String)
	 */
	@Override
	public int getCount(String search_key) {

		String sql;
		if (search_key.equals(SEARCH_ARTICLE)) {
			sql = "SELECT COUNT(id) FROM t_article";//统计文章数
		} else {// SEARCH_SORT
			sql = "SELECT COUNT(DISTINCT(sort)) FROM t_article";//统计文章分类数
		}
		int result = 0;
		try {

			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				result = rs.getInt(1);
			}
			DBUtils.Close(ps, rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see blog.daoImpl.ArticleDao#star_article(int)
	 */
	@Override
	public int star_article(int id) {

		String sql = "update t_article set star=star+1 where id=" + id;
		int result = 0;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.executeUpdate();
			// DBUtils.Close(conn, ps);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		sql = "select star from t_article where id=" + id;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				result = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see blog.daoImpl.ArticleDao#updateSort(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean updateSort(String old_sort, String new_sort) {

		String sql = "UPDATE t_article SET sort=? WHERE sort=?";
		int result = 0;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, new_sort);
			ps.setString(2, old_sort);
			ps.executeUpdate();
			DBUtils.Close(ps);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result > 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see blog.daoImpl.ArticleDao#delelteSort(java.lang.String)
	 */
	@Override
	public boolean delelteSort(String sort) {
		// 鎵惧埌杩欎釜鍒嗙被涓嬬殑鏂囩珷 绉诲姩鍒皌_article_delet
		String sql = "SELECT * FROM t_article where sort = ?";
		int result = 0;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, sort);
			ResultSet rs = ps.executeQuery();

			List<Article> list = new ArrayList();
			while (rs.next()) {
				Article article = new Article(rs.getInt("id"), rs.getString("title"), rs.getString("author"),
						rs.getString("sort"), rs.getString("time"), rs.getInt("star"), rs.getInt("comment"),
						rs.getInt("visit"), rs.getString("content"));
				list.add(article);
			}
			System.out.println(list.size());
			if (list.size() > 0) {
				for (Article a : list) {
					this.addArticle_delet(a);
				}
			}

			sql = "delete from t_article where sort =?";
			PreparedStatement ps2 = conn.prepareStatement(sql);
			ps2.setString(1, sort);
			result = ps2.executeUpdate();
			System.out.println(result);
			DBUtils.Close(ps);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result > 0;
	}

}

// 2017骞�9鏈�19鏃�21:57:38 澶у悏澶у埄 浠婃櫄鍚冮浮
// bug鏃犳晫澶� fuck
// 2017骞�9鏈�26鏃�15:10:47 杩欎釜绫绘湁姣�
