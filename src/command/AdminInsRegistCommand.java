package command;

import java.sql.SQLException;
import java.util.regex.Pattern;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.beans.AdminClassDAO;

public class AdminInsRegistCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		String ins_name = request.getParameter("ins_name");
		String ins_tel1 = request.getParameter("ins_tel1");
		String ins_tel2 = request.getParameter("ins_tel2");
		String ins_tel3 = request.getParameter("ins_tel3");
		int ins_zip = Integer.parseInt(request.getParameter("ins_zip"));
		String ins_add1 = request.getParameter("ins_add1");
		String ins_add2 = request.getParameter("ins_add1");
		String ins_location = request.getParameter("ins_location");
		String ins_branch = request.getParameter("ins_branch");
		Double ins_x = Double.parseDouble(request.getParameter("ins_x"));
		Double ins_y = Double.parseDouble(request.getParameter("ins_y"));
		String ins_img = request.getParameter("ins_branch");
		
		AdminClassDAO dao = new AdminClassDAO();
		int result_cnt = 0;

		String ins_tel = ins_tel1+ins_tel2+ins_tel3;
		

		try {	

				result_cnt = dao.insertIns(ins_name, ins_zip, ins_add1, ins_add2, ins_tel, ins_img, ins_branch, ins_location, ins_x, ins_y);	

		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		request.setAttribute("result", result_cnt);

	}

}
