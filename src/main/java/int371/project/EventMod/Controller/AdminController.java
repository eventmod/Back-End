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
import int371.project.EventMod.Models.Admins;
import int371.project.EventMod.Repositories.AdminsJpaRepository;

@CrossOrigin
@RestController
public class AdminController {
  
  @Autowired
  private AdminsJpaRepository adminsJpaRepository;

  /* ------------------- GET MAPPING ------------------- */
  @GetMapping("/admins")
  public List<Admins> showAllAdmins () {
    return adminsJpaRepository.findAll();
  }

  @GetMapping("/admin/{adminsID}")
  public Admins showAdminsByID (@PathVariable int adminsID) {
    Admins admins = this.adminsJpaRepository.findById(adminsID).orElse(null);
		if (admins == null) {
			throw new EventsException(ExceptionResponse.ERROR_CODE.ADMIN_ID_DOES_NOT_EXIST,
					"Admin ID" + " : " + adminsID + " " + "does not exist");
		}
		return admins;
  }

  /* ------------------- POST MAPPING ------------------- */
  @PostMapping("/newAdmin")
  public void newAdmin (@RequestBody Admins newAdmins) throws Exception {
    adminsJpaRepository.save(newAdmins);
  }

  /* ------------------- PUT MAPPING ------------------- */
  @PutMapping("/updateAdminDetail")
  public void updateAdmin (@RequestBody Admins newAdmins) throws Exception {
    Admins admin = adminsJpaRepository.findById(newAdmins.getAdminID()).orElse(null);
    admin.setAll(newAdmins);
    adminsJpaRepository.save(admin);
  }


  /* ------------------- DELETE MAPPING ------------------- */
  @DeleteMapping("/delAdmin")
  public void delAdmin (@RequestParam("adminsID") int adminsID) {
    adminsJpaRepository.deleteById(adminsID);
  }
}
