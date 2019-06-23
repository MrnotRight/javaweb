package blog.ajax;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import blog.service.AdminService;
import blog.service.ArticleService;
import blog.service.TagService;
import blog.utils.StringUtils;

@WebServlet("/AdminDataServlet")
public class AdminDataServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String op = request.getParameter("op");

		AdminService as = AdminService.getInstance();

		switch (op) {

		case "edit_article":

			String a_id1 = request.getParameter("article_id");
			request.setAttribute("edit_article", as.getArticle(a_id1));

			ArticleService ase = ArticleService.getInstance();
			Map sort_count = ase.getSortAndCount();
			request.setAttribute("sort_count", sort_count);
	
			TagService tg = TagService.getInstance();
			List all_tag = tg.getAllTag();
			request.setAttribute("all_tag", all_tag);
			request.getRequestDispatcher("/admin/edit.jsp").forward(request, response);
			break;

		case "delete_article":
			String a_id2 = request.getParameter("article_id");
			as.delteArticle(a_id2);
			break;
		default:
			break;

		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
