package command;

import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.beans.ClassDAO;


public class ZzimDeleteOkCommand implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		ClassDAO dao = new ClassDAO();
		int cnt = 0;
		
		int z_uid = Integer.parseInt(request.getParameter("zzim_uid"));
		
		if (z_uid > 0) {
			try {
				
				cnt = dao.deleteZZim(z_uid);
				
				request.setAttribute("deleteZzim", cnt);
				
			} catch (SQLException e) {
				// TODO: handle exception
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
