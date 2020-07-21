package board.user.user;

public class User {
	private int id;
	private String password;
	private String passwordConfirm;
	private String loginId;
	private String userName;
	private int active;
	
	public User() {
		
	}

	public User(int id, String password, String passwordConfirm, String loginId, String userName, int active) {
		super();
		this.id = id;
		this.password = password;
		this.passwordConfirm = passwordConfirm;
		this.loginId = loginId;
		this.userName = userName;
		this.active = active;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}
	
}
