package command;

import java.io.IOException;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.beans.AdminNewsDAO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class AdminNewsUpdateOkCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			MultipartRequest multi = new MultipartRequest(request, "C:\\Project_itmoa\\Project_itmoa\\WebContent\\newsMainImg", 1024 * 1024 * 10, "UTF-8", new DefaultFileRenamePolicy());
			boolean ifNew = Boolean.parseBoolean(multi.getParameter("ifNew"));
			String news_brd_title = multi.getParameter("news_brd_title");
			String news_brd_content = multi.getParameter("news_brd_content");
			String news_brd_img = multi.getFilesystemName("news_brd_img");
			
			System.out.println(news_brd_img);
			
			AdminNewsDAO dao = new AdminNewsDAO();
			int cnt = 0;
			
			if (ifNew) {
				if (news_brd_img == null) {
					if (news_brd_title != null && !news_brd_title.trim().equals("")
						&& news_brd_content != null && !news_brd_content.trim().equals("")) {
						try {
							cnt = dao.insertNewsWithoutMainImg(news_brd_title, news_brd_content);
							if (cnt == 1) cnt = 1;
							if (cnt == 0) cnt = 0;
							request.setAttribute("adminNewsUpdateOk", cnt);
						} catch (SQLException e) {
							e.printStackTrace();
						} catch (NamingException e) {
							e.printStackTrace();
						}
					}
				} else {
					if (news_brd_title != null && !news_brd_title.trim().equals("")
						&& news_brd_content != null && !news_brd_content.trim().equals("")) {
						try {
							news_brd_img = "/Project_itmoa/newsMainImg/" + news_brd_img;
							cnt = dao.insertNews(news_brd_title, news_brd_img, news_brd_content);
							if (cnt == 1) cnt = 1;
							if (cnt == 0) cnt = 0;
							request.setAttribute("adminNewsUpdateOk", cnt);
						} catch (SQLException e) {
							e.printStackTrace();
						} catch (NamingException e) {
							e.printStackTrace();
						}
					}
				}
			} else if (!ifNew) {
				int news_brd_uid = Integer.parseInt(request.getParameter("news_brd_uid"));
				if (news_brd_img.length() == 0) {
					if (news_brd_title != null && !news_brd_title.trim().equals("")
						&& news_brd_content != null && !news_brd_content.trim().equals("")) {
						System.out.println(news_brd_img);
						try {
							cnt = dao.updateNewsByUidWithoutImg(news_brd_uid, news_brd_title, news_brd_content);
							if (cnt == 1) cnt = 1;
							if (cnt == 0) cnt = 0;
							request.setAttribute("adminNewsUpdateOk", cnt);
						} catch (SQLException e) {
							e.printStackTrace();
						} catch (NamingException e) {
							e.printStackTrace();
						}
					}
				} else {
					if (news_brd_title != null && !news_brd_title.trim().equals("")
						&& news_brd_content != null && !news_brd_content.trim().equals("")) {
						try {
							news_brd_img = "/newsMainImg/" + news_brd_img;
							cnt = dao.updateNewsByUid(news_brd_uid, news_brd_title, news_brd_content, news_brd_img);
							if (cnt == 1) cnt = 1;
							if (cnt == 0) cnt = 0;
							request.setAttribute("adminNewsUpdateOk", cnt);
						} catch (SQLException e) {
							e.printStackTrace();
						} catch (NamingException e) {
							e.printStackTrace();
						}
					}
				}
			}	
			
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
	}
}