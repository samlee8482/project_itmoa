package command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.beans.ClassDAO;
import com.lec.beans.ClassDTO;

public class CurListCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		ClassDAO dao = new ClassDAO();
		ClassDTO [] arr = null;
		
		
//		String option_location = request.getParameter("option_location");
//		String option_branch = request.getParameter("option_branch");
//		String option_curName = request.getParameter("option_curName");
//
//		
//		
//		if(!option_location.equals("") && !option_branch.equals("") && !option_curName.equals("") 
//				&& option_location != null  && option_branch != null && option_curName != null ) {
//			try {
//				
//				arr = dao.selectClassList(option_location, option_branch, option_curName);	
//				request.setAttribute("classList", arr);
//				
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		
//		}else {
			try {
				
				arr = dao.selectClassList();	
				request.setAttribute("classList", arr);
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
//		}
		
		
	}
	
	

}