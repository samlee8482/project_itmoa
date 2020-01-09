package command;

import java.sql.SQLException;

import javax.naming.NamingException;
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
		
		// 검색조건 없을 때
		if(option_location == null ||  option_branch == null || option_curName == null) {
			try {
				
				arr = dao.selectClassList();	
				request.setAttribute("classList", arr);
				
			} catch (SQLException e) {
				e.printStackTrace();
			}		
			
		}
				

		
		// 검색조건 있을 때
		else if(!option_location.equals("") && !option_branch.equals("") && !option_curName.equals("") 
				&& option_location != null  && option_branch != null && option_curName != null ) {
			try {
				
				arr = dao.selectClassList(option_location, option_branch, option_curName);	
				request.setAttribute("classList", arr);
				
			} catch (SQLException e) {
				e.printStackTrace();
			} 
		
		}
		
	}
	
	

}