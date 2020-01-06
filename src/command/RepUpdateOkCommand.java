package command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.beans.ReviewDAO;

public class RepUpdateOkCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int rep_uid = Integer.parseInt(request.getParameter("rep_uid"));
		String rep_content = request.getParameter("rep_content");
		String rep_regdate = request.getParameter("rep_regdate");
		
		ReviewDAO dao = new ReviewDAO();
		int cnt = 0;
		
		try {
			cnt = dao.updateRepByUid(rep_uid, rep_content, rep_regdate);
			request.setAttribute("repUpdateOk", cnt);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}