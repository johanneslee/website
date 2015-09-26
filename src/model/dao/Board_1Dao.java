package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.dto.Board_1;
/**
 * 1. �Խñ� ����ϱ�
 * 2. ��ü��� �ҷ�����
 * 3. �Խñ� ��ȣ�� �� ���� �ҷ�����
 * 4. ���� �����ϱ�
 * 5. �Խñ� �����ϱ�
 */

public class Board_1Dao {
	
	//1. �Խñ� ����ϱ�
	public void insertBoard(Board_1 board1)
	{
		Connection conn = null;
		PreparedStatement pstmt = null;

		// �����ͺ��̽� ������������� ���ڿ��� ����
		String jdbc_driver = "oracle.jdbc.driver.OracleDriver";
		String jdbc_url = "jdbc:oracle:thin:@127.0.0.1:1521";
		
		try{
			// JDBC ����̹� �ε�
			Class.forName(jdbc_driver);

			// �����ͺ��̽� ���������� �̿��� Connection �ν��Ͻ� Ȯ��
			conn = DriverManager.getConnection(jdbc_url,"admin","admin");

			// Connection Ŭ������ �ν��Ͻ��� ���� SQL  �� �ۼ��� ���� Statement �غ�
			StringBuffer sql = new StringBuffer(500);
			sql.append("insert into BOARD_1(TITLE, ID_1, DATE_1, CONTENTS_1, COUNT) ");
			sql.append("values(?,?,sysdate,?,?) ");
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, board1.getTitle());
			pstmt.setString(2, board1.getId_1());
			pstmt.setString(3, board1.getContents_1());
			pstmt.setInt(4, 0);
			
			pstmt.executeUpdate();

		}
		catch(Exception e) {
			System.out.println(e);
		}
		finally{
			try{pstmt.close();} catch(Exception e){}
			try{conn.close();} catch(Exception e){}
		}
		
	}
	
	
	//2. ��ü��� �ҷ�����
	public ArrayList<Board_1> getListAll()
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Board_1> boards = new ArrayList<Board_1>();

		// �����ͺ��̽� ������������� ���ڿ��� ����
		String jdbc_driver = "oracle.jdbc.driver.OracleDriver";
		String jdbc_url = "jdbc:oracle:thin:@127.0.0.1:1521";
		
		try{
			// JDBC ����̹� �ε�
			Class.forName(jdbc_driver);

			// �����ͺ��̽� ���������� �̿��� Connection �ν��Ͻ� Ȯ��
			conn = DriverManager.getConnection(jdbc_url,"admin","admin");

			// Connection Ŭ������ �ν��Ͻ��� ���� SQL  �� �ۼ��� ���� Statement �غ�
			StringBuffer sql = new StringBuffer(500);
			sql.append("SELECT num_1,title,id_1,date_1,count ");
			sql.append("FROM BOARD_1 ");
			sql.append("ORDER BY num_1 DESC");
			
			pstmt = conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();

			// userid�� passwd ���� �Է��� ��� sql ������ ����.
			rs = pstmt.executeQuery();
				
			while(rs.next())
			{
				Board_1 board_1 = new Board_1();
				
				board_1.setNum_1(rs.getInt(1));
				board_1.setTitle(rs.getString(2));
				board_1.setId_1(rs.getString(3));
				board_1.setDate(rs.getDate(4));
				board_1.setCount(rs.getInt(5));
				
				boards.add(board_1);
			}
	
		}
		catch(Exception e) {
			System.out.println(e);
		}
		finally{
			try{rs.close();} catch(Exception e){}
			try{pstmt.close();} catch(Exception e){}
			try{conn.close();} catch(Exception e){}
		}
		return boards;
		
	}
	
	// �Խñ� ��ȣ�� �� �ҷ�����
	public Board_1 getViewByListNo(int no)
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Board_1 board = new Board_1();
		// �����ͺ��̽� ������������� ���ڿ��� ����
		String jdbc_driver = "oracle.jdbc.driver.OracleDriver";
		String jdbc_url = "jdbc:oracle:thin:@127.0.0.1:1521";
		
		try{
			// JDBC ����̹� �ε�
			Class.forName(jdbc_driver);

			// �����ͺ��̽� ���������� �̿��� Connection �ν��Ͻ� Ȯ��
			conn = DriverManager.getConnection(jdbc_url,"admin","admin");

			// Connection Ŭ������ �ν��Ͻ��� ���� SQL  �� �ۼ��� ���� Statement �غ�
			StringBuffer sql = new StringBuffer(500);
			sql.append("SELECT * ");
			sql.append("FROM BOARD_1 ");
			sql.append("WHERE num_1=?");
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			
			while(rs.next())
			{
				board.setNum_1(rs.getInt(1));
				board.setTitle(rs.getString(2));
				board.setId_1(rs.getString(3));
				board.setDate(rs.getDate(4));
				board.setContents_1(rs.getString(5));
				board.setCount(rs.getInt(6));
			}
	
		}
		catch(Exception e) {
			System.out.println(e);
		}
		finally{
			try{rs.close();} catch(Exception e){}
			try{pstmt.close();} catch(Exception e){}
			try{conn.close();} catch(Exception e){}
		}
		return board;
		
	}
	
	// ���� �����ϱ�
	public void updateByListNo(Board_1 board)
	{
		Connection conn = null;
		PreparedStatement pstmt = null;

		// �����ͺ��̽� ������������� ���ڿ��� ����
		String jdbc_driver = "oracle.jdbc.driver.OracleDriver";
		String jdbc_url = "jdbc:oracle:thin:@127.0.0.1:1521";
		
		try{
			// JDBC ����̹� �ε�
			Class.forName(jdbc_driver);

			// �����ͺ��̽� ���������� �̿��� Connection �ν��Ͻ� Ȯ��
			conn = DriverManager.getConnection(jdbc_url,"admin","admin");

			// Connection Ŭ������ �ν��Ͻ��� ���� SQL  �� �ۼ��� ���� Statement �غ�
			StringBuffer sql = new StringBuffer(500);
			sql.append("update BOARD_1 ");
			sql.append("set title=?, contents_1=? ");
			sql.append("where num_1=? ");
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getContents_1());
			pstmt.setInt(3, board.getNum_1());
			
			pstmt.executeUpdate();

		}
		catch(Exception e) {
			System.out.println(e);
		}
		finally{
			try{pstmt.close();} catch(Exception e){}
			try{conn.close();} catch(Exception e){}
		}
		
		
	}
	
	// �Խñ� �����ϱ�
	public void deleteViewByListNo(int no)
	{
		Connection conn = null;
		PreparedStatement pstmt = null;

		// �����ͺ��̽� ������������� ���ڿ��� ����
		String jdbc_driver = "oracle.jdbc.driver.OracleDriver";
		String jdbc_url = "jdbc:oracle:thin:@127.0.0.1:1521";
		
		try{
			// JDBC ����̹� �ε�
			Class.forName(jdbc_driver);

			// �����ͺ��̽� ���������� �̿��� Connection �ν��Ͻ� Ȯ��
			conn = DriverManager.getConnection(jdbc_url,"admin","admin");

			// Connection Ŭ������ �ν��Ͻ��� ���� SQL  �� �ۼ��� ���� Statement �غ�
			StringBuffer sql = new StringBuffer(500);
			sql.append("delete from BOARD_1 ");
			sql.append("where num_1=? ");
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, no);
			
			pstmt.executeUpdate();

		}
		catch(Exception e) {
			System.out.println(e);
		}
		finally{
			try{pstmt.close();} catch(Exception e){}
			try{conn.close();} catch(Exception e){}
		}	
	}
	
	//��ȸ�� count ������Ű��
	public void increaseReadCount(int no)
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String jdbc_driver="oracle.jdbc.driver.OracleDriver";
		String jdbc_url="jdbc:oracle:thin:@127.0.0.1:1521";
		
		try{
			// JDBC ����̹� �ε�
			Class.forName(jdbc_driver);

			// �����ͺ��̽� ���������� �̿��� Connection �ν��Ͻ� Ȯ��
			conn = DriverManager.getConnection(jdbc_url,"admin","admin");

			// Connection Ŭ������ �ν��Ͻ��� ���� SQL  �� �ۼ��� ���� Statement �غ�
			StringBuffer sql = new StringBuffer(500);
			sql.append("update BOARD_1 ");
			sql.append("set count = count + 1 ");
			sql.append("where num_1=?");
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, no);
			
			pstmt.executeUpdate();
		
		}
		catch(Exception e) {
			System.out.println(e);
		}
		finally{
			try{pstmt.close();} catch(Exception e){}
			try{conn.close();} catch(Exception e){}
		}
			
	}

}
