package command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.beans.AdminMbDAO;
import com.lec.beans.MbDTO;

public class AdminMemberOkCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String mb_pw = request.getParameter("mb_pw");
		String mb_img = request.getParameter("mb_img");
		int mb_level = Integer.parseInt(request.getParameter("mb_level"));
		String mb_email = request.getParameter("mb_email");
		int mb_zip = Integer.parseInt(request.getParameter("mb_zip"));
		String mb_add1 = request.getParameter("mb_add1");
		String mb_add2 = request.getParameter("mb_add2");
		int mb_uid = Integer.parseInt(request.getParameter("mb_uid"));
		
		AdminMbDAO dao = new AdminMbDAO();
		int cnt = 0;
		
		if (mb_uid > 0) {
			try {
				cnt = dao.updateMbByUid(mb_pw, mb_img, mb_level, mb_email, mb_zip, mb_add1, mb_add2, mb_uid);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		request.setAttribute("adminMemberOk", cnt);
	}

}