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
@Table(name = "Tags")
public class Tags {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Tag_ID")
	private String Tag_ID;

	@Column(name = "Tag_Name")
	private String Tag_Name;
	
	@OneToMany(mappedBy = "tags", cascade = CascadeType.ALL, orphanRemoval = true)
	Set<Event_Have_Tags> event_have_tags;

//	Getter

	public String getTag_ID() {
		return Tag_ID;
	}

	public String getTag_Name() {
		return Tag_Name;
	}

//	Setter

	public void setTag_ID(String tag_ID) {
		Tag_ID = tag_ID;
	}

	public void setTag_Name(String tag_Name) {
		Tag_Name = tag_Name;
	}
}