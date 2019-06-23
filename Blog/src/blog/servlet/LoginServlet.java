package blog.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import blog.dao.ArticleDao;
import blog.db.VisitorDB;
import blog.listener.SessionCounter;
import blog.service.ArticleService;
import blog.service.TagService;
import blog.utils.LoginUtils;

/**
 * Login->index.jsp->init data
 */
//@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		LoginUtils.login(request);

		// 初始化分类
		ArticleService as = ArticleService.getInstance();
		request.setAttribute("sort_count_map", as.getSortAndCount());//类别和计数
		// 初始化文章列表
		request.setAttribute("article_list", as.getArticle());//取出所有文章
		// 初始化获取标签
		TagService ts = TagService.getInstance();
		request.setAttribute("tag_list", ts.getAllTag());//获取所有的tag

		// 初始化侧边栏 日志、分类、标签的个数
		request.setAttribute("article_number", as.getCount(ArticleDao.SEARCH_ARTICLE));
		request.setAttribute("sort_number", as.getCount(ArticleDao.SEARCH_SORT));
		request.setAttribute("tags_number", ts.getTagCount());

		// 阅读排行
		request.setAttribute("visit_rank", as.getVisitRank());//显示排名前十的文章，并且标题大于20个字符的以省略号代替后面内容

		// 传网站的统计数据
		request.setAttribute("visited", VisitorDB.totalVisit());
		request.setAttribute("member", VisitorDB.totalMember());
		request.getSession().setAttribute("onlineUsers", SessionCounter.onlineCounter());

		// 转发到 博客主页 界面
		request.getRequestDispatcher("/page/main.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
