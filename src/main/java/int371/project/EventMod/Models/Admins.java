package int371.project.EventMod.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
// import javax.persistence.GeneratedValue;
// import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "admins")
public class Admins {

	@Id
	// @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "admin_id")
	private int adminID;

	@Column(name = "admin_name")
	private String adminName;

	public int getAdminID() {
		return adminID;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminID(int adminID) {
		this.adminID = adminID;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

  public void setAll(Admins newAdmins) {
		this.setAdminID(newAdmins.getAdminID());
		this.setAdminName(newAdmins.getAdminName());
  }
}