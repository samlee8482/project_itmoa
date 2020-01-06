package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Command;
import command.CurListCommand;
import command.CurViewCommand;
import command.FindAccountOkCommand;
import command.LoginCommand;
import command.LoginOkCommand;
import command.MyPageCommand;
import command.MyPageOkCommand;
import command.NewViewCommand;
import command.NewsListCommand;
import command.RegistOkCommand;
import command.RepDeleteOkCommand;
import command.RepUpdateOkCommand;
import command.ReserveOkCommand;
import command.ReviewDeleteOkCommand;
import command.ReviewListCommand;
import command.ReviewUpdateCommand;
import command.ReviewUpdateOkCommand;
import command.ReviewViewCommand;
import command.ReviewWriteOkCommand;
import command.ZZimCommand;

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
			command = new RegistOkCommand();
			command.execute(request, response);
			viewPage = "joinOk.jsp";
			break;
	
//		- 아이디 찾기
		case "/findIdOk.do":
			command = new FindAccountOkCommand();
			command.execute(request, response);
			viewPage = "AccountOk.jsp";
			break;
		
//		- 비밀번호 찾기
		case "/findPwOk.do":
			command = new LoginOkCommand();
			command.execute(request, response);
			viewPage = "login.jsp";
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
			viewPage = "myPageok.jsp";
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
			viewPage = "curInfo.jsp";
			break;
//		* 찜 삭제는 커맨드에서 if문으로 거르기
		case "/zzimOk.do":
			command = new ZZimCommand();
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
		case "/reviewUpdate.do":
			command = new ReviewUpdateCommand();
			command.execute(request, response);
			viewPage = "reviewUpdate.jsp";
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
			command = new NewViewCommand();
			command.execute(request, response);
			viewPage = "newInfo.jsp";
			break;
			
//		관리자
		case "/login.do":
			command = new LoginCommand();
			command.execute(request, response);
			viewPage = "login.jsp";
			break;
		}
		
	}
}