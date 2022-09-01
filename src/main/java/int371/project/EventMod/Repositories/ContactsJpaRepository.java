package int371.project.EventMod.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import int371.project.EventMod.Models.Contacts;

public interface ContactsJpaRepository extends JpaRepository<Contacts, Integer> {

  List<Contacts> findByEventID(Integer eventID);

}