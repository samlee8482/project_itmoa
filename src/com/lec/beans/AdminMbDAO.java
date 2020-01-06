package com.lec.beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import common.D;

public class AdminMbDAO {
	Connection conn;
	PreparedStatement pstmt;
	Statement stmt;
	ResultSet rs;
	
	// DAO 객체가 생성될때 Connection 도 생성된다!
	public AdminMbDAO() {
		
		try {
			Class.forName(D.DRIVER);
			conn = DriverManager.getConnection(D.URL, D.USERID, D.USERPW);
			System.out.println("DAO 객체 생성, 데이터베이스 연결");
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

	
	// 관리자페이지 회원정보검색
	// 1.
	public MbDTO[] createMbArr(ResultSet rs) throws SQLException {	// 데이터 우리가 쓸 수 있는 값으로 바꿔오기
		ArrayList<MbDTO> list = new ArrayList<MbDTO>();

		while(rs.next()){
			int mb_uid = rs.getInt("mb_uid");
			String mb_name = rs.getString("mb_name");
			String mb_id = rs.getString("mb_id");
			String mb_email = rs.getString("mb_email");
			String mb_add1 = rs.getString("mb_add1");
			String mb_add2 = rs.getString("mb_add2");
			String mb_regdate = rs.getString("mb_regdate");
			
			
			MbDTO dto = new MbDTO(mb_uid, mb_name, mb_id, mb_email, mb_add1, mb_add2, mb_regdate);
			list.add(dto);
		}
		
		int size = list.size();
		MbDTO [] arr = new MbDTO[size];
		list.toArray(arr);
		return arr;
	}
	
	// 2.
	public MbDTO[] selectMb(int option_mb_1, int option_mb_2, String option_mb_3) throws SQLException {
		// option_mb_1 은 회원구분
		// option_mb_2 는 검색조건
		// option_mb_3 은 검색키워드
		MbDTO[] arr = null;
		String SELECT_MB = D.SQL_SELECT_USER;
		
		switch(option_mb_2) {
		case 1:
			SELECT_MB += D.SQL_SELECT_USER_WHERE_UID;
			break;
		case 2:
			SELECT_MB += D.SQL_SELECT_USER_WHERE_ID;
			break;
		case 3:
			SELECT_MB += D.SQL_SELECT_USER_WHERE_NAME;
			break;
		case 4:
			SELECT_MB += D.SQL_SELECT_USER_WHERE_EMAIL;
			break;
		}
		
		SELECT_MB += D.SQL_USER_ORDER_BY;
		
		try {
			pstmt = conn.prepareStatement(SELECT_MB);
			
			switch(option_mb_1) {
			case 0:	// 전체회원
				pstmt.setInt(1, 1);					
				pstmt.setInt(2, 2);					
				pstmt.setInt(3, 3);	
				break;
			case 1: // 일반회원일 때
				pstmt.setInt(1, 1);				
				pstmt.setInt(2, 0);					
				pstmt.setInt(3, 0);		
				break;
			case 2: // 슈퍼회원일 때
				pstmt.setInt(1, 2);					
				pstmt.setInt(2, 0);					
				pstmt.setInt(3, 0);	
				break;
			case 3: // 관리자일 때
				pstmt.setInt(1, 3);					
				pstmt.setInt(2, 0);					
				pstmt.setInt(3, 0);		
				break;
			}
			pstmt.setString(4, option_mb_3);
			rs = pstmt.executeQuery();
			arr = createMbArr(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return arr; 
	}
	
	// 관리자페이지 회원상세정보 가져오기
	// 1.
	public MbDTO[] createMbByUidArr(ResultSet rs) throws SQLException {	// 데이터 우리가 쓸 수 있는 값으로 바꿔오기
		ArrayList<MbDTO> list = new ArrayList<MbDTO>();

		while(rs.next()){
			int mb_uid = rs.getInt("mb_uid");
			String mb_id = rs.getString("mb_id");
			String mb_pw = rs.getString("mb_pw");
			String mb_name = rs.getString("mb_name");
			String mb_email = rs.getString("mb_email");
			int mb_level = rs.getInt("mb_level");
			int mb_zip = rs.getInt("mb_zip");
			String mb_add1 = rs.getString("mb_add1");
			String mb_add2 = rs.getString("mb_add2");
			String mb_img = rs.getString("mb_img");
			
			MbDTO dto = new MbDTO(mb_uid, mb_id, mb_pw, mb_name, mb_email, mb_level, mb_zip, mb_add1, mb_add2, mb_img);
			list.add(dto);			
		}
		
		int size = list.size();
		MbDTO [] arr = new MbDTO[size];
		list.toArray(arr);
		return arr;
	}
	
	// 2.
	public MbDTO[] selectMbByUid(int mb_uid) throws SQLException {
		MbDTO[] arr = null;
		String SELECT_MB = D.SQL_SELECT_USER + D.SQL_SELECT_USER_WHERE_UID;
		
		try {
			pstmt = conn.prepareStatement(SELECT_MB);
			pstmt.setInt(1, mb_uid);
			rs = pstmt.executeQuery();
			arr = createMbByUidArr(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return arr; 
	}

	// 관리자페이지 회원정보수정
	public int updateMbByUid(String mb_pw, String mb_img, int mb_level, String mb_email, int mb_zip, String mb_add1, String mb_add2,
		int mb_uid) throws SQLException{
		int cnt = 0;
		
		try {
			pstmt = conn.prepareStatement(D.SQL_UPDATE_USER);
			pstmt.setString(1, mb_pw);
			pstmt.setString(2, mb_img);
			pstmt.setInt(3, mb_level);
			pstmt.setString(4, mb_email);
			pstmt.setInt(5, mb_zip);
			pstmt.setString(6, mb_add1);
			pstmt.setString(7, mb_add2);
			pstmt.setInt(8, mb_uid);
			cnt = pstmt.executeUpdate();
			
		} finally {
			close();
		}
		
		return cnt;
	}

	// 관리자페이지 회원정보삭제
	public int deleteMbByUid(int mb_uid) throws SQLException{
		int cnt = 0;
		
		try {
			pstmt = conn.prepareStatement(D.SQL_DELETE_USER_BY_UID);
			pstmt.setInt(1, mb_uid);
			cnt = pstmt.executeUpdate();
			
		} finally {
			close();
		}
		
		return cnt;
	}
	
	
	
}