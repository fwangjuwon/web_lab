package site.metacoding.mvc.domain;

//데이터베이스 테이블을 자바 세상에 모델링하는 것
//select 한거 옮겨담는 클래스이다. getter,setter만들어야한다.
//생성자도 ㅎㅎ (값 넣는거 한꺼번에 넣으주려고)
public class MyUser {

	private int id;
	private String username;
	private String password;
	private String email;
	
public MyUser(int id, String username, String password, String email) {

    this.id = id;
    this.username = username;
    this.password = password;
    this.email = email;
}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
