package int371.project.EventMod.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import int371.project.EventMod.Models.Lineaccounts;

public interface LineaccountsJpaRepository extends JpaRepository<Lineaccounts, Integer> {
  
  Lineaccounts findByLineaccUserID(String lineaccUserID);

}