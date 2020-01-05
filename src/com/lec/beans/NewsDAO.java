package com.lec.beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import common.D;

public class NewsDAO {
	    
	Connection conn;
	PreparedStatement pstmt;
	Statement stmt;
	ResultSet rs;
	
	public NewsDAO() {
		try {
			Class.forName(D.DRIVER);
			conn = DriverManager.getConnection(D.URL, D.USERID, D.USERPW);
			System.out.println("NewsDAO() 객체 생성, 데이터베이스 연결");
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
	
	// 뉴스 검색 및 불러오기
	// 1-1.
	public NewsDTO [] createNewsArray(ResultSet rs) throws SQLException {
		ArrayList<NewsDTO> newsList = new ArrayList<NewsDTO>();
		
		while(rs.next()){
     
			int news_brd_uid = rs.getInt("news_brd_uid");
			String news_brd_title = rs.getString("news_brd_title");
			String news_brd_img = rs.getString("news_brd_img");
			int news_brd_viewcnt = rs.getInt("news_brd_viewcnt");
			
			NewsDTO dto = new NewsDTO(news_brd_uid, news_brd_title, news_brd_img, news_brd_viewcnt);
			newsList.add(dto);			
		}
		
		int size = newsList.size();
		NewsDTO [] arr = new NewsDTO[size];
		
		newsList.toArray(arr);
		
		return arr;
	}
	
	// 1-2.
	public NewsDTO[] selectNewsList(int option_news, String keyword) throws SQLException {
		
		NewsDTO [] arr = null;
		String selectNews = D.SQL_SELECT_NEWS_BRD;
		
		// 후기 검색 조건 (1)회원ID  (2)후기제목   (3)후기내용
		
		switch(option_news) {
			case 1: 
				selectNews += D.SQL_SELECT_NEWS_BRD_WHERE_UID;
				break;
			case 2:
				selectNews += D.SQL_SELECT_NEWS_BRD_WHERE_TITLE;
				break;
			case 3:
				selectNews += D.SQL_SELECT_NEWS_BRD_WHERE_CONTENT;
				break;
			default:
				break;
		}
		
		// 정렬
		selectNews += D.SQL_ORDER_BY_NEWS_BRD;
		
		try {
			// keyword가 있을 경우 쿼리문에 키워드 넘겨주기
			if(keyword != null && !keyword.equals("")) {
				pstmt = conn.prepareStatement(selectNews);
				pstmt.setString(1, keyword);
			}else { 
				pstmt = conn.prepareStatement(selectNews);
			}

			rs = pstmt.executeQuery();
			arr = createNewsArray(rs);
		} finally {
			close();
		}		
		
		return arr;
	}
	
}
