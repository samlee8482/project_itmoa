package com.lec.beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import common.D;

public class AdminClassDAO {
	Connection conn;
	PreparedStatement pstmt;
	Statement stmt;
	ResultSet rs;

	public AdminClassDAO() {
		try {
			Class.forName(D.DRIVER);
			conn = DriverManager.getConnection(D.URL, D.USERID, D.USERPW);
			System.out.println("AdminClassDAO() 객체 생성, 데이터베이스 연결");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// DB 자원 반납 메소드
	public void close() throws SQLException {
		if (rs != null)
			rs.close();
		if (pstmt != null)
			pstmt.close();
		if (stmt != null)
			stmt.close();
		if (conn != null)
			conn.close();
	}

	//관리자  AdminClass 배열 생성
	public ClassDTO[] createCurArray(ResultSet rs) throws SQLException {

		ArrayList<ClassDTO> list = new ArrayList<ClassDTO>();

		while (rs.next()) {

			int ins_uid = rs.getInt("ins_uid");
			String ins_name = rs.getString("ins_name");
			String ins_add1 = rs.getString("ins_add1");
			String ins_tel = rs.getString("ins_tel");

			ClassDTO dto = new ClassDTO(ins_uid, ins_name, ins_add1, ins_tel);
			list.add(dto);
		}

		int size = list.size();
		ClassDTO[] arr = new ClassDTO[size];
		list.toArray(arr);
		return arr;
	}

	//	public ClassDTO[] selectCurList() throws SQLException {
	//
	//		ClassDTO [] arr = null;
	//		String selectCur = D.SQL_SELECT_INS;
	//		selectCur += D.SQL_SELECT_INS_ORDER_BY_UID;
	//
	//		try {
	//			// keyword가 있을 경우 쿼리문에 키워드 넘겨주기
	//			pstmt = conn.prepareStatement(selectCur);
	//			rs = pstmt.executeQuery();
	//			arr = createCurArray(rs);
	//		} catch (Exception e) {
	//			e.printStackTrace();
	//		} finally {
	//			close();
	//		}
	//
	//		return arr;
	//	}
	//	
	//	
	//	//학원UID별 출력 
	//	public ClassDTO[] selectInsByUid(int ins_uid) throws SQLException {
	//		ClassDTO[] arr = null ;
	//		
	//		try {
	//			pstmt = conn.prepareStatement(D.SQL_INS_WHERE_UID);
	//			pstmt.setInt(1, ins_uid);
	//			rs = pstmt.executeQuery();
	//			arr = createCurArray(rs);
	//		} catch (SQLException e) {
	//			e.printStackTrace();
	//		} finally {
	//			close();
	//		}
	//		
	//		return arr;
	//	}
	//	
	//	
	//	//학원명조건으로 출력
	//	public ClassDTO[] selectInsByName(String ins_name) throws SQLException {
	//		ClassDTO[] arr = null ;
	//		
	//		try {
	//			pstmt = conn.prepareStatement(D.SQL_INS_WHERE_NAME);
	//			pstmt.setString(1, ins_name);
	//			rs = pstmt.executeQuery();
	//			arr = createCurArray(rs);
	//		} catch (SQLException e) {
	//			e.printStackTrace();
	//		} finally {
	//			close();
	//		}
	//		
	//		return arr;
	//	}
	//	
	//	//학원과정으로 검색
	//	public ClassDTO[] selectInsByCurName(int ins_uid) throws SQLException {
	//		ClassDTO[] arr = null ;
	//		
	//		try {
	//			pstmt = conn.prepareStatement(D.SQL_INS_WHERE_CUR_NAME);
	//			pstmt.setInt(1, ins_uid);
	//			rs = pstmt.executeQuery();
	//			arr = createCurArray(rs);
	//		} catch (SQLException e) {
	//			e.printStackTrace();
	//		} finally {
	//			close();
	//		}
	//		
	//		return arr;
	//	}

	// 관리자페이지 학원검색 전체 + 조건
	public ClassDTO[] selectCurList(int option_review, String keyword) throws SQLException {


		ClassDTO [] arr = null;
		String selectIns = D.SQL_SELECT_INS;

		// 학원 검색 조건 (1)학원UID  (2)학원명   (3)과정명

		switch(option_review) {
		case 1: 
			selectIns += D.SQL_INS_WHERE_UID;
			break;
		case 2:
			selectIns += D.SQL_INS_WHERE_NAME;
			break;
		case 3:
			selectIns += D.SQL_INS_WHERE_CUR_NAME;
			break;
		default:
			break;
		}


		// 정렬
		selectIns += D.SQL_SELECT_INS_ORDER_BY_UID;

		try {
			// keyword가 있을 경우 쿼리문에 키워드 넘겨주기
			if(keyword != null && !keyword.equals("")) {
				pstmt = conn.prepareStatement(selectIns);
				pstmt.setString(1, keyword);
			}else { 
				pstmt = conn.prepareStatement(selectIns);
			}

			rs = pstmt.executeQuery();
			arr = createCurArray(rs);
		} finally {
			close();
		}		

		return arr;
	}
	
	// 관리자페이지 학원등록
	// 1.
	public int insertIns(ClassDTO dto) throws SQLException {
		String ins_name = dto.getIns_name();
		String ins_tel = dto.getIns_tel();
		int ins_zip = dto.getIns_zip();
		String ins_add1 = dto.getIns_add1();
		String ins_add2 = dto.getIns_add2();
		String ins_location = dto.getIns_location();
		String ins_branch = dto.getIns_branch();
		String ins_img = dto.getIns_img();
		return this.insertIns(ins_name, ins_zip, ins_add1, ins_add2, ins_tel, ins_img, ins_branch, ins_location);
	}
	
	// 1-1.
	public int insertIns(String ins_name, int ins_zip, String ins_add1, String ins_add2, String ins_tel, String ins_img,
			String ins_branch, String ins_location) throws SQLException{

		int cnt = 0;
		
		try {
			pstmt = conn.prepareStatement(D.SQL_INSERT_REVIEW);
			pstmt.setString(1, ins_name);
			pstmt.setInt(2, ins_zip);
			pstmt.setString(3, ins_add1);
			pstmt.setString(4, ins_add2);
			pstmt.setString(5, ins_tel);
			pstmt.setString(6, ins_img);
			pstmt.setString(7, ins_branch);
			pstmt.setString(8, ins_location);
			cnt = pstmt.executeUpdate();
		} finally {
			close();
		}
		
		return cnt;
	}
	
	// 관리자페이지 학원 수정
	public int updateInsByUid(String ins_name, String ins_tel, int ins_zip, String ins_add1, String ins_add2,
			String ins_location, String ins_branch, String ins_img, int ins_uid) throws SQLException{
		int cnt = 0;
		
		try {
			pstmt = conn.prepareStatement(D.SQL_UPDATE_INS);
			pstmt.setString(1, ins_name);
			pstmt.setString(2, ins_tel);
			pstmt.setInt(3, ins_zip);
			pstmt.setString(4, ins_add1);
			pstmt.setString(5, ins_add1);
			pstmt.setString(6, ins_location);
			pstmt.setString(7, ins_branch);
			pstmt.setString(8, ins_img);
			pstmt.setInt(9, ins_uid);
			cnt = pstmt.executeUpdate();
			
		} finally {
			close();
		}
		
		return cnt;
	}
	
	// 학원 이미지 삭제
	public int deleteInsImgByUid(String ins_img, int ins_uid) throws SQLException{
		int cnt = 0;
		
		try {
			pstmt = conn.prepareStatement(D.SQL_DELETE_INS_IMG);
			pstmt.setString(1, ins_img);
			pstmt.setInt(2, ins_uid);
			cnt = pstmt.executeUpdate();
			
		} finally {
			close();
		}
		
		return cnt;
	}
	
	public int deleteInsByUid(int ins_uid) throws SQLException{
		int cnt = 0;
		
		try {
			pstmt = conn.prepareStatement(D.SQL_DELETE_INS);
			pstmt.setInt(1, ins_uid);
			cnt = pstmt.executeUpdate();
			
		} finally {
			close();
		}
		
		return cnt;
	}
	
}
