package command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.beans.AdminReviewDAO;
import com.lec.beans.ReviewDAO;
import com.lec.beans.ReviewDTO;

public class AdminReviewListCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int option_review = Integer.parseInt(request.getParameter("option_review"));
		String keyword = request.getParameter("keyword");
		
		AdminReviewDAO dao = new AdminReviewDAO();
		ReviewDTO [] arr = null;
		
		try {
			arr = dao.selectReviewList(option_review, keyword);
			request.setAttribute("adminReviewList", arr);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
