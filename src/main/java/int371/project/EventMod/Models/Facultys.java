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
@Table(name = "Facultys")
public class Facultys {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "F_ID")
	private String F_ID;

	@Column(name = "F_Name")
	private String F_Name;

	@Column(name = "Ac_ID")
	private String Ac_ID;

	@OneToOne
	@JoinColumn(name = "Ac_ID", insertable = false, updatable = false)
	Accounts accounts;

//	Getter

	public String getF_ID() {
		return F_ID;
	}

	public String getF_Name() {
		return F_Name;
	}

	public String getAc_ID() {
		return Ac_ID;
	}

	public Accounts getAccounts() {
		return accounts;
	}

//	Setter

	public void setF_ID(String f_ID) {
		F_ID = f_ID;
	}

	public void setF_Name(String f_Name) {
		F_Name = f_Name;
	}

	public void setAc_ID(String ac_ID) {
		Ac_ID = ac_ID;
	}

	public void setAccounts(Accounts accounts) {
		this.accounts = accounts;
	}
}