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
import int371.project.EventMod.Models.EventHaveTag;
import int371.project.EventMod.Repositories.EventHaveTagJpaRepository;

@CrossOrigin
@RestController
public class EventHaveTagController {
  @Autowired
  private EventHaveTagJpaRepository eventHaveTagJpaRepository;

  /* ------------------- GET MAPPING ------------------- */
  @GetMapping("/eventtags")
  public List<EventHaveTag> showAllEventTags () {
    return eventHaveTagJpaRepository.findAll();
  }

  @GetMapping("/eventtag/{id}")
  public EventHaveTag showTagByID (@PathVariable int eventTagID) {
    EventHaveTag eventTag = this.eventHaveTagJpaRepository.findById(eventTagID).orElse(null);
		if (eventTag == null) {
			throw new EventsException(ExceptionResponse.ERROR_CODE.EVENTTAG_ID_DOES_NOT_EXIST,
					"EventTag ID" + " : " + eventTagID + " " + "does not exist");
		}
		return eventTag;
  }

  /* ------------------- POST MAPPING ------------------- */
  @PostMapping("/newTagInEvent")
  public void newTagInEvent (@RequestBody EventHaveTag newTagInEvent) throws Exception {
    eventHaveTagJpaRepository.save(newTagInEvent);
  }

  /* ------------------- DELETE MAPPING ------------------- */
  @DeleteMapping("/delTagOfEvent")
  public void delEventTag (@RequestParam("eventTagID") int eventTagID) {
    eventHaveTagJpaRepository.deleteById(eventTagID);
  }
}
