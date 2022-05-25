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
	private int D_ID;

	@Column(name = "D_StartDate")
	private java.sql.Date D_StartDate;

	@Column(name = "D_EndDate")
	private java.sql.Date D_EndDate;

	@Column(name = "Ev_ID")
	private int Ev_ID;

	@OneToOne
	@JoinColumn(name = "Ev_ID", insertable = false, updatable = false)
	Events events;

//	Getter

	public int getD_ID() {
		return D_ID;
	}

	public java.sql.Date getD_StartDate() {
		return D_StartDate;
	}

	public java.sql.Date getD_EndDate() {
		return D_EndDate;
	}

	public int getEv_ID() {
		return Ev_ID;
	}

	public Events getEvents() {
		return events;
	}

//	Setter

	public void setD_ID(int d_ID) {
		D_ID = d_ID;
	}

	public void setD_StartDate(java.sql.Date d_StartDate) {
		D_StartDate = d_StartDate;
	}

	public void setD_EndDate(java.sql.Date d_EndDate) {
		D_EndDate = d_EndDate;
	}

	public void setEv_ID(int ev_ID) {
		Ev_ID = ev_ID;
	}

	public void setEvents(Events events) {
		this.events = events;
	}
}