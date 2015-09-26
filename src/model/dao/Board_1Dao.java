package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.dto.Board_1;
/**
 * 1. 게시글 등록하기
 * 2. 전체목록 불러오기
 * 3. 게시글 번호로 상세 내용 불러오기
 * 4. 내용 수정하기
 * 5. 게시글 삭제하기
 */

public class Board_1Dao {
	
	//1. 게시글 등록하기
	public void insertBoard(Board_1 board1)
	{
		Connection conn = null;
		PreparedStatement pstmt = null;

		// 데이터베이스 연결관련정보를 문자열로 선언
		String jdbc_driver = "oracle.jdbc.driver.OracleDriver";
		String jdbc_url = "jdbc:oracle:thin:@127.0.0.1:1521";
		
		try{
			// JDBC 드라이버 로드
			Class.forName(jdbc_driver);

			// 데이터베이스 연결정보를 이용해 Connection 인스턴스 확보
			conn = DriverManager.getConnection(jdbc_url,"admin","admin");

			// Connection 클래스의 인스턴스로 부터 SQL  문 작성을 위한 Statement 준비
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
	
	
	//2. 전체목록 불러오기
	public ArrayList<Board_1> getListAll()
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Board_1> boards = new ArrayList<Board_1>();

		// 데이터베이스 연결관련정보를 문자열로 선언
		String jdbc_driver = "oracle.jdbc.driver.OracleDriver";
		String jdbc_url = "jdbc:oracle:thin:@127.0.0.1:1521";
		
		try{
			// JDBC 드라이버 로드
			Class.forName(jdbc_driver);

			// 데이터베이스 연결정보를 이용해 Connection 인스턴스 확보
			conn = DriverManager.getConnection(jdbc_url,"admin","admin");

			// Connection 클래스의 인스턴스로 부터 SQL  문 작성을 위한 Statement 준비
			StringBuffer sql = new StringBuffer(500);
			sql.append("SELECT num_1,title,id_1,date_1,count ");
			sql.append("FROM BOARD_1 ");
			sql.append("ORDER BY num_1 DESC");
			
			pstmt = conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();

			// userid와 passwd 값을 입력한 경우 sql 문장을 수행.
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
	
	// 게시글 번호로 글 불러오기
	public Board_1 getViewByListNo(int no)
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Board_1 board = new Board_1();
		// 데이터베이스 연결관련정보를 문자열로 선언
		String jdbc_driver = "oracle.jdbc.driver.OracleDriver";
		String jdbc_url = "jdbc:oracle:thin:@127.0.0.1:1521";
		
		try{
			// JDBC 드라이버 로드
			Class.forName(jdbc_driver);

			// 데이터베이스 연결정보를 이용해 Connection 인스턴스 확보
			conn = DriverManager.getConnection(jdbc_url,"admin","admin");

			// Connection 클래스의 인스턴스로 부터 SQL  문 작성을 위한 Statement 준비
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
	
	// 내용 수정하기
	public void updateByListNo(Board_1 board)
	{
		Connection conn = null;
		PreparedStatement pstmt = null;

		// 데이터베이스 연결관련정보를 문자열로 선언
		String jdbc_driver = "oracle.jdbc.driver.OracleDriver";
		String jdbc_url = "jdbc:oracle:thin:@127.0.0.1:1521";
		
		try{
			// JDBC 드라이버 로드
			Class.forName(jdbc_driver);

			// 데이터베이스 연결정보를 이용해 Connection 인스턴스 확보
			conn = DriverManager.getConnection(jdbc_url,"admin","admin");

			// Connection 클래스의 인스턴스로 부터 SQL  문 작성을 위한 Statement 준비
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
	
	// 게시글 삭제하기
	public void deleteViewByListNo(int no)
	{
		Connection conn = null;
		PreparedStatement pstmt = null;

		// 데이터베이스 연결관련정보를 문자열로 선언
		String jdbc_driver = "oracle.jdbc.driver.OracleDriver";
		String jdbc_url = "jdbc:oracle:thin:@127.0.0.1:1521";
		
		try{
			// JDBC 드라이버 로드
			Class.forName(jdbc_driver);

			// 데이터베이스 연결정보를 이용해 Connection 인스턴스 확보
			conn = DriverManager.getConnection(jdbc_url,"admin","admin");

			// Connection 클래스의 인스턴스로 부터 SQL  문 작성을 위한 Statement 준비
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
	
	//조회수 count 증가시키기
	public void increaseReadCount(int no)
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String jdbc_driver="oracle.jdbc.driver.OracleDriver";
		String jdbc_url="jdbc:oracle:thin:@127.0.0.1:1521";
		
		try{
			// JDBC 드라이버 로드
			Class.forName(jdbc_driver);

			// 데이터베이스 연결정보를 이용해 Connection 인스턴스 확보
			conn = DriverManager.getConnection(jdbc_url,"admin","admin");

			// Connection 클래스의 인스턴스로 부터 SQL  문 작성을 위한 Statement 준비
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
