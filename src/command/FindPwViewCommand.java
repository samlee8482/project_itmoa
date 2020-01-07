package command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.beans.MbDAO;
import com.lec.beans.MbDTO;

public class FindPwViewCommand implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		MbDTO[] arr = null;
		MbDAO dao = new MbDAO();
		
		String mb_id = request.getParameter("mb_id");
		String mb_name = request.getParameter("mb_name");
		String mb_email = request.getParameter("mb_email");    

		try {
			arr = dao.selectPw(mb_id, mb_name, mb_email);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("findPwView", arr);
		
	}

}
