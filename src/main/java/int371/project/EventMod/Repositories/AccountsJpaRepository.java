package int371.project.EventMod.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import int371.project.EventMod.Models.AuthenticationUser;

public interface AccountsJpaRepository extends JpaRepository<AuthenticationUser, Integer> {
  AuthenticationUser findByUsername(String username);
}
