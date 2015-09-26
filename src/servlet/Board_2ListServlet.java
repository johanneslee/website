/**
 * - �Խ��� ��� : Board_2ListServlet -> board_2list.jsp (�Ϸ�)
 * - �۾��� : board_2list.jsp -> board_2writeform.jsp -> Board_2WriteServlet 
 * - �󼼱� ���� : board_2lsit.jsp -> Board_2ViewServlet -> board_2view.jsp (�Ϸ�)
 * - �����ϱ� : board_2view.jsp -> Board_2DeleteServlet 
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
 * �Խ��� ��� ���� Servlet
 * 
 * 1. �Խñ� ��� �ҷ�����
 * 2. �ҷ��� �Խñ� request ��ü�� ���
 * 3. list.jsp�� forward�ϱ� 
 */
@WebServlet("/board2/list.action")
public class Board_2ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		//�Խñ� ��� �ҷ�����
		Board_2Dao dao = new Board_2Dao();
		ArrayList<Board_2> boards = dao.getListAll(); 
		
		//�ҷ��� �Խñ� request ��ü�� ���
		request.setAttribute("board_2", boards);
		
		if(session.getAttribute("userinfo")!=null)
		{
			RequestDispatcher dispatcher  = request.getRequestDispatcher("/board2/simpleboard.jsp");
			dispatcher.forward(request, response);
		}
		
		//�α��� ���Ѱ�� > �α����������� �̵�
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
