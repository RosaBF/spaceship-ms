package rous.space.rs.spaceshipms.application.usecases;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rous.space.rs.spaceshipms.application.services.SpaceshipService;
import rous.space.rs.spaceshipms.domain.Spaceship;
import rous.space.rs.spaceshipms.domain.exceptions.SpaceshipNotFoundException;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class UpdateSpaceshipUseCase {

    private SpaceshipService spaceshipService;


    public Spaceship updateSpaceship(Spaceship spaceship) {
        Spaceship existingSpaceship = spaceshipService.getSpaceshipById(spaceship.getId());
        if (existingSpaceship == null) {
            throw new SpaceshipNotFoundException("No se encontró la nave con el ID: " + spaceship.getId());
        }
        // Update existing spaceship properties with new values
        String newName = spaceship.getName() != null ? spaceship.getName() : existingSpaceship.getName();
        existingSpaceship.setName(newName);
        existingSpaceship.setModel(spaceship.getModel() != null ? spaceship.getModel() : existingSpaceship.getModel());


        return spaceshipService.updateSpaceship(existingSpaceship);
    }
}
