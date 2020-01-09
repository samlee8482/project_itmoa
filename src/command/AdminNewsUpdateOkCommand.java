package command;

import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.beans.AdminNewsDAO;

public class AdminNewsUpdateOkCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		boolean ifNew = Boolean.parseBoolean(request.getParameter("ifNew"));
		String news_brd_title = request.getParameter("news_brd_title");
		String news_brd_content = request.getParameter("news_brd_content");
		String news_brd_img = request.getParameter("news_brd_img");
		
		AdminNewsDAO dao = new AdminNewsDAO();
		int cnt = 0;
<<<<<<< HEAD

		if (news_brd_uid > 0
			&& news_brd_title != null && news_brd_title.length() > 0 && !news_brd_title.trim().equals("")
			&& news_brd_content != null && news_brd_content.length() > 0 && !news_brd_content.trim().equals("")
			&& news_brd_img != null && news_brd_img.length() > 0 && !news_brd_img.trim().equals("")) {
			try {
				cnt = dao.updateNewsByUid(news_brd_uid, news_brd_title, news_brd_content, news_brd_img);
				request.setAttribute("adminNewsUpdateOk", cnt);
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
=======
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
>>>>>>> branch 'master' of https://github.com/gzgzg2/Project_itmoa.git
			}
		}
	}

}