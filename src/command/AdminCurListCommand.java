package command;

import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.beans.AdminClassDAO;
import com.lec.beans.ClassDTO;

public class AdminCurListCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		AdminClassDAO dao = new AdminClassDAO();
		int ins_uid = Integer.parseInt(request.getParameter("ins_uid"));
		ClassDTO[] curArr = null;
		
		if(ins_uid > 0) {
			try {
				curArr = dao.selectClassByUid(ins_uid);
				request.setAttribute("adminCurList",curArr);
			} catch (NamingException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("데이터 불러오기 실패");
		}
		
	}
}
