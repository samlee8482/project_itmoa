package command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.beans.AdminNewsDAO;
import com.lec.beans.NewsDAO;

public class AdminNewsUpdateOkCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int news_brd_uid = Integer.parseInt(request.getParameter("news_brd_uid"));
		String news_brd_title = request.getParameter("news_brd_title");
		String news_brd_content = request.getParameter("news_brd_content");
		String news_brd_img = request.getParameter("news_brd_img");
		
		AdminNewsDAO dao = new AdminNewsDAO();
		int cnt = 0;
		
		try {
			cnt = dao.updateNewsByUid(news_brd_uid, news_brd_title, news_brd_content, news_brd_img);
			request.setAttribute("adminNewsUpdateOk", cnt);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}