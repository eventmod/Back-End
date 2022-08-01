package int371.project.EventMod.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import int371.project.EventMod.Models.Admins;

public interface AdminsJpaRepository extends JpaRepository<Admins, Integer> {}