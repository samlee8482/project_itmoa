package command;

import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.beans.ReviewDAO;
import com.lec.beans.ReviewDTO;

public class ReviewViewCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		ReviewDAO dao = new ReviewDAO();
		ReviewDTO [] arr = null;
		ReviewDTO [] arr2 = null;
		
		int review_brd_uid = Integer.parseInt(request.getParameter("review_brd_uid"));
		
		if (review_brd_uid > 0) {
			try {
				arr = dao.readReviewByUid(review_brd_uid);
				arr2 = dao.selectRepByUid(review_brd_uid);
				request.setAttribute("reviewView", arr);
				request.setAttribute("repView", arr2);
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		
	}

}
