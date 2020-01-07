package command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.beans.AdminClassDAO;
import com.lec.beans.ClassDTO;

public class AdminInsViewCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		ClassDTO [] insArr = null; 
		AdminClassDAO dao = new AdminClassDAO();

		try {
			insArr = dao.insView();
			if (insArr.length == 1) {
				request.setAttribute("adminInsView", insArr);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}	

}



