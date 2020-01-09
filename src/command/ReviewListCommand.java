package command;

import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.beans.AdminReviewDAO;
import com.lec.beans.ReviewDAO;
import com.lec.beans.ReviewDTO;

public class ReviewListCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String opr = request.getParameter("option_review");
		String keyword = request.getParameter("keyword");

		int option_review = 0;
		
		if (opr == null) {
			option_review = 4;
			keyword = "all";
		} else {
			option_review = Integer.parseInt(request.getParameter("option_review"));
		}
		
		ReviewDAO dao = new ReviewDAO();
		ReviewDTO [] arr = null;
		
		if (option_review > 0
		&& keyword != null && !keyword.trim().equals("")) {
			try {
				arr = dao.selectReviewList(option_review, keyword);
				request.setAttribute("reviewList", arr);
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}