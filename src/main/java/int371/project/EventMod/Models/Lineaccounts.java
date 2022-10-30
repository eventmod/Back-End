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
@Table(name = "lineaccounts")
public class Lineaccounts {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "lineacc_id")
	private int lineaccID;

	@Column(name = "lineacc_userid")
	private String lineaccUserID;

	@Column(name = "lineacc_studentid")
	private String lineaccStudentID;

	@Column(name = "lineacc_kmuttmail")
	private String lineaccKmuttMail;

	@OneToMany(mappedBy = "lineaccounts", cascade = CascadeType.ALL, orphanRemoval = true)
	Set<EventsJoined> events_joined;

//	Getter

	public int getLineaccID() {
		return lineaccID;
	}

	public String getLineaccUserID() {
		return lineaccUserID;
	}

	public String getLineaccStudentID() {
		return lineaccStudentID;
	}
	
	public String getLineaccKmuttMail() {
		return lineaccKmuttMail;
	}

//	Setter

	public void setLineaccID(int lineaccID) {
		this.lineaccID = lineaccID;
	}

	public void setLineaccUserID(String lineaccUserID) {
		this.lineaccUserID = lineaccUserID;
	}

	public void setLineaccStudentID(String lineaccStudentID) {
		this.lineaccStudentID = lineaccStudentID;
	}

	public void setLineaccKmuttMail(String lineaccKmuttMail) {
		this.lineaccKmuttMail = lineaccKmuttMail;
	}

}