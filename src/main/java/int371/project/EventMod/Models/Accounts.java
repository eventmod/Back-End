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
	private String Ac_ID;

	@Column(name = "Ac_Name")
	private String Ac_Name;

	@Column(name = "Ac_Description")
	private String Ac_Description;

	@Column(name = "R_ID")
	private String R_ID;

	@Column(name = "F_ID")
	private String F_ID;

	@OneToOne
	@JoinColumn(name = "R_ID", insertable = false, updatable = false)
	Roles roles;

	@OneToOne
	@JoinColumn(name = "F_ID", insertable = false, updatable = false)
	Facultys facultys;

//	Getter

	public String getAc_ID() {
		return Ac_ID;
	}

	public String getAc_Name() {
		return Ac_Name;
	}

	public String getAc_Description() {
		return Ac_Description;
	}

	public String getR_ID() {
		return R_ID;
	}

	public String getF_ID() {
		return F_ID;
	}

	public Facultys getFacultys() {
		return facultys;
	}

	public Roles getRoles() {
		return roles;
	}

//	Setter

	public void setAc_ID(String ac_ID) {
		Ac_ID = ac_ID;
	}

	public void setAc_Name(String ac_Name) {
		Ac_Name = ac_Name;
	}

	public void setAc_Description(String ac_Description) {
		Ac_Description = ac_Description;
	}

	public void setR_ID(String r_ID) {
		R_ID = r_ID;
	}

	public void setF_ID(String f_ID) {
		F_ID = f_ID;
	}

	public void setFacultys(Facultys facultys) {
		this.facultys = facultys;
	}

	public void setRoles(Roles roles) {
		this.roles = roles;
	}
}