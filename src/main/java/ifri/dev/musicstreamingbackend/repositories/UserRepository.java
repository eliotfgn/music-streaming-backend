package ifri.dev.musicstreamingbackend.repositories;

import ifri.dev.musicstreamingbackend.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}