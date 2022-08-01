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

	@Column(name = "ac_name")
	private String accountName;

	@Column(name = "ac_description")
	private String accountDescription;

	@Column(name = "ac_faculty")
	private String accountFaculty;

	@OneToOne
	@JoinColumn(name = "creator_id", insertable = false, updatable = false)
	Creators creators;

	@OneToOne
	@JoinColumn(name = "admin_id", insertable = false, updatable = false)
	Admins admins;

	// Getter

	public int getAccountID() {
		return accountID;
	}

	public String getAccountName() {
		return accountName;
	}

	public String getAccountDescription() {
		return accountDescription;
	}

	public String getAccountFaculty() {
		return accountFaculty;
	}

	// Setter

	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public void setAccountDescription(String accountDescription) {
		this.accountDescription = accountDescription;
	}

	public void setAccountFaculty(String accountFaculty) {
		this.accountFaculty = accountFaculty;
	}
}