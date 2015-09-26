/**
 * - 게시판 목록 : Board_1ListServlet -> 1list.jsp (완료)
 * - 글쓰기 : list.jsp -> writeform.jsp -> Board_1WriteServlet 
 * - 상세글 보기 : lsit.jsp -> Board_1ViewServlet -> view.jsp (완료)
 * - 수정하기 : view.jsp -> editform.jsp -> Board_1EditServlet
 * - 삭제하기 : view.jsp ->DeleteServlet 
 */

package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.Board_1Dao;
import model.dto.Board_1;

/**
 * 게시판 목록 연결 Servlet
 * 
 * 1. 게시글 목록 불러오기
 * 2. 불러온 게시글 request 객체에 담기
 * 3. list.jsp로 forward하기 
 */
@WebServlet("/board1/list.action")
public class Board_1ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//게시글 목록 불러오기
		HttpSession session = request.getSession();
		Board_1Dao dao = new Board_1Dao();
		ArrayList<Board_1> boards = dao.getListAll(); 
		
		//불러온 게시글 request 객체에 담기
		request.setAttribute("board_1", boards);
		
		//로그인한 경우 > 자유게시판 목록(board_1list.jsp)으로 이동
		if(session.getAttribute("userinfo")!=null)
		{
			RequestDispatcher dispatcher  = request.getRequestDispatcher("/board1/list.jsp");
			dispatcher.forward(request, response);
		}
		
		//로그인 안한경우 > 로그인페이지로 이동
		else
		{
			RequestDispatcher dispatcher  = request.getRequestDispatcher("/member/login.jsp");
			dispatcher.forward(request, response);
		}
			
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		doGet(request, response);
	}

}
