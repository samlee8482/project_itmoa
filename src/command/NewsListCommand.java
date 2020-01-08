package command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.beans.NewsDAO;
import com.lec.beans.NewsDTO;

public class NewsListCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String option_news = request.getParameter("option_news");
		String keyword = request.getParameter("keyword");
		String paramFrom = request.getParameter("from");
		String paramRows = request.getParameter("rows");
		int fromRow = 0;
		int pageRows = 0;
		
		if (option_news == null) option_news = "3";
		if (keyword == null) keyword = "all";
		if (paramFrom == null) fromRow = 1;
		if (paramRows == null) pageRows = 8;

		NewsDAO dao = new NewsDAO();
		NewsDTO [] arr = null;
		
		if (option_news != null && !option_news.trim().equals("")
		&& keyword != null && !keyword.trim().equals("")) {
			try {
				arr = dao.selectNewsList(option_news, keyword, fromRow, pageRows);
				request.setAttribute("newsList", arr);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}