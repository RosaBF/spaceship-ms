package rous.space.rs.spaceshipms.application.usecases;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import rous.space.rs.spaceshipms.application.service.SpaceshipService;
import rous.space.rs.spaceshipms.domain.Spaceship;
import rous.space.rs.spaceshipms.domain.exceptions.SpaceshipNotFoundException;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class UpdateSpaceshipUseCase {

    private  SpaceshipService spaceshipService;

    public Spaceship updateSpaceship(Spaceship spaceship) throws SpaceshipNotFoundException {
        // Fetch existing spaceship
        Spaceship existingSpaceship = spaceshipService.getSpaceshipById(spaceship.getId());

        // Check if spaceship exists
        if (existingSpaceship == null) {
            throw new SpaceshipNotFoundException("Spaceship with id " + spaceship.getId() + " not found");
        }

        // Update properties
        existingSpaceship.setName(spaceship.getName() != null ? spaceship.getName() : existingSpaceship.getName());
        existingSpaceship.setModel(spaceship.getModel() != null ? spaceship.getModel() : existingSpaceship.getModel());


        return spaceshipService.updateSpaceship(existingSpaceship);
    }
}
