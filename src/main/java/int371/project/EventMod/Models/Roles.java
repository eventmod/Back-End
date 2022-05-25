package int371.project.EventMod.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
// import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Roles")
public class Roles {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "R_ID")
	private int R_ID;

	@Column(name = "R_Name")
	private String R_Name;

//	Getter

	public int getR_ID() {
		return R_ID;
	}

	public String getR_Name() {
		return R_Name;
	}

//	Setter

	public void setR_ID(int r_ID) {
		R_ID = r_ID;
	}

	public void setR_Name(String r_Name) {
		R_Name = r_Name;
	}
}