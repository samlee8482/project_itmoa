package command;

import java.sql.SQLException;
import java.util.Enumeration;

import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.beans.AdminClassDAO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.oreilly.servlet.multipart.FileRenamePolicy;

public class AdminInsUpdateOkCommand implements Command {

	String ins_name;
	String ins_tel;
	String ins_branch;
	String ins_location;
	String ins_add1;
	String ins_add2;
	String ins_img;
	double ins_x;
	double ins_y;
	int ins_zip;
	int ins_uid;
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		AdminClassDAO dao = new AdminClassDAO();
		int cnt = 0;
		
		//ServletContext context = this.getServletContext();	// 서블릿 객체에서 ServletContext 객체 불러옴
		
		// 최대 5M byte
		String saveDirectory = "C:\\tomcat\\upload";
		int maxPostSize = 5 * 1024 * 1024;	// 최대 5M byte POST 받기
		String encoding = "utf-8";	// 인코딩
		FileRenamePolicy policy = new DefaultFileRenamePolicy();	// 업로딩 파일 이름 중복 정책
		
		MultipartRequest multi = null;
		
		// MultipartRequest 객체생성. 생성한것만으로도 서버에 파일 저장되어있음
		// 파일 저장까지 마무리
		try{
			multi = new MultipartRequest(
					request,
					saveDirectory,
					maxPostSize,
					encoding,
					policy
					);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("파일 예외 처리 발생");
		}
		Enumeration names = null;
		names = multi.getParameterNames();	// form 의 name 들 추출
		while(names.hasMoreElements()){
			String name = (String)names.nextElement();	// name
			String value = multi.getParameter(name);
			switch(name) {
			case "ins_name":
				this.ins_name = value;
				break;
			case "ins_tel":
				this.ins_tel = value;
				break;
			case "ins_branch":
				this.ins_branch = value;
				break;
			case "ins_location":
				this.ins_location = value;
				break;
			case "ins_add1":
				this.ins_add1 = value;
				break;
			case "ins_add2":
				this.ins_add2 = value;
				break;
			case "ins_zip":
				this.ins_zip = Integer.parseInt(value);
				break;
			case "ins_x":
				this.ins_x = Double.parseDouble(value);
				break;
			case "ins_y":
				this.ins_y = Double.parseDouble(value);
				break;
			case "ins_uid":
				this.ins_uid = Integer.parseInt(value);
				break;
			case "ins_img":
				this.ins_img = value;
				break;
			}
			
			System.out.println(name + " : " + value);
		}
		
//		String ins_name = request.getParameter("ins_name");
//		System.out.println(ins_name);
//		String ins_tel = request.getParameter("ins_tel");
//		System.out.println(ins_tel);
//		int ins_zip = Integer.parseInt(request.getParameter("ins_zip"));
//		String ins_add1 = request.getParameter("ins_add1");
//		String ins_add2 = request.getParameter("ins_add2");
//		String ins_location = request.getParameter("ins_location");
//		String ins_branch = request.getParameter("ins_branch");
//		String ins_img = request.getParameter("ins_img");
//		int ins_uid = Integer.parseInt(request.getParameter("ins_uid"));
//		double ins_x = Double.parseDouble(request.getParameter("ins_x"));
//		double ins_y = Double.parseDouble(request.getParameter("ins_y"));
		
		try {
			cnt = dao.updateInsByUid(ins_name, ins_tel, ins_zip, ins_add1, ins_add2,
					 ins_location, ins_branch, ins_img, ins_x, ins_y, ins_uid);
			if(cnt > 0) request.setAttribute("adminInsUpdateOk", cnt);
		} catch(NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
