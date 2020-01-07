package command;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.beans.ReviewDAO;

import command.Command;

public class ReviewUpdateOkCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int review_brd_uid = Integer.parseInt(request.getParameter("review_brd_uid"));
		String review_brd_title = request.getParameter("review_brd_title");
		String review_brd_content = request.getParameter("review_brd_content");
		
		ReviewDAO dao = new ReviewDAO();
		int cnt = 0;
		
		if (review_brd_uid > 0
		&& review_brd_title != null && review_brd_title.length() > 0 && !review_brd_title.trim().equals("")
		&& review_brd_content != null && review_brd_content.length() > 0 && !review_brd_content.trim().equals("")) {
			try {
				cnt = dao.updateReviewByUid(review_brd_uid, review_brd_title, review_brd_content);
				request.setAttribute("reviewDeleteOk", cnt);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}