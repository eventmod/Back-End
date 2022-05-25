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
@Table(name = "EventsHaveTags")
public class EventsHaveTags {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "EventTag_ID")
	private int EventTag_ID;

	@Column(name = "Ev_ID")
	private int Ev_ID;

	@Column(name = "Tag_ID")
	private int Tag_ID;

	@ManyToOne
	@JoinColumn(name = "Ev_ID", insertable = false, updatable = false)
	Events events;

	@ManyToOne
	@JoinColumn(name = "Tag_ID", insertable = false, updatable = false)
	Tags tags;

//	Getter

	public int getEventTag_ID() {
		return EventTag_ID;
	}

	// public int getEv_ID() {
	// 	return Ev_ID;
	// }

	// public int getTag_ID() {
	// 	return Tag_ID;
	// }

//	public Events getEvents() {
//		return events;
//	}
//
	public Tags getTags() {
		return tags;
	}

//	Setter

	public void setEventTag_ID(int eventTag_ID) {
		EventTag_ID = eventTag_ID;
	}

	public void setEv_ID(int ev_ID) {
		Ev_ID = ev_ID;
	}

	public void setTag_ID(int tag_ID) {
		Tag_ID = tag_ID;
	}

//	public void setEvents(Events events) {
//		this.events = events;
//	}
//
//	public void setTags(Tags tags) {
//		this.tags = tags;
//	}
}