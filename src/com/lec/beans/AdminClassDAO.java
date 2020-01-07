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

	
	//관리자  AdminInsView 배열 생성
	public ClassDTO[] createInsArray(ResultSet rs) throws SQLException {

		ArrayList<ClassDTO> list = new ArrayList<ClassDTO>();

		while (rs.next()) {

			String ins_name = rs.getString("ins_name");
			String ins_add1 = rs.getString("ins_add1");
			String ins_add2 = rs.getString("ins_add2");
			int ins_zip = rs.getInt("ins_zip");
			String ins_tel = rs.getString("ins_tel");
			String ins_location = rs.getString("ins_location");
			String ins_branch = rs.getString("ins_branch");
			String ins_img = rs.getString("ins_img");
			ClassDTO dto = new ClassDTO( ins_name,  ins_zip,  ins_add1,  ins_add2,  ins_tel,  ins_img, ins_branch,  ins_location);
			list.add(dto);
		}

		int size = list.size();
		ClassDTO[] arr = new ClassDTO[size];
		list.toArray(arr);
		
		return arr;
	}
	
	//관리자페이지 학원 수정할 경우 화면에 띄워주기
	public ClassDTO[] insView() throws SQLException {
		
		ClassDTO [] insArr = null ;
		
		try {
			
			pstmt = conn.prepareStatement(D.SQL_SELECT_INS);
			rs = pstmt.executeQuery();
			insArr = createInsArray(rs);
			
		} finally {
			close();
		}
		
		
		return insArr;
		
		
	}
	
	
	
	
	// 관리자페이지 학원검색 전체 + 조건

	public ClassDTO[] selectInsList(int option_ins, String keyword) throws SQLException {

		ClassDTO [] arr = null;
		String selectIns = D.SQL_SELECT_INS;

		// 학원 검색 조건 (1)학원UID  (2)학원명   (3)과정명

		switch(option_ins) {
		case 1: 
			selectIns += D.SQL_INS_WHERE_UID;
			break;
		case 2:
			selectIns += D.SQL_INS_WHERE_NAME;
			break;
		case 3:
			selectIns += D.SQL_INS_WHERE_CUR_NAME;
			break;
		case 4:
			selectIns = D.SQL_SELECT_INS;
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
	public int insertIns(String ins_name, int ins_zip, String ins_add1, String ins_add2, String ins_tel, String ins_img,
			String ins_branch, String ins_location, double ins_x, double ins_y) throws SQLException{

		int cnt = 0;
		
		try {
			pstmt = conn.prepareStatement(D.SQL_INSERT_INS);
			pstmt.setString(1, ins_name);
			pstmt.setInt(2, ins_zip);
			pstmt.setString(3, ins_add1);
			pstmt.setString(4, ins_add2);
			pstmt.setString(5, ins_tel);
			pstmt.setString(6, ins_img);
			pstmt.setString(7, ins_branch);
			pstmt.setString(8, ins_location);
			pstmt.setDouble(9, ins_x);
			pstmt.setDouble(10, ins_y);
			
			cnt = pstmt.executeUpdate();
	
			
		} finally {
			close();
		}
		
		return cnt;
	}
	
	
	
	// 수정할 학원정보 불러오기
	public ClassDTO[] selectInsByUid(int ins_uid) throws SQLException{

		ClassDTO [] arr = null;
		
		try {
			pstmt = conn.prepareStatement(D.SQL_SELECT_INS_BY_UID_FOR_UPDATE);
			pstmt.setInt(1, ins_uid);
			
			rs = pstmt.executeQuery();
			
			arr = createCurArray(rs);
			
		} finally {
			close();
		}
		
		return arr;
	}

	// 관리자페이지 학원 수정
	public int updateInsByUid(String ins_name, String ins_tel, int ins_zip, String ins_add1, String ins_add2,
			String ins_location, String ins_branch, String ins_img, int ins_uid, double ins_x, double ins_y) throws SQLException{
		
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
			pstmt.setDouble(10, ins_x);
			pstmt.setDouble(11, ins_y);
			
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
	
	
	
	
	
	// 학원 과정 관리 
	// 1. 과정 추가 

	public int insertCur(int ins_uid, String cur_name, int cur_hours, int cur_months, String cur_month1, String cur_month2, String cur_month3, 
			String cur_month4, String cur_month5, String cur_month6) throws SQLException{
		
		int cnt = 0;
		int cur_uid = 0;
		
		try {
			
			String [] generetedCols = {"cur_uid"};
			
			pstmt = conn.prepareStatement(D.SQL_INSERT_CUR, generetedCols);   
			pstmt.setString(1, cur_name);
			pstmt.setInt(2, cur_hours);
			pstmt.setInt(3, cur_months);
			pstmt.setString(4, cur_month1);
			pstmt.setString(5, cur_month2);
			pstmt.setString(6, cur_month3);
			pstmt.setString(7, cur_month4);
			pstmt.setString(8, cur_month5);
			pstmt.setString(9, cur_month6);
					
			cnt = pstmt.executeUpdate();
			
			// auto-generated keys 값 뽑아오기
			rs = pstmt.getGeneratedKeys();
			if(rs.next()) {
				cur_uid = rs.getInt(1);
			}
			
			pstmt.close();
			
			// 클래스에 저장하기
			pstmt = conn.prepareStatement(D.SQL_INSERT_CLASS);
				pstmt.setInt(1, ins_uid);
				pstmt.setInt(2, cur_uid);
				pstmt.executeUpdate();
	
		} finally {
			close();
		}
		return cnt;
	}
	
	

	// 2. 과정 수정
	
	
	public ClassDTO[] createClassArrayByUid(ResultSet rs) throws SQLException {

		ArrayList<ClassDTO> list = new ArrayList<ClassDTO>();

		while (rs.next()) {
			String cur_name = rs.getString("cur_name");
			int cur_hours = rs.getInt("cur_hours");
			int cur_months = rs.getInt("cur_months");
			String cur_month1 = rs.getString("cur_month1");
			String cur_month2 = rs.getString("cur_month2");
			String cur_month3 = rs.getString("cur_month3");
			String cur_month4 = rs.getString("cur_month4");
			String cur_month5 = rs.getString("cur_month5");
			String cur_month6 = rs.getString("cur_month6");
			String ins_name = rs.getString("ins_name");
			String ins_tel = rs.getString("ins_tel");
			String ins_img = rs.getString("ins_img");
			
			ClassDTO dto = new ClassDTO( cur_name,  cur_hours,  cur_months,  cur_month1,  cur_month2,
					 cur_month3,  cur_month4,  cur_month5,  cur_month6,  ins_name,  ins_tel,  ins_img);
			list.add(dto);
		}

		int size = list.size();
		ClassDTO[] arr = new ClassDTO[size];
		list.toArray(arr);
		return arr;
	}

	
	// 특정학원의 수정할 class정보 불러오기
	public ClassDTO[] selectClassByUid(int ins_uid) throws SQLException {
		ClassDTO[] arr = null ;
		
		try {
			pstmt = conn.prepareStatement(D.SQL_SELECT_CLASS_BY_INS_UID);
			pstmt.setInt(1, ins_uid);
			rs = pstmt.executeQuery();
			arr = createClassArrayByUid(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return arr;
	}

	


	// 클래스 정보 수정
	public int updateClass(int cur_uid, String cur_name, int cur_hours, int cur_months, String cur_month1, String cur_month2, String cur_month3, 
			String cur_month4, String cur_month5, String cur_month6) throws SQLException{ // 선택된 클래스가 가지고 있는 cur_uid를 인자로 줄것
		
		int cnt = 0;
		
		try {
			
			pstmt = conn.prepareStatement(D.SQL_UPDATE_CUR);
			pstmt.setString(1, cur_name);
			pstmt.setInt(2, cur_hours);
			pstmt.setInt(3, cur_months);
			pstmt.setString(4, cur_month1);
			pstmt.setString(5, cur_month2);
			pstmt.setString(6, cur_month3);
			pstmt.setString(7, cur_month4);
			pstmt.setString(8, cur_month5);
			pstmt.setString(9, cur_month6);
			pstmt.setInt(9, cur_uid);
			
			cnt = pstmt.executeUpdate();

			
		} finally {
			close();
		}
		
		return cnt; 
		
	}
	
	
	
	// 3. 과정 삭제
	public int deleteClassByUid(int class_uid) throws SQLException{
		
		int cnt = 0;
		
		try {
			
			pstmt = conn.prepareStatement(D.SQL_DELETE_CLASS);
			pstmt.setInt(1, class_uid);
		
			cnt = pstmt.executeUpdate();
			pstmt.close();

			
		} finally {
			close();
		}
		
		
		return cnt; 
		
	}
	
	
}
