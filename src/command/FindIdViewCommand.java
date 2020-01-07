package command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.beans.MbDAO;
import com.lec.beans.MbDTO;

public class FindIdViewCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		MbDTO[] arr = null;
		MbDAO dao = new MbDAO();
		
		String mb_name = request.getParameter("mb_name");
		String mb_email = request.getParameter("mb_email");

		try {
			arr = dao.selectId(mb_name, mb_email);
			if(arr.length == 1) {
				request.setAttribute("findIdView", arr);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
