package int371.project.EventMod.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import int371.project.EventMod.Models.Tags;

public interface TagsJpaRepository extends JpaRepository<Tags, String> {}