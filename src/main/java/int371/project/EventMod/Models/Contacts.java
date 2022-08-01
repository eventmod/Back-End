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
@Table(name = "contacts")
public class Contacts {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "c_id")
	private int contactID;

	@Column(name = "c_name")
	private String contactName;

	@Column(name = "c_phone")
	private String contactPhone;

	@Column(name = "c_email")
	private String contactEmail;

	@Column(name = "event_id")
	private int eventID;

	@OneToOne
	@JoinColumn(name = "eventID", insertable = false, updatable = false)
	Events events;

	// Getter

	public int getContactID() {
		return contactID;
	}

	public String getContactName() {
		return contactName;
	}

	public String getContactPhone() {
		return contactPhone;
	}

	public String getContactEmail() {
		return contactEmail;
	}

	public int getEventID() {
		return eventID;
	}

	public Events getEvents() {
		return events;
	}

	// Setter

	public void setContactID(int contactID) {
		this.contactID = contactID;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	public void setEventID(int eventID) {
		this.eventID = eventID;
	}

	public void setEvents(Events events) {
		this.events = events;
	}
}