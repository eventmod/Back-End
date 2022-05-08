package int371.project.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Event_Have_Tags")
public class Event_Have_Tags {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "EventTag_ID")
	private String EventTag_ID;

	@Column(name = "Ev_ID")
	private String Ev_ID;

	@Column(name = "Tag_ID")
	private String Tag_ID;

	@ManyToOne
	@JoinColumn(name = "Ev_ID", insertable = false, updatable = false)
	Events events;

	@ManyToOne
	@JoinColumn(name = "Tag_ID", insertable = false, updatable = false)
	Tags tags;

//	Getter

	public String getEventTag_ID() {
		return EventTag_ID;
	}

	public String getEv_ID() {
		return Ev_ID;
	}

	public String getTag_ID() {
		return Tag_ID;
	}

//	Setter

	public void setEventTag_ID(String eventTag_ID) {
		EventTag_ID = eventTag_ID;
	}

	public void setEv_ID(String ev_ID) {
		Ev_ID = ev_ID;
	}

	public void setTag_ID(String tag_ID) {
		Tag_ID = tag_ID;
	}
}