package int371.project.EventMod.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import int371.project.EventMod.Repositories.ContactsJpaRepository;

@CrossOrigin
@RestController
public class ContactsController {

	@Autowired
	private ContactsJpaRepository contactsJpa;

////-------------------------------------------------------- GetMapping -------------------------------------------------------------------------
	// Show a list of all contacts.
	// Show list of contacts by contactID
}