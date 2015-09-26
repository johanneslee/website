package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.dto.Member;

public class MemberDao {
	
	//1. ȸ������
	public boolean Join(Member join)
	{
		//�����ͺ��̽� ������� ���� ����
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

			// Connection Ŭ������ �ν��Ͻ��� ���� SQL�� �ۼ��� ���� Statement �غ�
			
			
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
	
	//2. ���̵� ã��
	public String FindId(String name)
	{
		//�����ͺ��̽� ������� ���� ����
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		// �����ͺ��̽� ������������� ���ڿ��� ����
		String jdbc_driver = "oracle.jdbc.driver.OracleDriver";
		String jdbc_url = "jdbc:oracle:thin:@127.0.0.1:1521";
		
		try{
			// JDBC ����̹� �ε�
			Class.forName(jdbc_driver);

			// �����ͺ��̽� ���������� �̿��� Connection �ν��Ͻ� Ȯ��
			conn = DriverManager.getConnection(jdbc_url,"admin","admin");
			
			StringBuffer sql = new StringBuffer(500);
			sql.append("select id from user_data ");
			sql.append("where name = ? ");
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, name);
			// Connection Ŭ������ �ν��Ͻ��� ���� SQL�� �ۼ��� ���� Statement �غ�
			rs = pstmt.executeQuery();
			
			
			//�Է� �̸��� �����ͺ��̽� ���� �̸��� ��
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
	
	//3. PW ã��
	public String FindPw(String id, String email)
	{
		//�����ͺ��̽� ������� ���� ����
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		// �����ͺ��̽� ������������� ���ڿ��� ����
		String jdbc_driver = "oracle.jdbc.driver.OracleDriver";
		String jdbc_url = "jdbc:oracle:thin:@127.0.0.1:1521";
		
		try{
			// JDBC ����̹� �ε�
			Class.forName(jdbc_driver);

			// �����ͺ��̽� ���������� �̿��� Connection �ν��Ͻ� Ȯ��
			conn = DriverManager.getConnection(jdbc_url,"admin","admin");
			
			StringBuffer sql = new StringBuffer(500);
			sql.append("select passwd from user_data ");
			sql.append("where id = ? and email = ? ");
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, id);
			pstmt.setString(2, email);
			// Connection Ŭ������ �ν��Ͻ��� ���� SQL�� �ۼ��� ���� Statement �غ�
			rs = pstmt.executeQuery();
			
			
			//�Է� �̸��� �����ͺ��̽� ���� �̸��� ��
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
	
	//4. �α����ϱ�
	public boolean Login(String id, String pw)
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		// �����ͺ��̽� ������������� ���ڿ��� ����
		String jdbc_driver = "oracle.jdbc.driver.OracleDriver";
		String jdbc_url = "jdbc:oracle:thin:@127.0.0.1:1521";
		
		try{
			// JDBC ����̹� �ε�
			Class.forName(jdbc_driver);

			// �����ͺ��̽� ���������� �̿��� Connection �ν��Ͻ� Ȯ��
			conn = DriverManager.getConnection(jdbc_url,"admin","admin");

			// Connection Ŭ������ �ν��Ͻ��� ���� SQL  �� �ۼ��� ���� Statement �غ�
			String sql = " select id, passwd from user_data where id=? and passwd=? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);

			rs = pstmt.executeQuery();
			if(rs.next())
			return true; //�ش� ID�� PW�� ������ ���

		}
		catch(Exception e) {
			System.out.println(e);
		}
		finally{
			try{rs.close();} catch(Exception e){}
			try{pstmt.close();} catch(Exception e){}
			try{conn.close();} catch(Exception e){}
		}
		return false; // �ش�ID,PW �������� �ʴ°��
	}
	
	//5. ID�ߺ��˻�
	public boolean checkId(String id)
	{
		//�����ͺ��̽� ������� ���� ����
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		// �����ͺ��̽� ������������� ���ڿ��� ����
		String jdbc_driver = "oracle.jdbc.driver.OracleDriver";
		String jdbc_url = "jdbc:oracle:thin:@127.0.0.1:1521";
		
		try{
			// JDBC ����̹� �ε�
			Class.forName(jdbc_driver);

			// �����ͺ��̽� ���������� �̿��� Connection �ν��Ͻ� Ȯ��
			conn = DriverManager.getConnection(jdbc_url,"admin","admin");
			
			StringBuffer sql = new StringBuffer(500);
			sql.append("select id from user_data ");
			sql.append("where id = ? ");
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, id);
			// Connection Ŭ������ �ν��Ͻ��� ���� SQL�� �ۼ��� ���� Statement �غ�
			rs = pstmt.executeQuery();
			
			
			//�Է� �̸��� �����ͺ��̽� ���� �̸��� ��
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
