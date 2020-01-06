package command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.beans.NewsDAO;
import com.lec.beans.NewsDTO;

public class NewsViewCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		NewsDAO dao = new NewsDAO();
		NewsDTO [] arr = null;
		
		int news_brd_uid = Integer.parseInt(request.getParameter("news_brd_uid"));
		
		try {
			arr = dao.readNewsByUid(news_brd_uid);
			request.setAttribute("news_brd_view", arr);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
