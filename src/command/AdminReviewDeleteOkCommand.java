package command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.beans.AdminReviewDAO;

public class AdminReviewDeleteOkCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int review_uid = Integer.parseInt(request.getParameter("review_uid"));
		
		AdminReviewDAO dao = new AdminReviewDAO();
		int cnt = 0;
		
		try {
			cnt = dao.deleteReview(review_uid);
			request.setAttribute("adminReviewDeleteOk", cnt);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}