package command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.beans.ReviewDAO;
import com.lec.beans.ReviewDTO;

public class ReviewListCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int option_review = Integer.parseInt(request.getParameter("option_review"));
		String keyword = request.getParameter("keyword");
		
		ReviewDAO dao = new ReviewDAO();
		ReviewDTO [] arr = null;
		
		if (option_review > 0
		&& keyword != null && keyword.length() > 0 && !keyword.trim().equals("")) {
			try {
				arr = dao.selectReviewList(option_review, keyword);
				request.setAttribute("reviewList", arr);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}