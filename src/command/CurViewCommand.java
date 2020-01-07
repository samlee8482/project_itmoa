package command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.beans.ClassDAO;
import com.lec.beans.ClassDTO;

public class CurViewCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

	
		int class_uid = Integer.parseInt(request.getParameter("class_uid"));
		
		
		ClassDAO dao = new ClassDAO();
		ClassDTO [] arr = null;
		
		
		try {
			
			arr = dao.selectClassByUid(class_uid);
			request.setAttribute("curView", arr);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}

}
