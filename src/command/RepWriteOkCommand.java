package command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.beans.ReviewDAO;

public class RepWriteOkCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int mb_uid = Integer.parseInt(request.getParameter("mb_uid"));
		String rep_content = request.getParameter("rep_content");
		
		ReviewDAO dao = new ReviewDAO();
		int cnt = 0;
		
		try {
			cnt = dao.insertRep(mb_uid, rep_content);
			request.setAttribute("repWriteOk", cnt);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}