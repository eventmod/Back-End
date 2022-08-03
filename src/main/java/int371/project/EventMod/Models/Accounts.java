package int371.project.EventMod.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "accounts")
public class Accounts {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ac_id")
	private int accountID;

	@Column(name = "ac_username")
	private String accountUserName;

	@Column(name = "ac_password")
	private String accountPassword;

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

	public String getaccountUserName() {
		return accountUserName;
	}

	public String getAccountPassword() {
		return accountPassword;
	}

	public String getAccountFaculty() {
		return accountFaculty;
	}

	// Setter

	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}

	public void setaccountUserName(String accountUserName) {
		this.accountUserName = accountUserName;
	}

	public void setAccountPassword(String accountPassword) {
		this.accountPassword = accountPassword;
	}

	public void setAccountFaculty(String accountFaculty) {
		this.accountFaculty = accountFaculty;
	}
}