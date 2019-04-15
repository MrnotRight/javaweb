package cn.edu.swu.mvc;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

 
public class DeleteStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String flowId = request.getParameter("flowId");
		StudentDao studentDao = new StudentDao();
		studentDao.deleteByFlowId(Integer.parseInt(flowId));
		request.getRequestDispatcher("/success.jsp").forward(request, response);
	}

}
