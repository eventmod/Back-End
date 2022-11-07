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
import int371.project.EventMod.Models.Lineaccounts;
import int371.project.EventMod.Repositories.LineaccountsJpaRepository;

@CrossOrigin
@RestController
public class LineaccountsController {
  
  @Autowired
  private LineaccountsJpaRepository lineaccountsJpaRepository;

  /* ------------------- GET MAPPING ------------------- */
  @GetMapping("/lineaccounts")
  public List<Lineaccounts> showAllLineaccounts () {
    return lineaccountsJpaRepository.findAll();
  }

  @GetMapping("/lineaccount/{id}")
  public Lineaccounts showLineaccountsByID (@PathVariable int lineaccID) {
    Lineaccounts lineaccount = this.lineaccountsJpaRepository.findById(lineaccID).orElse(null);
		if (lineaccount == null) {
			throw new EventsException(ExceptionResponse.ERROR_CODE.LINEACCOUNT_ID_DOES_NOT_EXIST,
					"Lineaccount ID" + " : " + lineaccID + " " + "does not exist");
		}
		return lineaccount;
  }

  /* ------------------- POST MAPPING ------------------- */
  @PostMapping("/newLineaccount")
  public void newLineaccount (@RequestBody Lineaccounts newLineaccount) throws Exception {
    lineaccountsJpaRepository.save(newLineaccount);
  }

  /* ------------------- PUT MAPPING ------------------- */
  @PutMapping("/updateLineaccount")
  public void updateLineaccount (@RequestBody Lineaccounts newLineaccount) throws Exception {
    Lineaccounts lineaccount = lineaccountsJpaRepository.findById(newLineaccount.getLineaccID()).orElse(null);
    if (lineaccount == null) {
			throw new EventsException(ExceptionResponse.ERROR_CODE.LINEACCOUNT_ID_DOES_NOT_EXIST,
					"Lineaccount ID" + " : " + newLineaccount.getLineaccID() + " " + "does not exist");
		} else {
      lineaccount.setLineaccID(newLineaccount.getLineaccID());
      lineaccount.setLineaccUserID(newLineaccount.getLineaccUserID());
      lineaccount.setLineaccStudentID(newLineaccount.getLineaccStudentID());
      lineaccount.setLineaccKmuttMail(newLineaccount.getLineaccKmuttMail());
      lineaccount.setLineaccVerify(newLineaccount.getLineaccVerify());
      lineaccountsJpaRepository.save(lineaccount);
    }
  }


  /* ------------------- DELETE MAPPING ------------------- */
  @DeleteMapping("/delLineaccount")
  public void delLineaccount (@RequestParam("lineaccountID") int lineaccountID) {
    lineaccountsJpaRepository.deleteById(lineaccountID);
  }

}
