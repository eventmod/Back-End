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
@Table(name = "dates")
public class Dates {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "d_id")
	private int dateID;

	@Column(name = "d_startdate")
	private java.sql.Date dateStartDate;

	@Column(name = "d_enddate")
	private java.sql.Date dateEndDate;

	@Column(name = "ev_id")
	private int eventID;

	@OneToOne
	@JoinColumn(name = "eventID", insertable = false, updatable = false)
	Events events;

	// Getter

	public int getDateID() {
		return dateID;
	}

	public java.sql.Date getDateStartDate() {
		return dateStartDate;
	}

	public java.sql.Date getDateEndDate() {
		return dateEndDate;
	}

	public int getEventID() {
		return eventID;
	}

	public Events getEvents() {
		return events;
	}

	// Setter

	public void setDateID(int dateID) {
		this.dateID = dateID;
	}

	public void setDateStartDate(java.sql.Date dateStartDate) {
		this.dateStartDate = dateStartDate;
	}

	public void setDateEndDate(java.sql.Date dateEndDate) {
		this.dateEndDate = dateEndDate;
	}

	public void setEventID(int eventID) {
		this.eventID = eventID;
	}

	public void setEvents(Events events) {
		this.events = events;
	}
}