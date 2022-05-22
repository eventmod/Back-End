package int371.project.EventMod.Models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Events")
public class Events {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Ev_ID")
	private String Ev_ID;

	@Column(name = "Ev_Name")
	private String Ev_Name;

	@Column(name = "Ev_Cover")
	private String Ev_Cover;

	@Column(name = "Ev_Description")
	private String Ev_Description;

	@Column(name = "Ev_Location")
	private String Ev_Location;

	@Column(name = "Ev_Gender")
	private String Ev_Gender;

	@Column(name = "Ev_NumberOfPeople")
	private int Ev_NumberOfPeople;

	@Column(name = "Ev_Year")
	private String Ev_Year;

	@Column(name = "Ac_ID")
	private String Ac_ID;

	@Column(name = "D_ID")
	private String D_ID;

	@Column(name = "C_ID")
	private String C_ID;

	@OneToOne
	@JoinColumn(name = "Ac_ID", insertable = false, updatable = false)
	Accounts accounts;

	@OneToOne
	@JoinColumn(name = "D_ID", insertable = false, updatable = false)
	Dates dates;

	@OneToOne
	@JoinColumn(name = "C_ID", insertable = false, updatable = false)
	Contacts contacts;

	@OneToMany(mappedBy = "events", cascade = CascadeType.ALL, orphanRemoval = true)
	Set<Event_Have_Tags> event_have_tags;

//	Getter

	public String getEv_ID() {
		return Ev_ID;
	}

	public String getEv_Name() {
		return Ev_Name;
	}

	public String getEv_Cover() {
		return Ev_Cover;
	}

	public String getEv_Description() {
		return Ev_Description;
	}

	public String getEv_Location() {
		return Ev_Location;
	}

	public String getEv_Gender() {
		return Ev_Gender;
	}

	public int getEv_NumberOfPeople() {
		return Ev_NumberOfPeople;
	}

	public String getEv_Year() {
		return Ev_Year;
	}

	public String getAc_ID() {
		return Ac_ID;
	}

	public String getD_ID() {
		return D_ID;
	}

	public String getC_ID() {
		return C_ID;
	}

//	Setter

	public void setEv_ID(String ev_ID) {
		Ev_ID = ev_ID;
	}

	public void setEv_Name(String ev_Name) {
		Ev_Name = ev_Name;
	}

	public void setEv_Cover(String ev_Cover) {
		Ev_Cover = ev_Cover;
	}

	public void setEv_Description(String ev_Description) {
		Ev_Description = ev_Description;
	}

	public void setEv_Location(String ev_Location) {
		Ev_Location = ev_Location;
	}

	public void setEv_Gender(String ev_Gender) {
		Ev_Gender = ev_Gender;
	}

	public void setEv_NumberOfPeople(int ev_NumberOfPeople) {
		Ev_NumberOfPeople = ev_NumberOfPeople;
	}

	public void setEv_Year(String ev_Year) {
		Ev_Year = ev_Year;
	}

	public void setAc_ID(String ac_ID) {
		Ac_ID = ac_ID;
	}

	public void setD_ID(String d_ID) {
		D_ID = d_ID;
	}

	public void setC_ID(String c_ID) {
		C_ID = c_ID;
	}
}