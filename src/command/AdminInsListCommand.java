package command;

import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.beans.AdminClassDAO;
import com.lec.beans.ClassDTO;

public class AdminInsListCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {


		String option = request.getParameter("option");
		String keyword = request.getParameter("keyword");
		
		
		AdminClassDAO dao = new AdminClassDAO();
		ClassDTO [] arr = null;
		
		
		try {
			
			if(keyword == null || keyword.equals("") || keyword.equals("없음")){
				
				arr = dao.selectInsList();
				request.setAttribute("adminInsList", arr);
				
			}else {
				
				arr = dao.selectInsListByOption(option, keyword);
				request.setAttribute("adminInsList", arr);
				
			}

				


		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			

	}

}
