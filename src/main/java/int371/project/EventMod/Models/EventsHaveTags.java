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
@Table(name = "eventshavetags")
public class EventsHaveTags {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "eventtag_id")
	private int eventTagID;

	@Column(name = "event_id")
	private int eventID;

	@Column(name = "tag_id")
	private int tagID;

	@ManyToOne
	@JoinColumn(name = "event_id", insertable = false, updatable = false)
	Events events;

	@ManyToOne
	@JoinColumn(name = "tag_id", insertable = false, updatable = false)
	Tags tags;

//	Getter

	public int getEventTagID() {
		return eventTagID;
	}

	// public int getEv_ID() {
	// return Ev_ID;
	// }

	// public int getTag_ID() {
	// return Tag_ID;
	// }

//	public Events getEvents() {
//		return events;
//	}
//
	public Tags getTags() {
		return tags;
	}

//	Setter

	public void setEventTagID(int eventTag_ID) {
		eventTagID = eventTag_ID;
	}

	public void setEventID(int ev_ID) {
		eventID = ev_ID;
	}

	public void setTagID(int tag_ID) {
		tagID = tag_ID;
	}

//	public void setEvents(Events events) {
//		this.events = events;
//	}
//
//	public void setTags(Tags tags) {
//		this.tags = tags;
//	}
}