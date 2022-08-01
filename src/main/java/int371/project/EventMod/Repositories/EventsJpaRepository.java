package int371.project.EventMod.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import int371.project.EventMod.Models.Events;

public interface EventsJpaRepository extends JpaRepository<Events, Integer> {

//	String findByEv_Name(Events newEvent);
//	boolean equals(Events newEvent);
//
//	List<Events> findAll();
//
//	@Query("select * from Events where Ev_Name = :eventName")
	List<Events> findAllByEventTitle(String eventTitle);
}