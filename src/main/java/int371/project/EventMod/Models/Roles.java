package int371.project.EventMod.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
// import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class Roles {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "r_id")
	private int roleID;

	@Column(name = "r_name")
	private String roleName;

//	Getter

	public int getRoleID() {
		return roleID;
	}

	public String getRoleName() {
		return roleName;
	}

//	Setter

	public void setRoleID(int r_ID) {
		roleID = r_ID;
	}

	public void setRoleName(String r_Name) {
		roleName = r_Name;
	}
}