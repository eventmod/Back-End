package int371.project.EventMod.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import int371.project.EventMod.Exceptions.EventsException;
import int371.project.EventMod.Exceptions.ExceptionResponse;
// import int371.project.EventMod.Models.Accounts;
import int371.project.EventMod.Models.Contacts;
// import int371.project.EventMod.Models.Events;
import int371.project.EventMod.Repositories.ContactsJpaRepository;
// import int371.project.EventMod.Repositories.EventsJpaRepository;

@CrossOrigin
@RestController
public class ContactController {

	@Autowired
	private ContactsJpaRepository contactsJpa;

	// @Autowired
	// private EventsJpaRepository eventsJpa;

////-------------------------------------------------------- GetMapping -------------------------------------------------------------------------
	// Show a list of all contacts.
	@GetMapping("/contacts")
	public List<Contacts> showAllContacts() {
		return contactsJpa.findAll();
	}

	// Show list of contacts by contactID
	@GetMapping("/contacts/{contactID}")
	public Contacts showContactByID(@PathVariable int contactID) {
		Contacts contact = this.contactsJpa.findById(contactID).orElse(null);
		if (contact == null) {
			throw new EventsException(ExceptionResponse.ERROR_CODE.CONTACT_ID_DOES_NOT_EXIST,
					"Contact ID" + " : " + contactID + " " + "does not exist");
		}
		return contact;
	}


	@GetMapping("/eventcontact/{eventID}")
	public List<Contacts> showContactByEventID(@PathVariable Integer eventID) {
		List<Contacts> contact = this.contactsJpa.findByEventID(eventID);
		if (contact == null) {
			throw new EventsException(ExceptionResponse.ERROR_CODE.EVENTS_ID_NO_CONTACT,
			"Event ID : " + eventID + "does not exist contact");			
		}
		return contact;
	}
}