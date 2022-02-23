package site.metacoding.servletproject.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//HTTP protocol 최초 version (GET)
// HTTP1.0 protocol (GET, POST)
//HTTP 1.1 protocol (GET (주소요청) ,POST ( 폼태그) ,DELETE ( 자바스크립트) ,PUT (자바 스크립트) )

// http://localhost:80/front
@WebServlet("/front")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public FrontController() {
        System.out.println("나 메모리에 떳어: front controller");
    }
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("front controller로 요청 들어옴");
		
		//공통 로직 처리
		
		
		//1. 라우터 만들기
		String path = request.getParameter("path");
		System.out.println("path: " + path);
		
		if(path.equals("login")) {
//			//로그인페이지 응답
			response.sendRedirect("/login.jsp"); //경로만 적어주면 된다. 어짜피 서블릿 폴더 안에 있으니까 상대경로도 적을 수 있다. 그치만 그냥 /login.jsp해줘
//		PrintWriter out = response.getWriter();
//		out.println("<!DOCTYPE html>");
//		out.println("<html>");
//		out.println("<head>");
//		out.println("\r\n"
//				+ "<meta charset=\"UTF-8\">");
//		out.println("<title>Insert title here</title>");
//		out.println("</head>");
//		out.println("<body>");
//		out.println("\r\n"
//				+ "<h1>login</h1>");
//		out.println("\r\n"
//				+ "</body>");
//		out.println("</html>");
			
			
		} else if (path.equals("join")) {
//			//join page 응답
			response.sendRedirect("/join.jsp"); 
//			PrintWriter out = response.getWriter();
//			out.println("<!DOCTYPE html>");
//			out.println("<html>");
//			out.println("<head>");
//			out.println("\r\n"
//					+ "<meta charset=\"UTF-8\">");
//			out.println("<title>Insert title here</title>");
//			out.println("</head>");
//			out.println("<body>");
//			out.println("\r\n"
//					+ "<h1>join</h1>");
//			out.println("\r\n"
//					+ "</body>");
//			out.println("</html>");
		}
		}
}
