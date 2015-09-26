package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.Board_2Dao;
import model.dto.Board_2;

/**
 * DB�� �ۼ��� �Խù� ���� ��� ����
 * 1. DAO, DTO ��ü ����
 * 2. DTO ��ü�� form���� �ۼ��� data ����
 * 3. Board_1ListServlet �� �̵� (redirect)
 */
@WebServlet("/board2/write.action")
public class Board_2WriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. DAO, DTO ��ü ����
		Board_2 board2 = new Board_2();
		Board_2Dao dao = new Board_2Dao();
		// 2. DTO ��ü�� form���� �ۼ��� data ����
		String content = request.getParameter("contents");
		content = content.replaceAll("\r\n", "&nbsp;");
		content = content.replaceAll("\u0020", "&nbsp;");
		
		board2.setContents_2(content);
		board2.setId_2(request.getParameter("writer"));
		// 3. DB�� ����
		dao.insertBoard(board2);
		
		// 4. Board_1ListServlet �� �̵� (redirect)
		response.sendRedirect("list.action");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		doGet(request, response);
	}

}
