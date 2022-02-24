package site.metacoding.mvc;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import site.metacoding.mvc.web.MyUserController;


//http://localhost:8000/
//http://localhost:8000/myuser
//http://localhost:8000/mypost
@WebServlet("/")  //슬래쉬만 적으면 모든 요청이 여기로 다 들어온다. 뒤에 뭘 적어도 다 된다.
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
String domain = request.getRequestURI();
System.out.println("domain: " + domain);

if(domain.equals("/myuser")) {
	MyUserController controller = new MyUserController(request, response);
	
	String idStr = request.getParameter("id"); //null
	if(idStr == null) { //쿼리스트링이 없다는 것 
		controller.getAll();
	} else {//쿼리스트링이 있따는 것 
		int id = Integer.parseInt(idStr);
		controller.getOne(id);
	}
	
}
	} //dispatcher thread가  종료 -> (1. 클라이언트에게 연결된 response선 잘림)
	//(2.request 메모리 영역 삭제됨, db connection 반납). 

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	} //dispatcher 서블릿이 종료

}
