package int371.project.EventMod.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import int371.project.EventMod.Models.Contacts;

public interface ContactsJpaRepository extends JpaRepository<Contacts, String> {}