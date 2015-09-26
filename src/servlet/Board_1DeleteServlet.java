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
 * 게시물 삭제 서블릿
 * 
 * 1.dao
 * - 여기서 작성자랑 삭제하려는 사람 같은지 확인해줘야 함 ( 세션 )
 * 2.삭제
 * 3.list로 이동 
 */
@WebServlet("/board1/delete.action")
public class Board_1DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. dao
		Board_1Dao dao = new Board_1Dao();
		//2. 삭제
		dao.deleteViewByListNo(Integer.parseInt(request.getParameter("no")));
		//3. 이동
		response.sendRedirect("list.action");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		doGet(request, response);
	}

}
