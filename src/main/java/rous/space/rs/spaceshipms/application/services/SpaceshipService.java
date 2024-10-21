package rous.space.rs.spaceshipms.application.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import rous.space.rs.spaceshipms.domain.Spaceship;
import rous.space.rs.spaceshipms.infrastructure.database.SpaceshipRepository;

@Service
public class SpaceshipService {

    private final SpaceshipRepository spaceshipRepository;

    public SpaceshipService(SpaceshipRepository spaceshipRepository) {
        this.spaceshipRepository = spaceshipRepository;
    }

    public Spaceship createSpaceship(Spaceship spaceship) {
        return spaceshipRepository.save(spaceship);
    }

    // Otros métodos para obtener, actualizar y eliminar naves espaciales
    public Spaceship getSpaceshipById(Long id) {
        return spaceshipRepository.findById(id).orElse(null);
    }

    // ...
}