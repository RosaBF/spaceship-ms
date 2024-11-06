package rous.space.rs.spaceshipms.infrastructure.database;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rous.space.rs.spaceshipms.domain.Spaceship;

@Repository
public interface SpaceshipRepository extends JpaRepository<Spaceship, Long> {
    Page<Spaceship> findByNameContainingIgnoreCase(String name, Pageable pageable);

}
