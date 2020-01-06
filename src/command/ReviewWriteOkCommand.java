package command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.beans.ReviewDAO;

public class ReviewWriteOkCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int mb_uid = Integer.parseInt(request.getParameter("mb_uid"));
		String mb_id = request.getParameter("mb_id");
		String mb_img = request.getParameter("mb_img");
		String review_brd_title = request.getParameter("review_brd_title");
		String review_brd_content = request.getParameter("review_brd_content");
		
		ReviewDAO dao = new ReviewDAO();
		int cnt = 0;
		
		if (mb_uid > 0
		&& mb_id != null && mb_id.length() > 0 && !mb_id.equals("")
		&& mb_img != null && mb_img.length() > 0 && !mb_img.equals("")
		&& review_brd_title != null && review_brd_title.length() > 0 && !review_brd_title.equals("")
		&& review_brd_content != null && review_brd_content.length() > 0 && !review_brd_content.equals("")) {
			try {
				cnt = dao.insertReview(mb_uid, mb_id, mb_img, review_brd_title, review_brd_content);
				request.setAttribute("reviewDeleteOk", cnt);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}