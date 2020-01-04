package com.lec.beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import common.D;

public class MbDAO {
	Connection conn;
	PreparedStatement pstmt;
	Statement stmt;
	ResultSet rs;
	
	// DAO 객체가 생성될때 Connection 도 생성된다!
	public MbDAO() {
		
		try {
			Class.forName(D.DRIVER);
			conn = DriverManager.getConnection(D.URL, D.USERID, D.USERPW);
			System.out.println("WriteDAO 객체 생성, 데이터베이스 연결");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// DB 자원 반납 메소드
	public void close() throws SQLException {
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
		if(stmt != null) stmt.close();
		if(conn != null) conn.close();
	}

	// 로그인
	public MbDTO[] createLoginArr(ResultSet rs) throws SQLException {	// 데이터 우리가 쓸 수 있는 값으로 바꿔오기
		ArrayList<MbDTO> list = new ArrayList<MbDTO>();

		while(rs.next()){
			int mb_uid = rs.getInt("mb_uid");
			String mb_id = rs.getString("mb_id");
			String mb_pw = rs.getString("mb_pw");
			int mb_level = rs.getInt("mb_level");
			String mb_img = rs.getString("mb_img");
			
			MbDTO dto = new MbDTO(mb_uid, mb_id, mb_pw, mb_level, mb_img);
			list.add(dto);			
		}
		
		int size = list.size();
		MbDTO [] arr = new MbDTO[size];
		list.toArray(arr);
		return arr;
	}
	
	public MbDTO[] login(String mb_id, String mb_pw) {
		MbDTO[] arr = null;
		
		try {
			pstmt = conn.prepareStatement(D.SQL_SELECT_LOGIN);
			pstmt.setString(1, mb_id);
			pstmt.setString(2, mb_pw);
			rs = pstmt.executeQuery();
			arr = createLoginArr(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return arr; 
	}
	
	// 회원가입
	public int join(String mb_name, String mb_id, String mb_pw, String mb_email, int mb_zip, String mb_add1, String mb_add2) {
		int cnt = 0;
		
		try {
			pstmt = conn.prepareStatement(D.SQL_INSERT_JOIN);
			pstmt.setString(1, mb_name);
			pstmt.setString(2, mb_id);
			pstmt.setString(3, mb_pw);
			pstmt.setString(4, mb_email);
			pstmt.setInt(5, mb_zip);
			pstmt.setString(6, mb_add1);
			pstmt.setString(7, mb_add2);
			cnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return cnt;
	}
	
	// 마이페이지
	public MbDTO[] createMypageArr(ResultSet rs) throws SQLException {	// 데이터 우리가 쓸 수 있는 값으로 바꿔오기
		ArrayList<MbDTO> list = new ArrayList<MbDTO>();

		while(rs.next()){
			int mb_uid = rs.getInt("mb_uid");
			String mb_id = rs.getString("mb_id");
			String mb_pw = rs.getString("mb_pw");
			int mb_zip = rs.getInt("mb_zip");
			String mb_add1 = rs.getString("mb_add1");
			String mb_add2 = rs.getString("mb_add2");
			String mb_img = rs.getString("mb_img");
			int zzim_uid = rs.getInt("zzim_uid");
			String ins_name = rs.getString("ins_name");
			String cur_name = rs.getString("cur_name");
			
			
			MbDTO dto = new MbDTO(mb_uid, mb_id, mb_pw, mb_zip, mb_add1, mb_add2, mb_img, zzim_uid, ins_name, cur_name);
			list.add(dto);
		}
		
		int size = list.size();
		MbDTO [] arr = new MbDTO[size];
		list.toArray(arr);
		return arr;
	}
	
	public MbDTO[] myPage(int mb_uid) {
		MbDTO[] arr = null;
		
		try {
			pstmt = conn.prepareStatement(D.SQL_SELECT_LOGIN);
			pstmt.setInt(1, mb_uid);
			rs = pstmt.executeQuery();
			arr = createLoginArr(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return arr; 
	}
	
	public int update(String mb_pw, String mb_email, int mb_zip, String mb_add1, String mb_add2, int mb_uid) throws SQLException{
		int cnt = 0;
		
		try {
			pstmt = conn.prepareStatement(D.SQL_UPDATE_MYPAGE);
			pstmt.setString(1, mb_pw);
			pstmt.setString(2, mb_email);
			pstmt.setInt(3, mb_zip);
			pstmt.setString(4, mb_add1);
			pstmt.setString(5, mb_add2);
			pstmt.setInt(6, mb_uid);
			cnt = pstmt.executeUpdate();
			
		} finally {
			close();
		}
		
		return cnt;
	}
	
}