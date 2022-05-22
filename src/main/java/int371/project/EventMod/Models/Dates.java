package int371.project.EventMod.Models;

// import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Dates")
public class Dates {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "D_ID")
	private String D_ID;

	@Column(name = "D_SDate")
	private java.sql.Date D_SDate;

	@Column(name = "D_StDate")
	private java.sql.Date D_StDate;

	@Column(name = "Ev_ID")
	private String Ev_ID;

	@OneToOne
	@JoinColumn(name = "Ev_ID", insertable = false, updatable = false)
	Events events;

//	Getter

	public String getD_ID() {
		return D_ID;
	}

	public java.sql.Date getD_SDate() {
		return D_SDate;
	}

	public java.sql.Date getD_StDate() {
		return D_StDate;
	}

	public String getEv_ID() {
		return Ev_ID;
	}

//	Setter

	public void setD_ID(String d_ID) {
		D_ID = d_ID;
	}

	public void setD_SDate(java.sql.Date d_SDate) {
		D_SDate = d_SDate;
	}

	public void setD_StDate(java.sql.Date d_StDate) {
		D_StDate = d_StDate;
	}

	public void setEv_ID(String ev_ID) {
		Ev_ID = ev_ID;
	}
}