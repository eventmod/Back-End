package int371.project.EventMod.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import int371.project.EventMod.Exceptions.EventsException;
import int371.project.EventMod.Exceptions.ExceptionResponse;
import int371.project.EventMod.Models.Tags;
import int371.project.EventMod.Repositories.TagsJpaRepository;

@CrossOrigin
@RestController
public class TagController {
  
  @Autowired
  private TagsJpaRepository tagsJpaRepository;

  /* ------------------- GET MAPPING ------------------- */
  @GetMapping("/tags")
  public List<Tags> showAllTags () {
    return tagsJpaRepository.findAll();
  }

  @GetMapping("/tag/{id}")
  public Tags showTagByID (@PathVariable int tagID) {
    Tags tag = this.tagsJpaRepository.findById(tagID).orElse(null);
		if (tag == null) {
			throw new EventsException(ExceptionResponse.ERROR_CODE.TAG_ID_DOES_NOT_EXIST,
					"Tag ID" + " : " + tagID + " " + "does not exist");
		}
		return tag;
  }

  /* ------------------- POST MAPPING ------------------- */
  @PostMapping("/newTag")
  public void newTag (@RequestBody Tags newTag) throws Exception {
    tagsJpaRepository.save(newTag);
  }

  /* ------------------- PUT MAPPING ------------------- */
  @PutMapping("/updateTagDetail")
  public void updateTag (@RequestBody Tags newTag) throws Exception {
    Tags tag = tagsJpaRepository.findById(newTag.getTagID()).orElse(null);
    if (tag == null) {
			throw new EventsException(ExceptionResponse.ERROR_CODE.TAG_ID_DOES_NOT_EXIST,
					"Tag ID" + " : " + newTag.getTagID() + " " + "does not exist");
		} else {
    tag.setTagID(newTag.getTagID());
    tag.setTagName(newTag.getTagName());
    tagsJpaRepository.save(tag);
    }
  }


  /* ------------------- DELETE MAPPING ------------------- */
  @DeleteMapping("/delTag")
  public void delTag (@RequestParam("tagID") int tagID) {
    tagsJpaRepository.deleteById(tagID);
  }

}
