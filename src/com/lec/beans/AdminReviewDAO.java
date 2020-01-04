package com.lec.beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import common.D;

public class AdminReviewDAO {

	Connection conn;
	PreparedStatement pstmt;
	Statement stmt;
	ResultSet rs;
	
	
	
	public AdminReviewDAO() {
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
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
		if(stmt != null) stmt.close();
		if(conn != null) conn.close();
	}
	
	
	
	
	
	// ResultSet --> DTO 배열로 변환 리턴
	public ReviewDTO [] createReviewArray(ResultSet rs) throws SQLException {
		
		int cnt = 0;
		ArrayList<ReviewDTO> list = new ArrayList<ReviewDTO>();
		
		while(rs.next()){
			
			int review_brd_uid = rs.getInt("review_brd_uid");
			String ins_name = rs.getString("ins_name");
			String review_brd_title = rs.getString("review_brd_title");
			String mb_id = rs.getString("mb_id");
			String review_brd_regdate = rs.getString("review_brd_regdate");
			int review_brd_viewcnt = rs.getInt("review_brd_viewcnt");
			
			ReviewDTO dto = new ReviewDTO();
			list.add(dto);			
		}
		
		int size = list.size();
		ReviewDTO [] arr = new ReviewDTO[size];
		list.toArray(arr);
		return arr;
	}
	
	
	
	
	
	// 리뷰 목록
	public ReviewDTO[] selectReviewList() throws SQLException {
		
		ReviewDTO [] arr = null;
		
		try {			
			pstmt = conn.prepareStatement(D.SQL_SELECT_REVIEW);
			rs = pstmt.executeQuery();
			arr = createReviewArray(rs);
		} finally {
			close();
		}		
		
		return arr;
	}
	
	
	
	
	
	
	public int deleteReview(int review_uid) throws SQLException {
		
		int cnt = 0;
		
		
		
		return cnt;
	}
	
	
	
	
	
}
