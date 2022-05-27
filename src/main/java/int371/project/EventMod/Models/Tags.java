package int371.project.EventMod.Models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tags")
public class Tags {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tag_id")
	private int tagID;

	@Column(name = "tag_name")
	private String tagName;

	@OneToMany(mappedBy = "tags", cascade = CascadeType.ALL, orphanRemoval = true)
	Set<EventsHaveTags> event_have_tags;

//	Getter

	public int getTagID() {
		return tagID;
	}

	public String getTagName() {
		return tagName;
	}

	// public Set<EventsHaveTags> getEvent_have_tags() {
	// 	return event_have_tags;
	// }

//	Setter

	public void setTagID(int tag_ID) {
		tagID = tag_ID;
	}

	public void setTagName(String tag_Name) {
		tagName = tag_Name;
	}

	public void setEventHaveTags(Set<EventsHaveTags> event_have_tags) {
		this.event_have_tags = event_have_tags;
	}
}