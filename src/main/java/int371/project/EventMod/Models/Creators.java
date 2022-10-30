package int371.project.EventMod.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
// import javax.persistence.GeneratedValue;
// import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "creators")
public class Creators {

	@Id
	// @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "creator_id")
	private int creatorID;
	
	@Column(name = "creator_name")
	private String creatorName;

	@Column(name = "creator_description")
	private String creatorDescription;

	@Column(name = "creator_type")
	private String creatorType;

	@Column(name = "creator_leadname")
	private String creatorLeadName;

	@Column(name = "creator_leadmajor")
	private String creatorLeadMajor;

	@Column(name = "creator_advname")
	private String creatorAdvName;

	@Column(name = "creator_advposition")
	private String creatorAdvPosition;

	public int getCreatorID() {
		return creatorID;
	}

	public String getCreatorName() {
		return creatorName;
	}

	public String getCreatorDescription() {
		return creatorDescription;
	}

	public String getCreatorType() {
		return creatorType;
	}

	public String getCreatorLeadName() {
		return creatorLeadName;
	}

	public String getCreatorLeadMajor() {
		return creatorLeadMajor;
	}

	public String getCreatorAdvName() {
		return creatorAdvName;
	}

	public String getCreatorAdvPosition() {
		return creatorAdvPosition;
	}

	public void setCreatorID(int creatorID) {
		this.creatorID = creatorID;
	}

	public void setCreatorName(String creatorName) {
		this.creatorName = creatorName;
	}

	public void setCreatorDescription(String creatorDescription) {
		this.creatorDescription = creatorDescription;
	}

	public void setCreatorType(String creatorType) {
		this.creatorType = creatorType;
	}

	public void setCreatorLeadName(String creatorLeadName) {
		this.creatorLeadName = creatorLeadName;
	}

	public void setCreatorLeadMajor(String creatorLeadMajor) {
		this.creatorLeadMajor = creatorLeadMajor;
	}

	public void setCreatorAdvName(String creatorAdvName) {
		this.creatorAdvName = creatorAdvName;
	}

	public void setCreatorAdvPosition(String creatorAdvPosition) {
		this.creatorAdvPosition = creatorAdvPosition;
	}

  public void setAll(Creators newCreator) {
		this.setCreatorID(newCreator.getCreatorID());
		this.setCreatorName(newCreator.getCreatorName());
		this.setCreatorDescription(newCreator.getCreatorDescription());
		this.setCreatorType(newCreator.getCreatorType());
		this.setCreatorLeadName(newCreator.getCreatorLeadName());
		this.setCreatorLeadMajor(newCreator.getCreatorLeadMajor());
		this.setCreatorAdvName(newCreator.getCreatorAdvName());
		this.setCreatorAdvPosition(newCreator.getCreatorAdvPosition());
  }

	
}

