package int371.project.EventMod.Models;

import java.io.Serializable;

public class JwtRequest implements Serializable {

	private String username;
	private String password;

	public JwtRequest() {

	};

	public JwtRequest(String username, String password) {
		this.setUsername(username);
		this.setPassword(password);
	}

//	Getter
	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

//	Setter
	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	};
}
