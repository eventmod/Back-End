package  int371.project.EventMod.Models;

import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

@Entity(name = "accounts")
public class AuthenticationUser extends User {

	public AuthenticationUser() {
		super("anonymous", "", new ArrayList<>());
	}

	public AuthenticationUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ac_id")
	private int accountID;

	@Column(name = "ac_username")
	private String username;

	@Column(name = "ac_password")
	private String password;

	@Column(name = "ac_faculty")
	private String accountFaculty;

	@OneToOne
	@JoinColumn(name = "ac_id", insertable = false, updatable = false)
	Creators creators;

	@OneToOne
	@JoinColumn(name = "ac_id", insertable = false, updatable = false)
	Admins admins;

	// Getter

	public int getAccountID() {
		return accountID;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getAccountFaculty() {
		return accountFaculty;
	}

	public Creators getCreators() {
    return creators;
  }

  public Admins getAdmins() {
    return admins;
  }

  // Setter

  public void setAccountID(int accountID) {
		this.accountID = accountID;
	}

	public void setaccountUserName(String accountUsername) {
		this.username = accountUsername;
	}

	public void setAccountPassword(String accountPassword) {
		this.password = accountPassword;
	}

	public void setAccountFaculty(String accountFaculty) {
		this.accountFaculty = accountFaculty;
	}
}