package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.dto.Member;

public class MemberDao {
	
	//1. 회원가입
	public boolean Join(Member join)
	{
		//데이터베이스 연결관련 변수 선언
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

			// Connection 클래스의 인스턴스로 부터 SQL문 작성을 위한 Statement 준비
			
			
			StringBuffer sql = new StringBuffer(500);
			sql.append("insert into user_data ");
			sql.append("values(?,?,?,?)");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1,join.getId());
			pstmt.setString(2,join.getPasswd());
			pstmt.setString(3,join.getName());
			pstmt.setString(4,join.getEmail());
			
			pstmt.executeQuery();
			return true;
		}
		catch(Exception e) {
			System.out.println(e);
			return false;
		}
		finally{
			try{pstmt.close();} catch(Exception e){}
			try{conn.close();} catch(Exception e){}
		}
	}
	
	//2. 아이디 찾기
	public String FindId(String name)
	{
		//데이터베이스 연결관련 변수 선언
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		// 데이터베이스 연결관련정보를 문자열로 선언
		String jdbc_driver = "oracle.jdbc.driver.OracleDriver";
		String jdbc_url = "jdbc:oracle:thin:@127.0.0.1:1521";
		
		try{
			// JDBC 드라이버 로드
			Class.forName(jdbc_driver);

			// 데이터베이스 연결정보를 이용해 Connection 인스턴스 확보
			conn = DriverManager.getConnection(jdbc_url,"admin","admin");
			
			StringBuffer sql = new StringBuffer(500);
			sql.append("select id from user_data ");
			sql.append("where name = ? ");
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, name);
			// Connection 클래스의 인스턴스로 부터 SQL문 작성을 위한 Statement 준비
			rs = pstmt.executeQuery();
			
			
			//입력 이름과 데이터베이스 상의 이름을 비교
			if(rs.next()){
				return rs.getString(1);
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
		return "failfindid";
	}
	
	//3. PW 찾기
	public String FindPw(String id, String email)
	{
		//데이터베이스 연결관련 변수 선언
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		// 데이터베이스 연결관련정보를 문자열로 선언
		String jdbc_driver = "oracle.jdbc.driver.OracleDriver";
		String jdbc_url = "jdbc:oracle:thin:@127.0.0.1:1521";
		
		try{
			// JDBC 드라이버 로드
			Class.forName(jdbc_driver);

			// 데이터베이스 연결정보를 이용해 Connection 인스턴스 확보
			conn = DriverManager.getConnection(jdbc_url,"admin","admin");
			
			StringBuffer sql = new StringBuffer(500);
			sql.append("select passwd from user_data ");
			sql.append("where id = ? and email = ? ");
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, id);
			pstmt.setString(2, email);
			// Connection 클래스의 인스턴스로 부터 SQL문 작성을 위한 Statement 준비
			rs = pstmt.executeQuery();
			
			
			//입력 이름과 데이터베이스 상의 이름을 비교
			if(rs.next()){
				return rs.getString(1);
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
		return "failfindpw";
	}
	
	//4. 로그인하기
	public boolean Login(String id, String pw)
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		// 데이터베이스 연결관련정보를 문자열로 선언
		String jdbc_driver = "oracle.jdbc.driver.OracleDriver";
		String jdbc_url = "jdbc:oracle:thin:@127.0.0.1:1521";
		
		try{
			// JDBC 드라이버 로드
			Class.forName(jdbc_driver);

			// 데이터베이스 연결정보를 이용해 Connection 인스턴스 확보
			conn = DriverManager.getConnection(jdbc_url,"admin","admin");

			// Connection 클래스의 인스턴스로 부터 SQL  문 작성을 위한 Statement 준비
			String sql = " select id, passwd from user_data where id=? and passwd=? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);

			rs = pstmt.executeQuery();
			if(rs.next())
			return true; //해당 ID와 PW가 존재할 경우

		}
		catch(Exception e) {
			System.out.println(e);
		}
		finally{
			try{rs.close();} catch(Exception e){}
			try{pstmt.close();} catch(Exception e){}
			try{conn.close();} catch(Exception e){}
		}
		return false; // 해당ID,PW 존재하지 않는경우
	}
	
	//5. ID중복검사
	public boolean checkId(String id)
	{
		//데이터베이스 연결관련 변수 선언
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		// 데이터베이스 연결관련정보를 문자열로 선언
		String jdbc_driver = "oracle.jdbc.driver.OracleDriver";
		String jdbc_url = "jdbc:oracle:thin:@127.0.0.1:1521";
		
		try{
			// JDBC 드라이버 로드
			Class.forName(jdbc_driver);

			// 데이터베이스 연결정보를 이용해 Connection 인스턴스 확보
			conn = DriverManager.getConnection(jdbc_url,"admin","admin");
			
			StringBuffer sql = new StringBuffer(500);
			sql.append("select id from user_data ");
			sql.append("where id = ? ");
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, id);
			// Connection 클래스의 인스턴스로 부터 SQL문 작성을 위한 Statement 준비
			rs = pstmt.executeQuery();
			
			
			//입력 이름과 데이터베이스 상의 이름을 비교
			if(rs.next()){
				return true;
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
		return false;
	}

}
