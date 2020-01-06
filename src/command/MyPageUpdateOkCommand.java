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
		String mb_email = request.getParameter("mb_pw");
		int mb_zip = Integer.parseInt(request.getParameter("mb_zip"));
		String mb_add1 = request.getParameter("mb_pw");
		String mb_add2 = request.getParameter("mb_pw");
		int mb_uid = Integer.parseInt(request.getParameter("mb_uid"));
		
		try {
			cnt = dao.update(mb_pw, mb_email, mb_zip, mb_add1, mb_add2, mb_uid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("myPageUpdateOk", cnt);
	}

}
