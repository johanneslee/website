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
 * ���� ���� ����
 * 1. dao,dto ��ü ����
 * 2. dto ��ü�� ����
 * 3. db ���� ����
 * 4. view.action ���� redirect  
 */
@WebServlet("/board1/edit.action")
public class Board_1EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. dao, dto ��ü ����
		Board_1Dao dao = new Board_1Dao();
		Board_1 board = new Board_1();
		
		//2. dto ��ü�� ����
		// ����� �ٹٲ� ó��.
		String content = request.getParameter("contents");
		content = content.replaceAll("\r\n", "<br>");
		content = content.replaceAll("\u0020", "&nbsp;");
		
		
		board.setNum_1(Integer.parseInt(request.getParameter("no")));
		board.setTitle(request.getParameter("title"));
		board.setContents_1(content);
		
		//3. db ���� ����
		dao.updateByListNo(board);
		
		//4.
		response.sendRedirect("list.action");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		doGet(request, response);
	}

}
