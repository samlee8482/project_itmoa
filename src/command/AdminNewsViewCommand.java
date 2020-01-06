package command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.beans.AdminNewsDAO;
import com.lec.beans.NewsDTO;

public class AdminNewsViewCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int news_brd_uid = Integer.parseInt(request.getParameter("news_brd_uid"));
		
		AdminNewsDAO dao = new AdminNewsDAO();
		NewsDTO [] arr = null;
		
		try {
			arr = dao.selectNewsByUid(news_brd_uid);
			request.setAttribute("adminNewsView", arr);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}