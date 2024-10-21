package rous.space.rs.spaceshipms.infrastructure.database;

import org.springframework.data.jpa.repository.JpaRepository;
import rous.space.rs.spaceshipms.domain.Spaceship;

public interface SpaceshipRepository extends JpaRepository<Spaceship, Long> {
}
