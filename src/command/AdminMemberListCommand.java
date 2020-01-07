package command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.beans.AdminMbDAO;
import com.lec.beans.MbDTO;

public class AdminMemberListCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int option_mb_1 = Integer.parseInt(request.getParameter("option_mb_1"));
		int option_mb_2 = Integer.parseInt(request.getParameter("option_mb_2"));
		String option_mb_3 = request.getParameter("option_mb_3");

		AdminMbDAO dao = new AdminMbDAO();
		MbDTO [] arr = null;
		
		if (option_mb_1 > 0 
		&& option_mb_2 > 0 
		&& option_mb_3.length() > 0 && !option_mb_3.trim().equals("") && option_mb_3 != null) {
			try {
				arr = dao.selectMb(option_mb_1, option_mb_2, option_mb_3);
				request.setAttribute("adminMemberList", arr);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
