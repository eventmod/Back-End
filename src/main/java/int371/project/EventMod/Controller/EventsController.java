package int371.project.EventMod.Controller;

import java.util.List;

import com.google.gson.Gson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import int371.project.EventMod.Exceptions.EventsException;
import int371.project.EventMod.Exceptions.ExceptionResponse;
import int371.project.EventMod.Models.Events;
import int371.project.EventMod.Repositories.EventsJpaRepository;
import int371.project.EventMod.Service.StorageService;

@CrossOrigin
@RestController
public class EventsController {
	@Autowired
	private EventsJpaRepository eventsJpa;

	final StorageService storageService;

	@Autowired
	public EventsController(StorageService storageService) {
		this.storageService = storageService;
	}

////-------------------------------------------------------- GetMapping -------------------------------------------------------------------------
	// Show a list of all events.
	@GetMapping("/events")
	public List<Events> showAllEvents() {
		return eventsJpa.findAll();
	}

	// Show list of events by eventID
	@GetMapping("/events/{eventID}")
	public Events showEventByID(@PathVariable int eventID) {
		Events event = this.eventsJpa.findById(eventID).orElse(null);
		if (event == null) {
			throw new EventsException(ExceptionResponse.ERROR_CODE.EVENTS_ID_DOES_NOT_EXIST,
					"Event ID" + " : " + eventID + " " + "does not exist");
		}
		return event;
	}

	// Browse Images Files
	@GetMapping(value = "/Files/{filename:.+}", produces = MediaType.IMAGE_JPEG_VALUE)
	public Resource serveProduct(@PathVariable String filename) {
		return storageService.loadAsResource(filename);
	}

//  ----------------------------------------------------------- PostMapping --------------------------------------------------------------------

	// Add Cover Image
	@PostMapping("/uploadImage")
	public String handleFileUpload(@RequestParam("file") MultipartFile file) {
		storageService.store(file);
		return file.getOriginalFilename() + " " + "Upload Complete";
	}

	// Add Event with Img
	@PostMapping("/addEventWithImage")
	public void createEventWithImage(@RequestParam("event") String newEvent, @RequestParam("file") MultipartFile file) {
		Events event = new Gson().fromJson(newEvent, Events.class);
		List<Events> checkDuplicateEventName = this.eventsJpa.findAllByEventTitle(event.getEventTitle());
		if (checkDuplicateEventName.size() == 0) {
			this.eventsJpa.save(event);
			handleFileUpload(file);
		} else {
			throw new EventsException(ExceptionResponse.ERROR_CODE.EVENTS_NAME_ALREADY_EXIST,
					"Event name" + event.getEventTitle() + "already exist");
		}
	}

//  ---------------------------------------------------------DeleteMapping--------------------------------------------------------------------

//  -----------------------------------------------------------PutMapping-----------------------------------------------------------------------

}