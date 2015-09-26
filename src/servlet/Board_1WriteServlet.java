package servlet;

import java.io.IOException;




import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.Board_1Dao;
import model.dto.Board_1;

/**
 * DB�� �ۼ��� �Խù� ���� ��� ����
 * 1. DAO, DTO ��ü ����
 * 2. DTO ��ü�� form���� �ۼ��� data ����
 * 3. Board_1ListServlet �� �̵� (redirect)
 */
@WebServlet("/board1/write.action")
public class Board_1WriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. DAO, DTO ��ü ����
		Board_1 board1 = new Board_1();
		Board_1Dao dao = new Board_1Dao();
		// 2. DTO ��ü�� form���� �ۼ��� data ����
		// ����� �ٹٲ� ó��.
		String content = request.getParameter("contents");
		content = content.replaceAll("\r\n", "<br>");
		content = content.replaceAll("\u0020", "&nbsp;");
		
		board1.setTitle(request.getParameter("title"));
		board1.setContents_1(content);
		board1.setId_1(request.getParameter("writer"));
		// 3. DB�� ����
		dao.insertBoard(board1);
		
		// 4. Board_1ListServlet �� �̵� (redirect)
		response.sendRedirect("list.action");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		doGet(request, response);
	}

}
