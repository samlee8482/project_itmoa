package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.beans.AdminClassDAO;
import com.lec.beans.ClassDTO;

public class AdminCurUpdateCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
			int cur_uid = Integer.parseInt(request.getParameter("cur_uid"));
			ClassDTO [] CurArr = null;
			AdminClassDAO dao = new AdminClassDAO();
			
			
	}

}
