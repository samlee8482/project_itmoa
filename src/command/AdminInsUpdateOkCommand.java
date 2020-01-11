package command;

import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.beans.AdminClassDAO;
import com.lec.beans.ClassDTO;

public class AdminInsUpdateOkCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		AdminClassDAO dao = new AdminClassDAO();
		    
		int cnt = 0;
		String ins_name = request.getParameter("ins_name");
		System.out.println(ins_name);
		String ins_tel = request.getParameter("ins_tel");
		System.out.println(ins_tel);
		int ins_zip = Integer.parseInt(request.getParameter("ins_zip"));
		String ins_add1 = request.getParameter("ins_add1");
		String ins_add2 = request.getParameter("ins_add2");
		String ins_location = request.getParameter("ins_location");
		String ins_branch = request.getParameter("ins_branch");
		String ins_img = request.getParameter("ins_img");
		int ins_uid = Integer.parseInt(request.getParameter("ins_uid"));
		double ins_x = Double.parseDouble(request.getParameter("ins_x"));
		double ins_y = Double.parseDouble(request.getParameter("ins_y"));
		
		try {
			cnt = dao.updateInsByUid(ins_name,  ins_tel,  ins_zip,  ins_add1,  ins_add2,
					 ins_location,  ins_branch,  ins_img,  ins_x,  ins_y,  ins_uid);
			
			if(cnt > 0) request.setAttribute("adminInsUpdateOk", cnt);
			
		} catch(NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
