package int371.project.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Roles")
public class Roles {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "R_ID")
	private String R_ID;

	@Column(name = "R_Name")
	private String R_Name;

	@Column(name = "Ac_ID")
	private String Ac_ID;

	@OneToMany
	@JoinColumn(name = "Ac_ID", insertable = false, updatable = false)
	Accounts accounts;

//	Getter

	public String getR_ID() {
		return R_ID;
	}

	public String getR_Name() {
		return R_Name;
	}

	public String getAc_ID() {
		return Ac_ID;
	}

	public Accounts getAccounts() {
		return accounts;
	}

//	Setter

	public void setR_ID(String r_ID) {
		R_ID = r_ID;
	}

	public void setR_Name(String r_Name) {
		R_Name = r_Name;
	}

	public void setAc_ID(String ac_ID) {
		Ac_ID = ac_ID;
	}

	public void setAccounts(Accounts accounts) {
		this.accounts = accounts;
	}
}