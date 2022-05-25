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
	private int Ev_ID;

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

	@Column(name = "Ev_StartRegis")
	private String Ev_StartRegis;

	@Column(name = "Ev_EndRegis")
	private String Ev_EndRegis;

	@Column(name = "Ac_ID")
	private String Ac_ID;

	@OneToOne
	@JoinColumn(name = "Ac_ID", insertable = false, updatable = false)
	Accounts accounts;

	@OneToMany(mappedBy = "events", cascade = CascadeType.ALL, orphanRemoval = true)
	Set<EventsHaveTags> event_have_tags;

//	Getter

	public int getEv_ID() {
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

	public String getEv_StartRegis() {
		return Ev_StartRegis;
	}

	public String getEv_EndRegis() {
		return Ev_EndRegis;
	}

	public String getAc_ID() {
		return Ac_ID;
	}

	public Accounts getAccounts() {
		return accounts;
	}

//	Setter

	public Set<EventsHaveTags> getEvent_have_tags() {
		return event_have_tags;
	}

	public void setEv_ID(int ev_ID) {
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

	public void setEv_StartRegis(String ev_StartRegis) {
		Ev_StartRegis = ev_StartRegis;
	}

	public void setEv_EndRegis(String ev_EndRegis) {
		Ev_EndRegis = ev_EndRegis;
	}

	public void setAc_ID(String ac_ID) {
		Ac_ID = ac_ID;
	}

	public void setAccounts(Accounts accounts) {
		this.accounts = accounts;
	}

	public void setEvent_have_tags(Set<EventsHaveTags> event_have_tags) {
		this.event_have_tags = event_have_tags;
	}
}