package command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.beans.AdminClassDAO;
import com.lec.beans.ClassDTO;

public class AdminInsOkCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		AdminClassDAO dao = new AdminClassDAO();
		boolean ifNew = Boolean.parseBoolean(request.getParameter("ifNew"));
		
		int cnt = 0;
		
		if(ifNew) {
			try {
				String ins_name = request.getParameter("ins_name");
				String ins_tel = request.getParameter("ins_tel");
				int ins_zip = Integer.parseInt(request.getParameter("ins_zip"));
				String ins_add1 = request.getParameter("ins_add1");
				String ins_add2 = request.getParameter("ins_add2");
				String ins_location = request.getParameter("ins_location");
				String ins_branch = request.getParameter("ins_branch");
				String ins_img = request.getParameter("ins_img");
				
				cnt = dao.insertIns(ins_name, ins_zip, ins_add1, ins_add2, ins_tel, ins_img,
						ins_branch, ins_location);
				
				if(cnt > 0) request.setAttribute("adminInsOk", cnt);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			try {
				String ins_name = request.getParameter("ins_name");
				String ins_tel = request.getParameter("ins_tel");
				int ins_zip = Integer.parseInt(request.getParameter("ins_zip"));
				String ins_add1 = request.getParameter("ins_add1");
				String ins_add2 = request.getParameter("ins_add2");
				String ins_location = request.getParameter("ins_location");
				String ins_branch = request.getParameter("ins_branch");
				String ins_img = request.getParameter("ins_img");
				int ins_uid = Integer.parseInt(request.getParameter("ins_uid"));
				
				cnt = dao.updateInsByUid(ins_name, ins_tel, ins_zip, ins_add1, ins_add2,
						ins_location, ins_branch, ins_img, ins_uid);
				if(cnt > 0) request.setAttribute("adminInsOk", cnt);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
