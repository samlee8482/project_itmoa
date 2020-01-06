package command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.beans.AdminMbDAO;
import com.lec.beans.MbDTO;
import com.lec.beans.NewsDTO;

public class AdminMemberViewCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		AdminMbDAO dao = new AdminMbDAO();
		MbDTO[] arr = null;
		
		int mb_uid = Integer.parseInt(request.getParameter("mb_uid"));
		
		try {
			arr = dao.selectMbByUid(mb_uid);
			request.setAttribute("admin_mb_view", arr);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
