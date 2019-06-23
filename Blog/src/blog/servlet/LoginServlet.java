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

		// ��ʼ������
		ArticleService as = ArticleService.getInstance();
		request.setAttribute("sort_count_map", as.getSortAndCount());//���ͼ���
		// ��ʼ�������б�
		request.setAttribute("article_list", as.getArticle());//ȡ����������
		// ��ʼ����ȡ��ǩ
		TagService ts = TagService.getInstance();
		request.setAttribute("tag_list", ts.getAllTag());//��ȡ���е�tag

		// ��ʼ������� ��־�����ࡢ��ǩ�ĸ���
		request.setAttribute("article_number", as.getCount(ArticleDao.SEARCH_ARTICLE));
		request.setAttribute("sort_number", as.getCount(ArticleDao.SEARCH_SORT));
		request.setAttribute("tags_number", ts.getTagCount());

		// �Ķ����С�
		request.setAttribute("visit_rank", as.getVisitRank());//��ʾ����ǰʮ�����£����ұ������20���ַ�����ʡ�ԺŴ����������

		// ����վ��ͳ������
		request.setAttribute("visited", VisitorDB.totalVisit());
		request.setAttribute("member", VisitorDB.totalMember());
		request.getSession().setAttribute("onlineUsers", SessionCounter.onlineCounter());

		// ת���� ������ҳ ����
		request.getRequestDispatcher("/page/main.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
