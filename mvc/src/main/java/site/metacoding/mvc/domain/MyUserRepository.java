package site.metacoding.mvc.domain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import site.metacoding.mvc.config.DBConn;

// insert, delete, update, select 하는 메서드 만들어서 재사용
// 1.모든 테이블마다 있어야하는 기본적인 메서드를 만들고 필요한 메서드는 추가로 만들어서 사용
public class MyUserRepository {

	private Connection conn;

	public MyUserRepository() {
		conn = DBConn.getConnection();
	}

	// SELECT * FROM myUser
	public List<MyUser> selectAll() {
		List<MyUser> myUsers = new ArrayList<>();

		String sql = "SELECT * FROM myUser"; 
		try {

			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) { // 한칸 커서 내리면서 리턴값이 트루일 때만 와일을 돌린다.

				MyUser myUser = new MyUser(rs.getInt("id"), rs.getString("username"), rs.getString("password"), rs.getString("email"));
				myUsers.add(myUser);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return myUsers;
	}

	// SELECT * FROM myUser WHERE id=?
	public MyUser selectById(int Id) {
		MyUser myUser = null;

		try {
			String sql = "SELECT * FROM myUser WHERE id=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Id);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				myUser = new MyUser(rs.getInt("id"), rs.getString("username"), rs.getString("password"),
						rs.getString("email"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return myUser;
	}

	// INSERT INTO myUser(id, username, password, email) VALUES
	// (seq_myUser.nextval,?,?,?)
	public int insert(String username, String password, String email) {
		int result = 0;
		return result;
	}

	// DELETE FROM myUser WHERE id=?
	public int deletebyId(int id) {
		int result = 0;

		try {
			String sql = "DELETE FROM myUser WHERE id=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	// UPDATE myUser SET username=?, password=?, email=? WHERE id=?
	public int update(int id, String username, String password, String email) {
		int result = 0;

		return result;
	}
}