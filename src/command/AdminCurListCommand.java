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
		int option_ins = Integer.parseInt(request.getParameter("option_ins"));
		String keyword = request.getParameter("keyword");
		ClassDTO[] curArr = null;
		
//		if(option_ins > 0 ) {
//			try {
//				curArr = dao.selectInsList(option_ins, keyword);
//				request.setAttribute("adminCurList",curArr);
//			} catch (NamingException e) {
//				e.printStackTrace();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		} else {
//			System.out.println("데이터 불러오기 실패");
//		}
		
	}
}
