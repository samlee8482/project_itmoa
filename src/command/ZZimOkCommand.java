package command;

import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.beans.ClassDAO;

public class ZZimOkCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		boolean ifZZim = Boolean.parseBoolean(request.getParameter("ifZZim"));
		int mb_uid = Integer.parseInt(request.getParameter("mb_uid"));
		int class_uid = Integer.parseInt(request.getParameter("class_uid"));
		int zzim_uid = Integer.parseInt(request.getParameter("zzim_uid"));
		
		ClassDAO dao = new ClassDAO();
		int cnt = 0;
		
		if(mb_uid > 0
		&& class_uid > 0
		&& zzim_uid > 0) {			
			if (ifZZim == true) {
				try {
					cnt = dao.deleteZZim(zzim_uid);
					request.setAttribute("zzimOk", cnt);
				} catch (SQLException e) {
					e.printStackTrace();
				} catch (NamingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else if (ifZZim == false) {
				try {
					cnt = dao.insertZZim(mb_uid, class_uid);
					request.setAttribute("zzimOk", cnt);
				} catch (SQLException e) {
					e.printStackTrace();
				} catch (NamingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}