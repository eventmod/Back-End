package int371.project.EventMod.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import int371.project.EventMod.Models.EventsJoined;

public interface EventsJoinedJpaRepository extends JpaRepository<EventsJoined, Integer> {

  List<EventsJoined> findByEventID(Integer eventID);
  
}