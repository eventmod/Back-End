package int371.project.EventMod.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "eventsjoined")
public class EventsJoined {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "eventsjoined_id")
	private int eventsJoinedID;

	@Column(name = "event_id")
	private int eventID;

	@Column(name = "lineacc_id")
	private int lineaccID;

	@ManyToOne
	@JoinColumn(name = "event_id", insertable = false, updatable = false)
	Events events;

	@ManyToOne
	@JoinColumn(name = "lineacc_id", insertable = false, updatable = false)
	Lineaccounts lineaccounts;

//	Getter

		public int getEventsJoinedID() {
		return eventsJoinedID;
	}

	public int getEventID() {
		return eventID;
	}

	public int getLineaccID() {
		return lineaccID;
	}

//	Setter

	public void setEventsJoinedID(int eventsJoinedID) {
		this.eventsJoinedID = eventsJoinedID;
	}

	public void setEventID(int eventID) {
		this.eventID = eventID;
	}

	public void setLineaccID(int lineaccID) {
		this.lineaccID = lineaccID;
	}

}