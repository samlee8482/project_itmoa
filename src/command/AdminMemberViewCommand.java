package command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.beans.AdminMbDAO;
import com.lec.beans.MbDTO;

public class AdminMemberViewCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		AdminMbDAO dao = new AdminMbDAO();
		MbDTO[] arr = null;
		
		int mb_uid = Integer.parseInt(request.getParameter("mb_uid"));
		     
		if (mb_uid > 0) {
			try {
				arr = dao.selectMbByUid(mb_uid);
				request.setAttribute("adminMemberView", arr);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
