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
	@Column(name = "event_id")
	private int eventID;

	@Column(name = "event_title")
	private String eventTitle;

	@Column(name = "event_cover")
	private String eventCover;

	@Column(name = "event_shortdescription")
	private String eventShortDescription;

	@Column(name = "event_longdescription")
	private String eventLongDescription;

	@Column(name = "event_location")
	private String eventLocation;

	@Column(name = "event_numberofpeople")
	private int eventNumberOfPeople;

	@Column(name = "event_startdate")
	private String eventStartDate;

	@Column(name = "event_enddate")
	private String eventEndDate;

	@Column(name = "event_starttime")
	private String eventStartTime;

	@Column(name = "event_endtime")
	private String eventEndTime;

	@Column(name = "event_startregistration")
	private String eventStartRegis;

	@Column(name = "event_endregistration")
	private String eventEndRegis;

	@Column(name = "event_cost")
	private int eventCost;

	@Column(name = "event_collegeyear")
	private int eventYear;

	@Column(name = "event_type")
	private String eventType;

	@Column(name = "event_note")
	private String eventNote;

	@Column(name = "ac_id")
	private int accountID;

	@OneToOne
	@JoinColumn(name = "ac_id", insertable = false, updatable = false)
	Accounts accounts;

	@OneToMany(mappedBy = "events", cascade = CascadeType.ALL, orphanRemoval = true)
	Set<EventHaveTag> eventHaveTag;

//	Getter

	public int getEventID() {
		return eventID;
	}

	public String getEventTitle() {
		return eventTitle;
	}

	public String getEventCover() {
		return eventCover;
	}

	public String getEventShortDescription() {
		return eventShortDescription;
	}

	public String getEventLongDescription() {
		return eventLongDescription;
	}

	public String getEventLocation() {
		return eventLocation;
	}

	public int getEventNumberOfPeople() {
		return eventNumberOfPeople;
	}

	public String getEventStartDate() {
		return eventStartDate;
	}

	public String getEventEndDate() {
		return eventEndDate;
	}

	public String getEventStartTime() {
		return eventStartTime;
	}

	public String getEventEndTime() {
		return eventEndTime;
	}

	public String getEventStartRegis() {
		return eventStartRegis;
	}

	public String getEventEndRegis() {
		return eventEndRegis;
	}

	public int getEventCost() {
		return eventCost;
	}

	public int getEventYear() {
		return eventYear;
	}

	public String getEventType() {
		return eventType;
	}

	public String getEventNote() {
		return eventNote;
	}

	public int getAccountID() {
		return accountID;
	}

	public Accounts getAccounts() {
		return accounts;
	}

	public Set<EventHaveTag> getEventHaveTag() {
		return eventHaveTag;
	}

//	Setter

	public void setEventID(int eventID) {
		this.eventID = eventID;
	}

	public void setEventTitle(String eventTitle) {
		this.eventTitle = eventTitle;
	}

	public void setEventCover(String eventCover) {
		this.eventCover = eventCover;
	}

	public void setEventShortDescription(String eventShortDescription) {
		this.eventShortDescription = eventShortDescription;
	}

	public void setEventLongDescription(String eventLongDescription) {
		this.eventLongDescription = eventLongDescription;
	}

	public void setEventLocation(String eventLocation) {
		this.eventLocation = eventLocation;
	}

	public void setEventNumberOfPeople(int eventNumberOfPeople) {
		this.eventNumberOfPeople = eventNumberOfPeople;
	}

	public void setEventStartDate(String eventStartDate) {
		this.eventStartDate = eventStartDate;
	}

	public void setEventEndDate(String eventEndDate) {
		this.eventEndDate = eventEndDate;
	}

	public void setEventStartTime(String eventStartTime) {
		this.eventStartTime = eventStartTime;
	}

	public void setEventEndTime(String eventEndTime) {
		this.eventEndTime = eventEndTime;
	}

	public void setEventStartRegis(String eventStartRegis) {
		this.eventStartRegis = eventStartRegis;
	}

	public void setEventEndRegis(String eventEndRegis) {
		this.eventEndRegis = eventEndRegis;
	}

	public void setEventCost(int eventCost) {
		this.eventCost = eventCost;
	}

	public void setEventYear(int eventYear) {
		this.eventYear = eventYear;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public void setEventNote(String eventNote) {
		this.eventNote = eventNote;
	}

	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}

	public void setAccounts(Accounts accounts) {
		this.accounts = accounts;
	}

	public void setEventHaveTag(Set<EventHaveTag> eventHaveTag) {
		this.eventHaveTag = eventHaveTag;
	}
}