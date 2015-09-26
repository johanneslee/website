package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.dto.Board_2;
/**
 * 1. 게시글 등록하기
 * 2. 전체목록 불러오기
 * 3. 게시글 번호로 상세 내용 불러오기
 * 4. 게시글 삭제하기
 */

public class Board_2Dao {
	
	//1. 게시글 등록하기
	public void insertBoard(Board_2 board2)
	{
		Connection conn = null;
		PreparedStatement pstmt = null;

		// 데이터베이스 연결관련정보를 문자열로 선언
		String jdbc_driver = "oracle.jdbc.driver.OracleDriver";
		String jdbc_url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
		
		try{
			// JDBC 드라이버 로드
			Class.forName(jdbc_driver);

			// 데이터베이스 연결정보를 이용해 Connection 인스턴스 확보
			conn = DriverManager.getConnection(jdbc_url,"admin","admin");

			// Connection 클래스의 인스턴스로 부터 SQL  문 작성을 위한 Statement 준비
			StringBuffer sql = new StringBuffer(500);
			sql.append("insert into BOARD_2(ID_2, DATE_2, CONTENTS_2) ");
			sql.append("values(?,sysdate,?) ");
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, board2.getId_2());
			pstmt.setString(2, board2.getContents_2());
			
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
	public ArrayList<Board_2> getListAll()
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Board_2> boards = new ArrayList<Board_2>();

		// 데이터베이스 연결관련정보를 문자열로 선언
		String jdbc_driver = "oracle.jdbc.driver.OracleDriver";
		String jdbc_url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
		
		try{
			// JDBC 드라이버 로드
			Class.forName(jdbc_driver);

			// 데이터베이스 연결정보를 이용해 Connection 인스턴스 확보
			conn = DriverManager.getConnection(jdbc_url,"admin","admin");

			// Connection 클래스의 인스턴스로 부터 SQL  문 작성을 위한 Statement 준비
			StringBuffer sql = new StringBuffer(500);
			sql.append("SELECT * ");
			sql.append("FROM BOARD_2 ");
			sql.append("ORDER BY num_2 DESC");
			
			pstmt = conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();

			// userid와 passwd 값을 입력한 경우 sql 문장을 수행.
			rs = pstmt.executeQuery();
				
			while(rs.next())
			{
				Board_2 board_2 = new Board_2();
				
				board_2.setNum_2(rs.getInt(1));
				board_2.setId_2(rs.getString(2));
				board_2.setDate(rs.getDate(3));
				board_2.setContents_2(rs.getString(4));
				
				boards.add(board_2);
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
	
	

	// 게시글 삭제하기
	public void deleteViewByListNo(int no)
	{
		Connection conn = null;
		PreparedStatement pstmt = null;

		// 데이터베이스 연결관련정보를 문자열로 선언
		String jdbc_driver = "oracle.jdbc.driver.OracleDriver";
		String jdbc_url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
		
		try{
			// JDBC 드라이버 로드
			Class.forName(jdbc_driver);

			// 데이터베이스 연결정보를 이용해 Connection 인스턴스 확보
			conn = DriverManager.getConnection(jdbc_url,"admin","admin");

			// Connection 클래스의 인스턴스로 부터 SQL  문 작성을 위한 Statement 준비
			StringBuffer sql = new StringBuffer(500);
			sql.append("delete from BOARD_2 ");
			sql.append("where num_2=? ");
			
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
