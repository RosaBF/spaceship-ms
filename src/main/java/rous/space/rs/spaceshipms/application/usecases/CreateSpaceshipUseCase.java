package rous.space.rs.spaceshipms.application.usecases;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rous.space.rs.spaceshipms.application.services.SpaceshipService;
import rous.space.rs.spaceshipms.domain.Spaceship;
import rous.space.rs.spaceshipms.domain.exceptions.SpaceshipNotFoundException;

@RequiredArgsConstructor
@Service
public class CreateSpaceshipUseCase {

    private final SpaceshipService spaceshipService;
    private Spaceship spaceship;

    public Long createSpaceship(Spaceship spaceship) {
        this.spaceship = spaceship;
        validateSpaceshipData(spaceship);
        return spaceshipService.createSpaceship(spaceship).getId();
    }

    private void validateSpaceshipData(Spaceship spaceship) {
        if (spaceship.getName() == null || spaceship.getName().isBlank()) {
            throw new SpaceshipNotFoundException("El nombre de la nave no puede estar vacío");
        }

    }
}
