package rous.space.rs.spaceshipms.infrastructure.database;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import rous.space.rs.spaceshipms.domain.Spaceship;

public interface SpaceshipRepository extends JpaRepository<Spaceship, Long> {
    Page<Spaceship> findByNameContainingIgnoreCase(String name, Pageable pageable);
}
