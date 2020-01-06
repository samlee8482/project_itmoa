package command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.beans.AdminNewsDAO;
import com.lec.beans.ClassDAO;
import com.lec.beans.MbDAO;
import com.lec.beans.ReviewDAO;

public class ReserveOkCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int mb_uid = Integer.parseInt(request.getParameter("mb_uid"));
		
		ClassDAO dao = new ClassDAO();
		int cnt = 0;
		
		try {
			cnt = dao.updateMemberByUid(mb_uid);
			request.setAttribute("reserveOk", cnt);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}