package site.metacoding.mvc.web;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import site.metacoding.mvc.domain.MyUser;
import site.metacoding.mvc.domain.MyUserRepository;

// 회원 관련 요청만 컨트롤
public class MyUserController {

    private MyUserRepository repo;
    private HttpServletRequest request;
    private HttpServletResponse response;

    public MyUserController(HttpServletRequest request, HttpServletResponse response) {
        repo = new MyUserRepository();
        this.request = request;
        this.response = response;
    }

    // GET:http://localhost:8000/myuser
    public void getAll() {
        System.out.println("getAll 호출됨");
        List<MyUser> myUsers = repo.selectAll();
        request.setAttribute("myUsers", myUsers);
        
        System.out.println("size: " +myUsers.size()); //size:3 성공!!!
        
        try {
            //response.sendRedirect("/userInfo.jsp");
            RequestDispatcher dis = request.getRequestDispatcher("/user.jsp");
            dis.forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // GET:http://localhost:8000/myuser?id=1
    public void getOne(int id) {

        System.out.println("getOne 호출됨");
        MyUser myUser = repo.selectById(id);
        System.out.println("myUser : " + myUser.getUsername());
        request.setAttribute("myUser", myUser);

        try {
            //response.sendRedirect("/userInfo.jsp");
            RequestDispatcher dis = request.getRequestDispatcher("/userInfo.jsp");
            dis.forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}