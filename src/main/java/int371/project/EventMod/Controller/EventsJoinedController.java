package int371.project.EventMod.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import int371.project.EventMod.Exceptions.EventsException;
import int371.project.EventMod.Exceptions.ExceptionResponse;
import int371.project.EventMod.Models.EventsJoined;
import int371.project.EventMod.Repositories.EventsJoinedJpaRepository;

@CrossOrigin
@RestController
public class EventsJoinedController {
  @Autowired
  private EventsJoinedJpaRepository eventsJoinedJpaRepository;

  /* ------------------- GET MAPPING ------------------- */
  @GetMapping("/eventsjoined")
  public List<EventsJoined> showAllEventsJoined () {
    return eventsJoinedJpaRepository.findAll();
  }

  @GetMapping("/eventjoined/{id}")
  public EventsJoined showEventJoinedByID (@PathVariable int eventJoinedID) {
    EventsJoined eventJoined = this.eventsJoinedJpaRepository.findById(eventJoinedID).orElse(null);
		if (eventJoined == null) {
			throw new EventsException(ExceptionResponse.ERROR_CODE.EVENTJOINED_ID_DOES_NOT_EXIST,
					"EventJoined ID" + " : " + eventJoinedID + " " + "does not exist");
		}
		return eventJoined;
  }

  @GetMapping("/findJoinedByEventID/{eventid}")
  public List<EventsJoined> showLineaccountByEventID (@PathVariable int eventid) {
    return this.eventsJoinedJpaRepository.findByEventsID(eventid);
  }

  /* ------------------- POST MAPPING ------------------- */
  @PostMapping("/newLineaccountInEvent")
  public void newLineaccountInEvent (@RequestBody EventsJoined newLineaccountInEvent) throws Exception {
    eventsJoinedJpaRepository.save(newLineaccountInEvent);
  }

  /* ------------------- DELETE MAPPING ------------------- */
  @DeleteMapping("/delJoinedOfEvent")
  public void delEventJoined (@RequestParam("eventJoinedID") int eventJoinedID) {
    eventsJoinedJpaRepository.deleteById(eventJoinedID);
  }
}
