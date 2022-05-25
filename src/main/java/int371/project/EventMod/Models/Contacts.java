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
@Table(name = "Contacts")
public class Contacts {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "C_ID")
	private int C_ID;

	@Column(name = "C_Name")
	private String C_Name;

	@Column(name = "C_Phone")
	private String C_Phone;

	@Column(name = "C_Email")
	private String C_Email;

	@Column(name = "Ev_ID")
	private String Ev_ID;

	@OneToOne
	@JoinColumn(name = "Ev_ID", insertable = false, updatable = false)
	Events events;

//	Getter

	public int getC_ID() {
		return C_ID;
	}

	public String getC_Name() {
		return C_Name;
	}

	public String getC_Phone() {
		return C_Phone;
	}

	public String getC_Email() {
		return C_Email;
	}

	public String getEv_ID() {
		return Ev_ID;
	}

	public Events getEvents() {
		return events;
	}

//	Setter

	public void setC_ID(int c_ID) {
		C_ID = c_ID;
	}

	public void setC_Name(String c_Name) {
		C_Name = c_Name;
	}

	public void setC_Phone(String c_Phone) {
		C_Phone = c_Phone;
	}

	public void setC_Email(String c_Email) {
		C_Email = c_Email;
	}

	public void setEv_ID(String ev_ID) {
		Ev_ID = ev_ID;
	}

	public void setEvents(Events events) {
		this.events = events;
	}
}