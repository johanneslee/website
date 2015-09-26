package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.Board_1Dao;
import model.dto.Board_1;

/**
 * Servlet implementation class Board_1ViewServlet
 */
@WebServlet("/board1/view.action")
public class Board_1ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// DAO, DTO 객체 생성
		Board_1Dao dao = new Board_1Dao();
		Board_1 board_1 = new Board_1();
		//1. 넘겨받은 게시글 번호를 변수에 저장
		int no = Integer.parseInt(request.getParameter("no"));
		
		//조회수 증가
		dao.increaseReadCount(no);
		//2. 게시글 번호로 게시글 불러오기 및 Board_1 객체에 저장
		board_1 = dao.getViewByListNo(no);
		
		//3. setAttribute
		request.setAttribute("board_1", board_1);
		//4. view.jsp 로 forward
		RequestDispatcher dispatcher = request.getRequestDispatcher("view.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		doGet(request, response);
	}

}
