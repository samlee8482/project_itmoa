package command;

import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.beans.ReviewDAO;

public class RepDeleteOkCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int rep_uid = Integer.parseInt(request.getParameter("rep_uid"));
		
		ReviewDAO dao = new ReviewDAO();
		int cnt = 0;
		
		if (rep_uid > 0) {
			try {
				cnt = dao.deleteRepByUid(rep_uid);
				request.setAttribute("repDeleteOk", cnt);
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
