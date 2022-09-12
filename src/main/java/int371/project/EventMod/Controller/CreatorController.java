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
import int371.project.EventMod.Models.Creators;
import int371.project.EventMod.Repositories.CreatorsJpaRepository;
import int371.project.EventMod.Service.StorageService;

@CrossOrigin
@RestController
public class CreatorController {
  
  @Autowired
  private CreatorsJpaRepository creatorsJpaRepository;

  final StorageService storageService;

  @Autowired
	public CreatorController(StorageService storageService) {
		this.storageService = storageService;
	}
  

  /* ------------------- GET MAPPING ------------------- */
  @GetMapping("/creators")
  public List<Creators> showAllCreators () {
    return creatorsJpaRepository.findAll();
  }

  @GetMapping("/creator/{id}")
  public Creators showCreatorsByID (@PathVariable int creatorsID) {
    Creators creators = this.creatorsJpaRepository.findById(creatorsID).orElse(null);
		if (creators == null) {
			throw new EventsException(ExceptionResponse.ERROR_CODE.ADMIN_ID_DOES_NOT_EXIST,
					"Creator ID" + " : " + creatorsID + " " + "does not exist");
		}
		return creators;
  }

  /* ------------------- POST MAPPING ------------------- */
  @PostMapping("/newCreator")
  public void newCreators (@RequestBody Creators newCreators) throws Exception {
    creatorsJpaRepository.save(newCreators);
  }

  /* ------------------- PUT MAPPING ------------------- */
  @PutMapping("/updateCreatorDetail")
  public void updateCreator (@RequestBody Creators newCreators) throws Exception {
    Creators creator = creatorsJpaRepository.findById(newCreators.getCreatorID()).orElse(null);
    creator.setAll(newCreators);
    creatorsJpaRepository.save(creator);
  }


  /* ------------------- DELETE MAPPING ------------------- */
  @DeleteMapping("/delCreator/{creatorsID}")
  public void delCreator (@PathVariable int creatorsID) {
    creatorsJpaRepository.deleteById(creatorsID);
  }
}
