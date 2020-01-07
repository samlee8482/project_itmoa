package command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.beans.NewsDAO;
import com.lec.beans.NewsDTO;

public class NewsListCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int option_news = Integer.parseInt(request.getParameter("option_news"));
		String keyword = request.getParameter("keyword");
		
		NewsDAO dao = new NewsDAO();
		NewsDTO [] arr = null;
		
		if (option_news > 0
		&& keyword != null && keyword.length() > 0 && !keyword.trim().equals("")) {
			try {
				arr = dao.selectNewsList(option_news, keyword);
				request.setAttribute("NewsList", arr);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}