/**
 * - 게시판 목록 : Board_2ListServlet -> board_2list.jsp (완료)
 * - 글쓰기 : board_2list.jsp -> board_2writeform.jsp -> Board_2WriteServlet 
 * - 상세글 보기 : board_2lsit.jsp -> Board_2ViewServlet -> board_2view.jsp (완료)
 * - 삭제하기 : board_2view.jsp -> Board_2DeleteServlet 
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

import model.dao.Board_2Dao;
import model.dto.Board_2;

/**
 * 게시판 목록 연결 Servlet
 * 
 * 1. 게시글 목록 불러오기
 * 2. 불러온 게시글 request 객체에 담기
 * 3. list.jsp로 forward하기 
 */
@WebServlet("/board2/list.action")
public class Board_2ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		//게시글 목록 불러오기
		Board_2Dao dao = new Board_2Dao();
		ArrayList<Board_2> boards = dao.getListAll(); 
		
		//불러온 게시글 request 객체에 담기
		request.setAttribute("board_2", boards);
		
		if(session.getAttribute("userinfo")!=null)
		{
			RequestDispatcher dispatcher  = request.getRequestDispatcher("/board2/simpleboard.jsp");
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
