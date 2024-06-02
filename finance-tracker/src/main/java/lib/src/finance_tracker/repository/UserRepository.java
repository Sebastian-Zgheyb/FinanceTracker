package lib.src.finance_tracker.repository;

import lib.src.finance_tracker.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<AppUser, Long> {
}
