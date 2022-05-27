package int371.project.EventMod.Models;

import java.sql.*;
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
@Table(name = "events")
public class Events {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ev_id")
	private int eventID;

	@Column(name = "ev_name")
	private String eventName;

	@Column(name = "ev_cover")
	private String eventCover;

	@Column(name = "ev_description")
	private String eventDescription;

	@Column(name = "ev_location")
	private String eventLocation;

	@Column(name = "ev_gender")
	private String eventGender;

	@Column(name = "ev_numberofpeople")
	private int eventNumberOfPeople;

	@Column(name = "ev_year")
	private String eventYear;

	@Column(name = "ev_startregis")
	private Timestamp eventStartRegis;

	@Column(name = "ev_endregis")
	private Timestamp eventEndRegis;

	@Column(name = "ac_id")
	private int accountID;

	@OneToOne
	@JoinColumn(name = "Ac_ID", insertable = false, updatable = false)
	Accounts accounts;

	@OneToMany(mappedBy = "events", cascade = CascadeType.ALL, orphanRemoval = true)
	Set<EventsHaveTags> eventHaveTags;

//	Getter

	public int getEventID() {
		return eventID;
	}

	public String getEventName() {
		return eventName;
	}

	public String getEventCover() {
		return eventCover;
	}

	public String getEventDescription() {
		return eventDescription;
	}

	public String getEventLocation() {
		return eventLocation;
	}

	public String getEventGender() {
		return eventGender;
	}

	public int getEventNumberOfPeople() {
		return eventNumberOfPeople;
	}

	public String getEventYear() {
		return eventYear;
	}

	public Timestamp getEventStartRegis() {
		return eventStartRegis;
	}

	public Timestamp getEventEndRegis() {
		return eventEndRegis;
	}

	// public String getaccountID() {
	// return accountID;
	// }

	public Accounts getAccounts() {
		return accounts;
	}

//	Setter

	public Set<EventsHaveTags> getEventHaveTags() {
		return eventHaveTags;
	}

	public void setEventID(int ev_ID) {
		eventID = ev_ID;
	}

	public void setEventName(String ev_Name) {
		eventName = ev_Name;
	}

	public void setEventCover(String ev_Cover) {
		eventCover = ev_Cover;
	}

	public void setEventDescription(String ev_Description) {
		eventDescription = ev_Description;
	}

	public void setEventLocation(String ev_Location) {
		eventLocation = ev_Location;
	}

	public void setEventGender(String ev_Gender) {
		eventGender = ev_Gender;
	}

	public void setEventNumberOfPeople(int ev_NumberOfPeople) {
		eventNumberOfPeople = ev_NumberOfPeople;
	}

	public void setEventYear(String ev_Year) {
		eventYear = ev_Year;
	}

	public void setEventStartRegis(Timestamp ev_StartRegis) {
		eventStartRegis = ev_StartRegis;
	}

	public void setEventEndRegis(Timestamp ev_EndRegis) {
		eventEndRegis = ev_EndRegis;
	}

	public void setAccountID(int ac_ID) {
		accountID = ac_ID;
	}

	public void setAccounts(Accounts accounts) {
		this.accounts = accounts;
	}

	public void setEventHaveTags(Set<EventsHaveTags> eventhavetags) {
		this.eventHaveTags = eventhavetags;
	}
}