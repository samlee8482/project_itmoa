package command;

import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.beans.MbDAO;
import com.lec.beans.MbDTO;

public class MyPageCommand implements Command {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		MbDAO dao = new MbDAO();
		MbDTO [] arr = null;
				
		int uid = Integer.parseInt(request.getParameter("uid"));
		
		
		if(uid > 0) {// 매개변수 유효성 검증
			try {
				
				arr = dao.myPage(uid);  // 회원정보 가져오기
				request.setAttribute("myPage", arr);
				
			} catch (SQLException e) {  
				e.printStackTrace();
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
				// 처리실패하면 다시 돌아가야되는거 아닌감?!??!?!?!?
				// 내말이!! 낼 논의 ㄱㄱ!!궁금하당 - 쌤리
		}
	
	}

}
