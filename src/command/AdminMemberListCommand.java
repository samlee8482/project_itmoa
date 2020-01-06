package command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.beans.AdminMbDAO;
import com.lec.beans.MbDAO;
import com.lec.beans.MbDTO;

public class AdminMemberListCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int option_mb_1 = Integer.parseInt(request.getParameter("option_mb_1"));
		int option_mb_2 = Integer.parseInt(request.getParameter("option_mb_2"));
		String option_mb_3 = request.getParameter("option_mb_3");

		AdminMbDAO dao = new AdminMbDAO();
		MbDTO [] arr = null;
		
		try {
			arr = dao.selectMb(option_mb_1, option_mb_2, option_mb_3);
			request.setAttribute("adminMemberList", arr);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
