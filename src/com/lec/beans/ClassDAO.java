package com.lec.beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import common.D;

public class ClassDAO {

	Connection conn;
	PreparedStatement pstmt;
	Statement stmt;
	ResultSet rs;

	public ClassDAO() {
		try {
			Class.forName(D.DRIVER);
			conn = DriverManager.getConnection(D.URL, D.USERID, D.USERPW);
			System.out.println("AdminReview 객체 생성, 데이터베이스 연결");
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

	public ClassDTO[] createCurArray(ResultSet rs) throws SQLException {

		ArrayList<ClassDTO> list = new ArrayList<ClassDTO>();

		while (rs.next()) {

			String ins_img = rs.getString("ins_img");
			int class_zzimcnt = rs.getInt("class_zzimcnt");
			String ins_name = rs.getString("ins_name");
			String cur_name = rs.getString("cur_name");

			ClassDTO dto = new ClassDTO(ins_name, cur_name, class_zzimcnt, ins_img);
			list.add(dto);
		}

		int size = list.size();
		ClassDTO[] arr = new ClassDTO[size];
		list.toArray(arr);
		return arr;
	}

	public ClassDTO[] selectCurList() throws SQLException {

		ClassDTO [] arr = null;
		String selectCur = D.SQL_SELECT_CLASS;

		// 정렬
		selectCur += D.SQL_ORDER_CLASS_UID;

		try {
			// keyword가 있을 경우 쿼리문에 키워드 넘겨주기
			pstmt = conn.prepareStatement(selectCur);
			rs = pstmt.executeQuery();
			arr = createCurArray(rs);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return arr;
	}

	
	public ClassDTO[] createBranchArray(ResultSet rs) throws SQLException {

		ArrayList<ClassDTO> list = new ArrayList<ClassDTO>();

		while (rs.next()) {

			String ins_img = rs.getString("ins_img");
			int class_zzimcnt = rs.getInt("class_zzimcnt");
			String ins_name = rs.getString("ins_name");
			String cur_name = rs.getString("cur_name");

			ClassDTO dto = new ClassDTO(ins_name, cur_name, class_zzimcnt, ins_img);
			list.add(dto);
		}

		int size = list.size();
		ClassDTO[] arr = new ClassDTO[size];
		list.toArray(arr);
		return arr;
	}

	public ClassDTO[] selectBranchList() throws SQLException {

		ClassDTO [] arr = null;
		String selectCur = D.SQL_SELECT_CLASS;

		// 정렬
		selectCur += D.SQL_ORDER_CLASS_UID;

		try {
			// keyword가 있을 경우 쿼리문에 키워드 넘겨주기
			pstmt = conn.prepareStatement(selectCur);
			rs = pstmt.executeQuery();
			arr = createCurArray(rs);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return arr;
	}


	public ClassDTO[] selectCurListByOption(int option_cur_1,int option_cur_2,int option_cur_3) throws SQLException {

		ClassDTO [] arr = null;
		String selectCur = D.SQL_SELECT_CLASS;
		selectCur +=  D.SQL_SELECT_CLASS_WHERE_INS_LOCATION;
		String locationTemp = "";
		String branchTemp = "";

		try {
			switch(option_cur_1) {
			case 1: 
				locationTemp = "서울";
				break;
			case 2:
				locationTemp = "경기";
				break;
			case 3:
				locationTemp = "인천";
				break;
			case 4:
				locationTemp = "대전";
				break;
			case 5:
				locationTemp = "대구";
				break;
			case 6:
				locationTemp = "부산";
				break;
			case 7:
				locationTemp = "광주";
				break;
			case 8:
				locationTemp = "울산";
				break;
			case 9:
				locationTemp = "기타";
				break;
			}
			
			

			// 정렬
			selectCur += D.SQL_ORDER_CLASS_UID;

			pstmt.setString(1, locationTemp);
			pstmt = conn.prepareStatement(selectCur);
			rs = pstmt.executeQuery();
			arr = createCurArray(rs);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return arr;
	}



}
