package int371.project.EventMod.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import int371.project.EventMod.Models.Accounts;

public interface AccountsJpaRepository extends JpaRepository<Accounts, Integer> {}