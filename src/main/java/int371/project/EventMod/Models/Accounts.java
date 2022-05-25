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
@Table(name = "Accounts")
public class Accounts {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Ac_ID")
	private int Ac_ID;

	@Column(name = "Ac_Name")
	private String Ac_Name;

	@Column(name = "Ac_Description")
	private String Ac_Description;

	@Column(name = "Ac_Faculty")
	private String Ac_Faculty;

	@Column(name = "R_ID")
	private String R_ID;

	@OneToOne
	@JoinColumn(name = "R_ID", insertable = false, updatable = false)
	Roles roles;

//	Getter

	public int getAc_ID() {
		return Ac_ID;
	}

	public String getAc_Name() {
		return Ac_Name;
	}

	public String getAc_Description() {
		return Ac_Description;
	}

	public String getAc_Faculty() {
		return Ac_Faculty;
	}

	public String getR_ID() {
		return R_ID;
	}

	public Roles getRoles() {
		return roles;
	}

//	Setter

	public void setAc_ID(int ac_ID) {
		Ac_ID = ac_ID;
	}

	public void setAc_Name(String ac_Name) {
		Ac_Name = ac_Name;
	}

	public void setAc_Description(String ac_Description) {
		Ac_Description = ac_Description;
	}

	public void setAc_Faculty(String ac_Faculty) {
		Ac_Faculty = ac_Faculty;
	}

	public void setR_ID(String r_ID) {
		R_ID = r_ID;
	}

	public void setRoles(Roles roles) {
		this.roles = roles;
	}
}