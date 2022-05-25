package int371.project.EventMod.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import int371.project.EventMod.Models.EventsHaveTags;

public interface EventsHaveTagsJpaRepository extends JpaRepository<EventsHaveTags, Integer> {}