package int371.project.EventMod.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import int371.project.EventMod.Models.Events;

public interface EventsJpaRepository extends JpaRepository<Events, String> {}