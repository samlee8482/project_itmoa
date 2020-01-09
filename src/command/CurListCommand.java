package command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.beans.ClassDAO;
import com.lec.beans.ClassDTO;

public class CurListCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		String option_location = request.getParameter("option_location");
		String option_branch = request.getParameter("option_branch");
		String option_curName = request.getParameter("option_curName");
		

		ClassDAO dao = new ClassDAO();
		
		ClassDTO [] arr = null;

		
		try {
			
			arr = dao.selectClassList(option_location, option_branch, option_curName);	
			request.setAttribute("classList", arr);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		

		
		
	}

}