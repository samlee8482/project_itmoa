package command;

import java.sql.SQLException;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.beans.MbDAO;

public class JoinOkCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		MbDAO dao = new MbDAO();
		int cnt = 0;

		String mb_name = request.getParameter("mb_name");
		String mb_id = request.getParameter("mb_id");
		String mb_pw = request.getParameter("mb_pw");
		String mb_pwOk = request.getParameter("mb_pwOk");
		String mb_email = request.getParameter("mb_email");
		int mb_zip = Integer.parseInt(request.getParameter("mb_name"));
		String mb_add1 = request.getParameter("add1");
		String mb_add2 = request.getParameter("add2");

		String regex_email = "(\\w+\\.)*\\w+@(\\w+\\.)+[A-Za-z]+";
		String regex_id = "^[a-zA-Z]{1}[a-zA-Z0-9_]{6,20}$";
		String regex_pw = "^(?=.*\\\\d)(?=.*[~`!@#$%\\\\^&*()-])(?=.*[a-z])(?=.*[A-Z]).{8,20}$"; 
		// 아이디, 비번, 이메일 정규표현식 검사
		if(Pattern.matches(regex_email, mb_email) && Pattern.matches(regex_id, mb_id)
				&& Pattern.matches(regex_pw, mb_pw)) {
			try {
				cnt = dao.join(mb_name, mb_id, mb_pwOk, mb_email, mb_zip, mb_add1, mb_add2);
				if(cnt == 1) {
					request.setAttribute("joinOk", cnt);
				} else {
					System.out.println("회원가입 데이터 처리 실패");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("  Ⅹ매칭 없음Ⅹ cnt : " + cnt);
		}


	}

}
