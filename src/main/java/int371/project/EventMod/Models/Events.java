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

	@Column(name = "event_location")
	private String eventLocation;

	@Column(name = "event_datetime")
	private String eventDateTime;

	@Column(name = "event_numberofpeople")
	private int eventNumberOfPeople;

	@Column(name = "event_datetimeregistration")
	private String eventStartRegis;

	@Column(name = "event_endregistration")
	private String eventEndRegis;

	@Column(name = "event_cost")
	private int eventCost;

	@Column(name = "event_collegeyear")
	private int eventYear;

	@Column(name = "event_type")
	private String eventType;

	@Column(name = "event_longdescription")
	private String eventLongDescription;

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

	public String getEventLocation() {
		return eventLocation;
	}

	public String getEventDateTime() {
		return eventDateTime;
	}

	public int getEventNumberOfPeople() {
		return eventNumberOfPeople;
	}

	public String getEventStartRegis() {
		return eventStartRegis;
	}

	public int getEventCost() {
		return eventCost;
	}

	public int getEventYear() {
		return eventYear;
	}

	public String getEventEndRegis() {
		return eventEndRegis;
	}

	public String getEventType() {
		return eventType;
	}

	public String getEventLongDescription() {
		return eventLongDescription;
	}

	public int getAccountID() {
		return accountID;
	}

	public Accounts getAccounts() {
		return accounts;
	}

//	Setter

	public Set<EventHaveTag> getEventHaveTags() {
		return eventHaveTag;
	}

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

	public void setEventLocation(String eventLocation) {
		this.eventLocation = eventLocation;
	}

	public void setEventDateTime(String eventDateTime) {
		this.eventDateTime = eventDateTime;
	}

	public void setEventNumberOfPeople(int eventNumberOfPeople) {
		this.eventNumberOfPeople = eventNumberOfPeople;
	}

	public void setEventStartRegis(String eventStartRegis) {
		this.eventStartRegis = eventStartRegis;
	}

	public void setEventCost(int eventCost) {
		this.eventCost = eventCost;
	}

	public void setEventYear(int eventYear) {
		this.eventYear = eventYear;
	}

	public void setEventEndRegis(String eventEndRegis) {
		this.eventEndRegis = eventEndRegis;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public void setEventLongDescription(String eventLongDescription) {
		this.eventLongDescription = eventLongDescription;
	}

	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}

	public void setAccounts(Accounts accounts) {
		this.accounts = accounts;
	}

	public void setEventHaveTags(Set<EventHaveTag> eventHaveTag) {
		this.eventHaveTag = eventHaveTag;
	}
}