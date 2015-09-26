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
 * �Խù� ���� ����
 * 
 * 1.dao
 * - ���⼭ �ۼ��ڶ� �����Ϸ��� ��� ������ Ȯ������� �� ( ���� )
 * 2.����
 * 3.list�� �̵� 
 */
@WebServlet("/board1/delete.action")
public class Board_1DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. dao
		Board_1Dao dao = new Board_1Dao();
		//2. ����
		dao.deleteViewByListNo(Integer.parseInt(request.getParameter("no")));
		//3. �̵�
		response.sendRedirect("list.action");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		doGet(request, response);
	}

}
