package site.metacoding.mvc.config;

import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBConn {

	//책임: 이미 만들어진 connection객체를 return시킴
	//conn을 여러개 들고 있고 거기서 안 쓰고 있는걸 찾아서 준다. 
	public static Connection getConnection() {
Connection conn = null;
		try {
			Context initContext = new InitialContext();
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource)envContext.lookup("jdbc/myoracle");
			conn = ds.getConnection();
			System.out.println("db연결성공");
			//etc.
		} catch (Exception e) {
			System.out.println("db연결실패");
			e.printStackTrace();
		}
return conn;
	}
}
