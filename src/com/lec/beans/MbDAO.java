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
			System.out.println("MbDAO 객체 생성, 데이터베이스 연결");
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
	
	public MbDTO[] login(String mb_id, String mb_pw) throws SQLException {
		MbDTO[] arr = null;
		
		try {
			pstmt = conn.prepareStatement(D.SQL_SELECT_LOGIN);	// 검증 어떤식으로? 이미지는 마이페이지에서, 레벨은 게시글 쓸떄필요한게 아닌가?
			pstmt.setString(1, mb_id);
			pstmt.setString(2, mb_pw);
			rs = pstmt.executeQuery();
			arr = createLoginArr(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return arr; 
	}
	
//	public int loginCheck(String mb_id, String mb_pw) {
//		MbDTO[] arr = null;
//		
//		String dbPW = "";	// db 에서 꺼낸 비밀번호 담을 변수
//		int x = -1;
//		
//		//String SQL_SELECT_MB_PW_BY_ID = "SELECT mb_uid, mb_id, mb_pw, mb_level, mb_img FROM mb WHERE ID = ?";
//		
//		try {
//			pstmt = conn.prepareStatement(D.SQL_SELECT_LOGIN);
//			pstmt.setString(1, mb_id);
//			pstmt.setString(2, mb_pw);
//			rs = pstmt.executeQuery();
//			
//			if (rs.next()) // 입려된 아이디에 해당하는 비번 있을경우
//            {
//                dbPW = rs.getString("mb_pw"); // 비번을 변수에 넣는다.
// 
//                if (dbPW.equals(mb_pw)) 
//                    x = 1; // 넘겨받은 비번과 꺼내온 배번 비교. 같으면 인증성공
//                else                  
//                    x = 0; // DB의 비밀번호와 입력받은 비밀번호 다름, 인증실패
//                
//            } else {
//                x = -1; // 해당 아이디가 없을 경우
//            }
// 
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return x;
//	}
	
	// 회원가입
	public int join(String mb_name, String mb_id, String mb_pw, String mb_email, int mb_zip, String mb_add1, String mb_add2) throws SQLException {
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
			e.printStackTrace();
		} finally {
			close();
		}
		
		return cnt;
	}
	
	// 마이페이지
	// 1.
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
	
	// 2.
	public MbDTO[] myPage(int mb_uid) throws SQLException {
		MbDTO[] arr = null;
		
		try {
			pstmt = conn.prepareStatement(D.SQL_SELECT_LOGIN);
			pstmt.setInt(1, mb_uid);
			rs = pstmt.executeQuery();
			arr = createLoginArr(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return arr; 
	}
	
	// 회원정보 수정
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
	
	// 회원정보 찾기 - ID
	public int selectId(String mb_name, String mb_email) throws SQLException {
		int x = -1;
		
		String dbName = null;
		String dbEmail = null;
		
		try {
			pstmt = conn.prepareStatement(D.SQL_SELET_FIND_ACCOUNT_ID);
			pstmt.setString(1, mb_name);
			pstmt.setString(2, mb_email);
			rs = pstmt.executeQuery();
			
			if (rs.next()) // 입려된 아이디에 해당하는 비번 있을경우
            {
				dbName = rs.getString("mb_name"); // 비번을 변수에 넣는다.
                dbEmail = rs.getString("mb_email"); // 비번을 변수에 넣는다.
 
                if (dbName.equals(mb_name) && dbEmail.equals(mb_email)) 
                    x = 1; // 넘겨받은 비번과 꺼내온 배번 비교. 같으면 인증성공
                else                  
                    x = 0; // DB의 비밀번호와 입력받은 비밀번호 다름, 인증실패
                
            } else {
                x = -1; // 해당 아이디가 없을 경우
            }
 
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return x;
	}
	
	// 회원정보 찾기 - PW
	public int selectPw(String mb_id, String mb_name, String mb_email) throws SQLException {
		int x = -1;
		
		String dbId = null;
		String dbName = null;
		String dbEmail = null;
		
		try {
			pstmt = conn.prepareStatement(D.SQL_SELECT_FIND_ACCOUNT_PWD);
			pstmt.setString(1, mb_id);
			pstmt.setString(2, mb_name);
			pstmt.setString(3, mb_email);
			rs = pstmt.executeQuery();
			
			if (rs.next()) // 입려된 아이디에 해당하는 비번 있을경우
			{
				dbId = rs.getString("mb_id"); // 비번을 변수에 넣는다.
				dbName = rs.getString("mb_name"); // 비번을 변수에 넣는다.
				dbEmail = rs.getString("mb_email"); // 비번을 변수에 넣는다.
				
				if (dbId.equals(mb_id) && dbName.equals(mb_name) && dbEmail.equals(mb_email)) 
					x = 1; // 넘겨받은 비번과 꺼내온 배번 비교. 같으면 인증성공
				else                  
					x = 0; // DB의 비밀번호와 입력받은 비밀번호 다름, 인증실패
				
			} else {
				x = -1; // 해당 아이디가 없을 경우
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return x;
	}
	
}