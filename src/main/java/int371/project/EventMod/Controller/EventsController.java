package int371.project.EventMod.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import int371.project.EventMod.Exceptions.EventsException;
import int371.project.EventMod.Exceptions.ExceptionResponse;
import int371.project.EventMod.Models.Events;
import int371.project.EventMod.Repositories.EventsJpaRepository;

public class EventsController {
	@Autowired
	private EventsJpaRepository eventsJpa;

//	final StorageService storageService;
//
//	@Autowired
//	public EventsController(StorageService storageService) {
//		this.storageService = storageService;
//	}

////---------------------------------- GetMapping ----------------------------------
	// Show a list of all events.
	@GetMapping("/events")
	public List<Events> showAllEvents() {
		return eventsJpa.findAll();
	}

	// Show list of events by Ev_ID (test POSTMAN)
	@GetMapping("/events/{Ev_ID}")
	public Events showEventByID(@PathVariable String Ev_ID) {
		Events event = this.eventsJpa.findById(Ev_ID).orElse(null);
		if (event == null) {
			throw new EventsException(ExceptionResponse.ERROR_CODE.EVENTS_ID_DOES_NOT_EXIST,
					"Event ID : " + Ev_ID + " does not exist ");
		}
		return event;
	}

	// Show list of events by Ev_Name
	@GetMapping("/events/{Ev_Name}")
	public Events showEventByName(@PathVariable String Ev_Name) {
		Events event = this.eventsJpa.findById(Ev_Name).orElse(null);
		if (event == null) {
			throw new EventsException(ExceptionResponse.ERROR_CODE.EVENTS_NAME_DOES_NOT_EXIST,
					"Event Name : " + Ev_Name + " does not exist ");
		}
		return event;
	}
}