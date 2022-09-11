package int371.project.EventMod.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import int371.project.EventMod.Models.Events;

public interface EventsJpaRepository extends JpaRepository<Events, Integer> {

	List<Events> findAllByEventTitle(String eventTitle);
	Events findByEventTitle(String eventTitle);
	List<Events> findByAccountID(Integer accountID);
}