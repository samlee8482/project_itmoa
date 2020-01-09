package command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.beans.AdminMbDAO;

public class AdminMemberUpdateOkCommand implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
	
		boolean ifNew = Boolean.parseBoolean(request.getParameter("ifNew"));
		String news_brd_title = request.getParameter("news_brd_title");
		String news_brd_content = request.getParameter("news_brd_content");
		String news_brd_img = request.getParameter("news_brd_img");
		
		AdminMbDAO dao = new AdminMbDAO();
		int cnt = 0;
		if (ifNew) {
			if (news_brd_title != null && !news_brd_title.trim().equals("")
				&& news_brd_content != null && !news_brd_content.trim().equals("")
				&& news_brd_img != null && !news_brd_img.trim().equals("")) {
				try {
					cnt = dao.insertNews(news_brd_title, news_brd_img, news_brd_content);
					if (cnt == 1) cnt = 1;
					if (cnt == 0) cnt = 0;
					request.setAttribute("adminNewsUpdateOk", cnt);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} else if (!ifNew) {
			int news_brd_uid = Integer.parseInt(request.getParameter("news_brd_uid"));
			if (news_brd_uid > 0
				&& news_brd_title != null && news_brd_title.length() > 0 && !news_brd_title.trim().equals("")
				&& news_brd_content != null && news_brd_content.length() > 0 && !news_brd_content.trim().equals("")
				&& news_brd_img != null && news_brd_img.length() > 0 && !news_brd_img.trim().equals("")) {
				try {
					cnt = dao.updateNewsByUid(news_brd_uid, news_brd_title, news_brd_content, news_brd_img);
					if (cnt == 0) cnt = 2;
					if (cnt == 1) cnt = 3;
					request.setAttribute("adminNewsUpdateOk", cnt);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
