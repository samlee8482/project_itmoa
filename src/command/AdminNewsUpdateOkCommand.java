package command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.beans.AdminNewsDAO;

public class AdminNewsUpdateOkCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int news_brd_uid = Integer.parseInt(request.getParameter("news_brd_uid"));
		String news_brd_title = request.getParameter("news_brd_title");
		String news_brd_content = request.getParameter("news_brd_content");
		String news_brd_img = request.getParameter("news_brd_img");
		
		AdminNewsDAO dao = new AdminNewsDAO();
		int cnt = 0;

		if (news_brd_uid > 0
			&& news_brd_title != null && news_brd_title.length() > 0 && !news_brd_title.equals("")
			&& news_brd_content != null && news_brd_content.length() > 0 && !news_brd_content.equals("")
			&& news_brd_img != null && news_brd_img.length() > 0 && !news_brd_img.equals("")) {
			try {
				cnt = dao.updateNewsByUid(news_brd_uid, news_brd_title, news_brd_content, news_brd_img);
				request.setAttribute("adminNewsUpdateOk", cnt);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}