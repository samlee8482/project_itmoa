package command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.beans.AdminClassDAO;
import com.lec.beans.ClassDTO;

public class AdminInsViewCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		int ins_uid = Integer.parseInt(request.getParameter("ins_uid"));
		
		AdminClassDAO dao = new AdminClassDAO();
		ClassDTO [] arr = null;
		
		try {
			arr = dao.selectInsByUid(ins_uid);
			request.setAttribute("adminInsView", arr);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
			
		
	}

}
