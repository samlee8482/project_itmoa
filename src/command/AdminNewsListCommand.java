package command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.beans.AdminNewsDAO;
import com.lec.beans.NewsDTO;

public class AdminNewsListCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int option_news_1 = Integer.parseInt(request.getParameter("option_news_1"));
		int option_news_2 = Integer.parseInt(request.getParameter("option_news_2"));
		String option_news_3 = request.getParameter("option_news_3");
		
		AdminNewsDAO dao = new AdminNewsDAO();
		NewsDTO [] arr = null;
		
		if (option_news_1 > 0
		&& option_news_2 > 0
		&& option_news_3 != null && option_news_3.length() > 0 && !option_news_3.trim().equals("")) {
			try {
				arr = dao.selectNews(option_news_1, option_news_2, option_news_3);
				request.setAttribute("adminNewsList", arr);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
