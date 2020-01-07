package command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.beans.MbDAO;

public class MyPageUpdateOkCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int cnt = 0;
		
		MbDAO dao = new MbDAO();
		
		String mb_pw = request.getParameter("mb_pw");
		String mb_email = request.getParameter("mb_email");
		int mb_zip = Integer.parseInt(request.getParameter("mb_zip"));
		String mb_add1 = request.getParameter("mb_add1");
		String mb_add2 = request.getParameter("mb_add2");
		int mb_uid = Integer.parseInt(request.getParameter("mb_uid"));
		
		if (mb_pw != null && mb_pw.length() > 0 && !mb_pw.trim().equals("")
		&& mb_email != null && mb_email.length() > 0 && !mb_email.trim().equals("")
		&& mb_zip > 0
		&& mb_add1 != null && mb_add1.length() > 0 && !mb_add1.trim().equals("")
		&& mb_add2 != null && mb_add2.length() > 0 && !mb_add2.trim().equals("")
		&& mb_uid > 0) {
			try {
				cnt = dao.update(mb_pw, mb_email, mb_zip, mb_add1, mb_add2, mb_uid);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		request.setAttribute("myPageUpdateOk", cnt);
	}

}
