package command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.beans.ReviewDAO;
import com.lec.beans.ReviewDTO;

public class ReviewViewCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		ReviewDAO dao = new ReviewDAO();
		ReviewDTO [] arr = null;
		
		int review_brd_uid = Integer.parseInt(request.getParameter("review_brd_uid"));
		
		try {
			arr = dao.readReviewByUid(review_brd_uid);
			request.setAttribute("reviewView", arr);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
