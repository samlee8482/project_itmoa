package command;

import java.sql.SQLException;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.beans.MbDAO;
import com.lec.beans.MbDTO;

import common.D;

public class LoginOkCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		MbDTO[] arr = null;
		MbDAO dao = new MbDAO();
		
		//입력한 값을 받아오기
		String mb_id = request.getParameter("mb_id");
		String mb_pw = request.getParameter("mb_pw");
		
		try {			
			arr = dao.login(mb_id, mb_pw);
			if(arr[0].getMb_id().equals(mb_id) && arr[0].getMb_pw().equals(mb_pw)) {
				request.setAttribute("loginOk", arr);
			} else {
				arr = null;
				request.setAttribute("loginOk", arr);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
