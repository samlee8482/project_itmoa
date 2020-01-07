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
		MbDAO dao = new MbDAO();
		MbDTO[] arr = null;
		
		//입력한 값을 받아오기
		String mb_id = request.getParameter("mb_id");
		String mb_pw = request.getParameter("mb_pw");
		
		try {			
			arr = dao.login(mb_id, mb_pw);
			
			if(arr.length == 1) {
				// arr 이 loginOk 페이지로 넘어감 -> arr.length > 0 성공 -> 성공했을시 메인페이지로 화면전환되고 arr에 있는 이미지를 가져오기 
				request.setAttribute("loginOk", arr);
			} else {
				System.out.println("로그인 실패");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
