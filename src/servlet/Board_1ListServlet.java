/**
 * - �Խ��� ��� : Board_1ListServlet -> 1list.jsp (�Ϸ�)
 * - �۾��� : list.jsp -> writeform.jsp -> Board_1WriteServlet 
 * - �󼼱� ���� : lsit.jsp -> Board_1ViewServlet -> view.jsp (�Ϸ�)
 * - �����ϱ� : view.jsp -> editform.jsp -> Board_1EditServlet
 * - �����ϱ� : view.jsp ->DeleteServlet 
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
 * �Խ��� ��� ���� Servlet
 * 
 * 1. �Խñ� ��� �ҷ�����
 * 2. �ҷ��� �Խñ� request ��ü�� ���
 * 3. list.jsp�� forward�ϱ� 
 */
@WebServlet("/board1/list.action")
public class Board_1ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//�Խñ� ��� �ҷ�����
		HttpSession session = request.getSession();
		Board_1Dao dao = new Board_1Dao();
		ArrayList<Board_1> boards = dao.getListAll(); 
		
		//�ҷ��� �Խñ� request ��ü�� ���
		request.setAttribute("board_1", boards);
		
		//�α����� ��� > �����Խ��� ���(board_1list.jsp)���� �̵�
		if(session.getAttribute("userinfo")!=null)
		{
			RequestDispatcher dispatcher  = request.getRequestDispatcher("/board1/list.jsp");
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
