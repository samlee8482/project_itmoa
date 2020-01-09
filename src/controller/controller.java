package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.AdminClassDeleteOkCommand;
import command.AdminCurListCommand;
import command.AdminCurOkCommand;
import command.AdminCurViewCommand;
import command.AdminInsDeleteOkCommand;
import command.AdminInsListCommand;
import command.AdminInsOkCommand;
import command.AdminInsViewCommand;
import command.AdminMemberListCommand;
import command.AdminMemberOkCommand;
import command.AdminMemberViewCommand;
import command.AdminNewsDeleteOkCommand;
import command.AdminNewsFileUploadCommand;
import command.AdminNewsListCommand;
import command.AdminNewsUpdateOkCommand;
import command.AdminNewsViewCommand;
import command.AdminReviewDeleteOkCommand;
import command.AdminReviewListCommand;
import command.Command;
import command.CurListCommand;
import command.CurViewCommand;
import command.FindIdViewCommand;
import command.FindPwViewCommand;
import command.JoinOkCommand;
import command.LoginOkCommand;
import command.MyPageCommand;
import command.MyPageUpdateOkCommand;
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

@WebServlet("*.do")
public class controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public controller() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}
	
	protected void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("actionDo 호출");
		
		request.setCharacterEncoding("UTF-8");
		
		Command command = null;
		String viewPage = null;
		
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String com = uri.substring(conPath.length());
		
		System.out.println(uri + "\n" + conPath + "\n" + com);
		
		switch (com) {
		
//		사용자
//		- 메인페이지
		case "/index.do":  // 메인페이지
			viewPage = "index.jsp";
			break;

//		- 로그인
		case "/login.do":  // 로그인 페이지
			viewPage = "login.jsp";
			break;
		case "/loginOk.do":  // 로그인 (체크)
			command = new LoginOkCommand();
			command.execute(request, response);
			viewPage = "loginOk.jsp";
			break;

//		- 회원가입
		case "/join.do":  // 회원가입 페이지
			viewPage = "join.jsp";
			break;
		case "/joinOK.do":  // 회원가입 (체크)
			command = new JoinOkCommand();
			command.execute(request, response);
			viewPage = "joinOk.jsp";
			break;
	
//		- 아이디 찾기
		case "/find.do":  // 아이디 찾기 페이지
			viewPage = "find.jsp";
			break;
		case "/findIdView.do":  // 아이디 찾기 (체크) 및 아이디 출력
			command = new FindIdViewCommand();
			command.execute(request, response);
			viewPage = "findIdOk.jsp";
			break;
		
//		- 비밀번호 찾기
		case "/findPw.do":  // 비밀번호 찾기 페이지
			viewPage = "findPw.jsp";
			break;
		case "/findPwView.do":  // 비밀번호 찾기 (체크) 및 이메일로 발송
			command = new FindPwViewCommand();
			command.execute(request, response);
			viewPage = "findPwOk.jsp";
			break;

//		- 마이페이지
		case "/myPage.do":  // 마이페이지 출력
			command = new MyPageCommand();
			command.execute(request, response);
			viewPage = "myPage.jsp";
			break;
		case "/myPageUpdateOk.do":  // 마이페이지 수정 (체크)
			command = new MyPageUpdateOkCommand();
			command.execute(request, response);
			viewPage = "myPageUpdateOk.jsp";
			break;
			
//		- 학원
		case "/curList.do":  // 학원 리스트 출력
			command = new CurListCommand();
			command.execute(request, response);
			
			viewPage = "curList.jsp";
			break;
//		검색 조건 추가는 curList.do 뒤에 쿼리 추가해서 다시 request
		case "/curView.do":  // 학원 상세페이지 출력
			command = new CurViewCommand();
			command.execute(request, response);
			viewPage = "curView.jsp";
			break;
//		* 찜 삭제는 커맨드에서 if문으로 거르기
		case "/zzimOk.do":  // 찜 추가
			command = new ZZimOkCommand();
			command.execute(request, response);
			viewPage = "zzimOk.jsp";
			break;
		case "/reserveOk.do":  // 상담 예약 (mb_level = 2)
			command = new ReserveOkCommand();
			command.execute(request, response);
			viewPage = "reserveOk.jsp";
			break;
			
//		- 리뷰
		case "/user/reviewList.do":  // 리뷰 리스트 출력 (댓글도)
			command = new ReviewListCommand();
			command.execute(request, response);
			viewPage = "reviewList.jsp";
			break;
		case "/user/reviewView.do":  // 리뷰 상세페이지 출력
			command = new ReviewViewCommand();
			command.execute(request, response);
			viewPage = "reviewView.jsp";
			break;
		case "/reviewWrite.do":  // 리뷰 작성 페이지 이동
			viewPage = "reviewWrite.jsp";
			break;
		case "/reviewWriteOk.do":  // 리뷰 작성 (체크)
			command = new ReviewWriteOkCommand();
			command.execute(request, response);
			viewPage = "reviewWriteOk.jsp";
			break;
		case "/reviewUpdateView.do":  // 리뷰 수정 페이지 이동
			command = new ReviewUpdateViewCommand();
			command.execute(request, response);
			viewPage = "reviewUpdateView.jsp";
			break;
		case "/reviewUpdateOk.do":  // 리뷰 수정 (체크)
			command = new ReviewUpdateOkCommand();
			command.execute(request, response);
			viewPage = "reviewUpdateOk.jsp";
			break;
		case "/reviewDeleteOk.do":  // 리뷰 삭제 (체크)
			command = new ReviewDeleteOkCommand();
			command.execute(request, response);
			viewPage = "reviewDeleteOk.jsp";
			break;

//		- 댓글
// 		* 댓글 불러오기는 jQuery .click() 함수로 대체
		case "/repWriteOk.do":  // 댓글 작성 (체크)
			command = new RepWriteOkCommand();
			command.execute(request, response);
			viewPage = "repDeleteOk.jsp";
		case "/repUpdateOk.do":  // 댓글 수정 (체크)
			command = new RepUpdateOkCommand();
			command.execute(request, response);
			viewPage = "repDeleteOk.jsp";
			break;
		case "/repDeleteOk.do":  // 댓글 삭제 (체크)
			command = new RepDeleteOkCommand();
			command.execute(request, response);
			viewPage = "repDeleteOk.jsp";
			break;

//		- 뉴스
		case "/user/newsList.do":  // 뉴스 리스트 출력
			command = new NewsListCommand();
			command.execute(request, response);
			viewPage = "newsList.jsp";
			break;
		case "/user/newsView.do":  // 뉴스 상세페이지 출력
			command = new NewsViewCommand();
			command.execute(request, response);
			viewPage = "newsView.jsp";
			break;
			
//		관리자
//		- 회원관리
		case "/adminMemberList.do":  // 관리자 회원 리스트 출력
			command = new AdminMemberListCommand();
			viewPage = "adminMemberList.jsp";
			break;
//		* 검색 조건 추가는 adminMemberList.do 뒤에 쿼리 추가해서 다시 request
		case "/adminMemberView.do":  // 관리자 회원 상세 정보 출력
			command = new AdminMemberViewCommand();
			command.execute(request, response);
			viewPage = "adminMemberView.jsp";
			break;
		case "/adminMemberOk.do":  // 관리자 회원 상세 정보 수정 (체크)
			command = new AdminMemberOkCommand();
			command.execute(request, response);
			viewPage = "adminMemberOk.jsp";
			break;
		
//		- 학원관리
		case "/adminInsList.do":  // 관리자 학원 리스트 출력. 관리자페이지 초기화면
			command = new AdminInsListCommand();
			command.execute(request, response);
			viewPage = "adminInsList.jsp";
			break;
//		* 검색 조건 추가는 adminInsList.do 뒤에 쿼리 추가해서 다시 request
		case "/adminInsView.do":  // 관리자 학원 상세 정보 출력. 학원 수정할 때
			command = new AdminInsViewCommand();
			command.execute(request, response);
			viewPage = "adminInsView.jsp";
			break;
		case "/adminInsDeleteOk.do":  // 관리자 학원 삭제
			command = new AdminInsDeleteOkCommand();
			command.execute(request, response);
			viewPage = "adminInsDeleteOk.jsp";
			break;
		case "/adminInsOk.do":  // 관리자 학원 상세 정보 수정 (체크)
			command = new AdminInsOkCommand();
			command.execute(request, response);
			viewPage = "adminInsOk.jsp";
			break;
//		* insert 같이 사용
		case "/adminClassList.do":  // 관리자 Class 출력. 과정 관리 화면
			command = new AdminCurListCommand();
			command.execute(request, response);
			viewPage = "adminClassList.jsp";
			break;
		case "/adminCurView.do":  // 관리자 Cur 출력. 과정 수정할 때
			command = new AdminCurViewCommand();
			command.execute(request, response);
			viewPage = "adminCurView.jsp";
			break;
		case "/adminCurOk.do":  // 관리자 Cur 추가
			command = new AdminCurOkCommand();
			command.execute(request, response);
			viewPage = "adminCurOk.jsp";
			break;
		case "/adminClassDeleteOk.do":  // 관리자 Class 삭제
			command = new AdminClassDeleteOkCommand();
			command.execute(request, response);
			viewPage = "adminClassDeleteOk.jsp";
			break;
			
//		- 리뷰관리
		case "/admin/adminReviewList.do":  // 관리자 리뷰 리스트 출력
			command = new AdminReviewListCommand();
			command.execute(request, response);
			viewPage = "adminReviewList.jsp";
			break;
//		* 검색 조건 추가는 adminReviewList.do 뒤에 쿼리 추가해서 다시 request
		case "/admin/adminReviewDeleteOk.do":  // 관리자 리뷰 삭제 (체크)
			command = new AdminReviewDeleteOkCommand();
			command.execute(request, response);
			viewPage = "adminReviewDeleteOk.jsp";
			break;
				
//		- IT뉴스 관리
		case "/admin/adminNewsList.do":  // 관리자 뉴스 리스트 출력
			command = new AdminNewsListCommand();
			command.execute(request, response);
			viewPage = "adminNewsList.jsp";
			break;
//		* 검색 조건 추가는 adminNewsList.do 뒤에 쿼리 추가해서 다시 request
		case "/admin/adminNewsView.do":  // 관리자 뉴스 상세 내용 출력
			command = new AdminNewsViewCommand();
			command.execute(request, response);
			viewPage = "adminNewsView.jsp";
			break;
		case "/admin/adminNewsWrite.do":  // 관리자 뉴스 상세 내용 수정 (체크)
			viewPage = "adminNewsWrite.jsp";
			break;
		case "/admin/adminNewsUpdateView.do":  // 관리자 뉴스 상세 내용 수정 (체크)
			command = new AdminNewsViewCommand();
			command.execute(request, response);
			viewPage = "adminNewsUpdateView.jsp";
			break;
		case "/admin/adminNewsUpdateOk.do":  // 관리자 뉴스 상세 내용 수정 (체크)
			command = new AdminNewsUpdateOkCommand();
			command.execute(request, response);
			viewPage = "adminNewsUpdateOk.jsp";
			break;
//		* insert도 같이 사용
		case "/admin/adminNewsDeleteOk.do":  // 관리자 뉴스 상세 내용 수정 (체크)
			command = new AdminNewsDeleteOkCommand();
			command.execute(request, response);
			viewPage = "adminNewsDeleteOk.jsp";
			break;
		case "/admin/adminNewsFileUplaod.do":
			command = new AdminNewsFileUploadCommand();
			command.execute(request, response);
			break;
		}
		
		if (viewPage != null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
			dispatcher.forward(request, response);
		}
	}
}