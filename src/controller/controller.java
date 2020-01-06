package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.AdminClassDeleteOkCommand;
import command.AdminCurListCommand;
import command.AdminCurOkCommand;
import command.AdminCurViewCommand;
import command.AdminITNewsListCommand;
import command.AdminITNewsUpdateOkCommand;
import command.AdminITNewsViewCommand;
import command.AdminInsListCommand;
import command.AdminInsOkCommand;
import command.AdminInsViewCommand;
import command.AdminMemberListCommand;
import command.AdminMemberOkCommand;
import command.AdminMemberViewCommand;
import command.AdminReviewDeleteOkCommand;
import command.AdminReviewListCommand;
import command.Command;
import command.CurListCommand;
import command.CurViewCommand;
import command.FindIdOkCommand;
import command.FindPwOkCommand;
import command.JoinOkCommand;
import command.LoginOkCommand;
import command.MyPageCommand;
import command.MyPageOkCommand;
import command.NewsListCommand;
import command.NewsViewCommand;
import command.RepDeleteOkCommand;
import command.RepUpdateOkCommand;
import command.RepWriteOkCommand;
import command.ReserveOkCommand;
import command.ReviewDeleteOkCommand;
import command.ReviewListCommand;
import command.ReviewUpdateOkCommand;
import command.ReviewUpdateViewCommand;
import command.ReviewViewCommand;
import command.ReviewWriteOkCommand;
import command.ZZimOkCommand;

public class controller {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}

	protected void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("actionDo() 호출");
		
		request.setCharacterEncoding("UTF-8");
		
		String viewPage = null;
		Command command = null;
		
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String com = uri.substring(conPath.length());
		
		switch (com) {
		
//		사용자
//		- 메인페이지
		case "/index.do":
			viewPage = "index.jsp";
			break;

//		- 로그인
		case "/loginOk.do":
			command = new LoginOkCommand();
			command.execute(request, response);
			viewPage = "loginOk.jsp";
			break;

//		- 회원가입
		case "/joinOk.do":
			command = new JoinOkCommand();
			command.execute(request, response);
			viewPage = "joinOk.jsp";
			break;
	
//		- 아이디 찾기
		case "/findIdOk.do":
			command = new FindIdOkCommand();
			command.execute(request, response);
			viewPage = "findIdOk.jsp";
			break;
		
//		- 비밀번호 찾기
		case "/findPwOk.do":
			command = new FindPwOkCommand();
			command.execute(request, response);
			viewPage = "findPwOk.jsp";
			break;

//		- 마이페이지
		case "/myPage.do":
			command = new MyPageCommand();
			command.execute(request, response);
			viewPage = "myPage.jsp";
			break;
		case "/myPageOk.do":
			command = new MyPageOkCommand();
			command.execute(request, response);
			viewPage = "myPageOk.jsp";
			break;
			
//		- 학원
		case "/curList.do":
			command = new CurListCommand();
			command.execute(request, response);
			viewPage = "curList.jsp";
			break;
		case "/curView.do":
			command = new CurViewCommand();
			command.execute(request, response);
			viewPage = "curView.jsp";
			break;
//		* 찜 삭제는 커맨드에서 if문으로 거르기
		case "/zzimOk.do":
			command = new ZZimOkCommand();
			command.execute(request, response);
			viewPage = "zzimOk.jsp";
			break;
		case "/reserveOk.do":
			command = new ReserveOkCommand();
			command.execute(request, response);
			viewPage = "reserveOk.jsp";
			break;
			
//		- 리뷰
		case "/reviewList.do":
			command = new ReviewListCommand();
			command.execute(request, response);
			viewPage = "reviewList.jsp";
			break;
		case "/reviewView.do":
			command = new ReviewViewCommand();
			command.execute(request, response);
			viewPage = "reviewView.jsp";
			break;
		case "/reviewWriteOk.do":
			command = new ReviewWriteOkCommand();
			command.execute(request, response);
			viewPage = "reviewWriteOk.jsp";
			break;
		case "/reviewUpdateView.do":
			command = new ReviewUpdateViewCommand();
			command.execute(request, response);
			viewPage = "reviewUpdateView.jsp";
			break;
		case "/reviewUpdateOk.do":
			command = new ReviewUpdateOkCommand();
			command.execute(request, response);
			viewPage = "reviewUpdateOk.jsp";
			break;
		case "/reviewDeleteOk.do":
			command = new ReviewDeleteOkCommand();
			command.execute(request, response);
			viewPage = "reviewDeleteOk.jsp";
			break;

//		- 댓글
// 		* 댓글 불러오기는 jQuery .click() 함수로 대체
		case "/repWriteOk.do":
			command = new RepWriteOkCommand();
			command.execute(request, response);
			viewPage = "repDeleteOk.jsp";
		case "/repUpdateOk.do":
			command = new RepUpdateOkCommand();
			command.execute(request, response);
			viewPage = "repDeleteOk.jsp";
			break;
		case "/repDeleteOk.do":
			command = new RepDeleteOkCommand();
			command.execute(request, response);
			viewPage = "repDeleteOk.jsp";
			break;

//		- 뉴스
		case "/newsList.do":
			command = new NewsListCommand();
			command.execute(request, response);
			viewPage = "newsList.jsp";
			break;
		case "/newsView.do":
			command = new NewsViewCommand();
			command.execute(request, response);
			viewPage = "newsView.jsp";
			break;
			
//		관리자
//		- 회원관리
		case "/adminMemberList.do":
			command = new AdminMemberListCommand();
			command.execute(request, response);
			viewPage = "adminMemberList.jsp";
			break;
//		* 초반 검색도 같이 사용
		case "/adminMemberView.do":
			command = new AdminMemberViewCommand();
			command.execute(request, response);
			viewPage = "adminMemberView.jsp";
			break;
		case "/adminMemberOk.do":
			command = new AdminMemberOkCommand();
			command.execute(request, response);
			viewPage = "adminMemberOk.jsp";
			break;
		
//		- 학원관리
		case "/adminInsList.do":
			command = new AdminInsListCommand();
			command.execute(request, response);
			viewPage = "adminInsList.jsp";
			break;
//		* 초반 검색도 같이 사용
		case "/adminInsView.do":
			command = new AdminInsViewCommand();
			command.execute(request, response);
			viewPage = "adminInsView.jsp";
			break;
		case "/adminInsOk.do":
			command = new AdminInsOkCommand();
			command.execute(request, response);
			viewPage = "adminInsOk.jsp";
			break;
//		* insert 같이 사용
		case "/adminClassList.do":
			command = new AdminCurListCommand();
			command.execute(request, response);
			viewPage = "adminClassList.jsp";
			break;
		case "/adminCurView.do":
			command = new AdminCurViewCommand();
			command.execute(request, response);
			viewPage = "adminCurView.jsp";
			break;
		case "/adminCurOk.do":
			command = new AdminCurOkCommand();
			command.execute(request, response);
			viewPage = "adminCurOk.jsp";
			break;
		case "/adminClassDeleteOk.do":
			command = new AdminClassDeleteOkCommand();
			command.execute(request, response);
			viewPage = "adminClassDeleteOk.jsp";
			break;
			
//		- 리뷰관리
		case "/adminReviewList.do":
			command = new AdminReviewListCommand();
			command.execute(request, response);
			viewPage = "adminReviewList.jsp";
			break;
//		* 초반 검색도 같이 사용
		case "/adminReviewDeleteOk.do":
			command = new AdminReviewDeleteOkCommand();
			command.execute(request, response);
			viewPage = "adminReviewDeleteOk.jsp";
			break;
				
//		- IT뉴스 관리
		case "/adminITNewsList.do":
			command = new AdminITNewsListCommand();
			command.execute(request, response);
			viewPage = "adminITNewsList.jsp";
			break;
//		* 초반 검색도 같이 사용
		case "/adminITNewsView.do":
			command = new AdminITNewsViewCommand();
			command.execute(request, response);
			viewPage = "adminITNewsView.jsp";
			break;
		case "/adminITNewsUpdateOk.do":
			command = new AdminITNewsUpdateOkCommand();
			command.execute(request, response);
			viewPage = "adminITNewsUpdateOk.jsp";
			break;
//			* insert도 같이 사용
		}
		
	}
}