package command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.beans.AdminClassDAO;
import com.lec.beans.ClassDTO;

public class AdminInsListCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		
		int option = Integer.parseInt(request.getParameter("option"));
		String keyword = request.getParameter("keyword");
		
		
		AdminClassDAO dao = new AdminClassDAO();
		ClassDTO [] arr = null;
		
		
		if(keyword.equals("") || keyword == null ) { option = 4; }  // keyword 빈값이면 4, 전체 
		
		
		try {
			
			arr = dao.selectInsList(option, keyword);
			request.setAttribute("adminInsList", arr);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			

	}

}
