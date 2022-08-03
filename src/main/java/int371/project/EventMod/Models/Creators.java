package int371.project.EventMod.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "creators")
public class Creators {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "creator_id")
	private int creatorID;
	
	@Column(name = "creator_name")
	private int creatorName;

	@Column(name = "creator_logo")
	private String creatorLogo;

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
}