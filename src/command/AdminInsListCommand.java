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
		
		System.out.println(option + " " + keyword );
		
		AdminClassDAO dao = new AdminClassDAO();
		ClassDTO [] arr = null;
		
		
		
		try {
			
			if(option == null || option.equals("") || keyword == null || keyword.equals("")){
				
				arr = dao.selectInsList();
				request.setAttribute("adminInsList", arr);
				
			}else {
				
//				option 1: 전체
//			      	   2: 학원명
//			           3: 학원코드
						
				arr = dao.selectInsListByOption(Integer.parseInt(option), keyword);
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
