package site.metacoding.servletproject;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//http://localhost:80/index.jsp(=URL)
//http://localhost:80/hello (=URI)

@WebServlet("/test") // 헬로가 들어오면 get이 요청됨 - 식별자 요청
public class TestServlet extends HttpServlet {

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

	// 사용자에게 받은 http body, http header정보를 httpServletRequest req에 담고
	// 그 친구에게 응답될 빈 객체 HttpServletResponse resp 를 만들어서
	// doGet(req,resp); 담아서 호출해준다. (아파치 /톰캣에 의해 호출된다)
	// 요청받은거 req, 응답할거 resp
	// 원래 resp 에 buffered writer 담아서 보낸다. (내부적으로 구현)
	// doGet();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("get요청됨");

		String name = "Juwon";
		PrintWriter out = resp.getWriter(); // 이게 결국 버퍼드 라이터랑 똑같아, auto flush까지 다 구현돼있다 .

		out.println("<html>");
		out.println("<head>");
		out.println("<body>");
		out.println("<h1>index 페이지입니다. + " + name + " </h1>");
		out.println("</body>");
		out.println("</head>");
		out.println("</html>");

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

}
