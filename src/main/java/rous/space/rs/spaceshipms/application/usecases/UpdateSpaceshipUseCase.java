package rous.space.rs.spaceshipms.application.usecases;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rous.space.rs.spaceshipms.application.services.SpaceshipService;
import rous.space.rs.spaceshipms.domain.Spaceship;
import rous.space.rs.spaceshipms.domain.exceptions.SpaceshipNotFoundException;

@RequiredArgsConstructor
@Service
public class UpdateSpaceshipUseCase {

    private final SpaceshipService spaceshipService;

    public Spaceship updateSpaceship(Spaceship spaceship) {
        Spaceship existingSpaceship = spaceshipService.getSpaceshipById(spaceship.getId());
        if (existingSpaceship == null) {
            throw new SpaceshipNotFoundException("No se encontró la nave con el ID: " + spaceship.getId());
        }
        // Update existing spaceship properties with new values
        existingSpaceship.setName(spaceship.getName() != null ? spaceship.getName() : existingSpaceship.getName());
        existingSpaceship.setModel(spaceship.getModel() != null ? spaceship.getModel() : existingSpaceship.getModel());


        return spaceshipService.updateSpaceship(existingSpaceship);
    }
}
