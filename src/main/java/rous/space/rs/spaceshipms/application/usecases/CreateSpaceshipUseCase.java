package rous.space.rs.spaceshipms.application.usecases;


import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rous.space.rs.spaceshipms.application.service.SpaceshipService;
import rous.space.rs.spaceshipms.domain.Spaceship;
import rous.space.rs.spaceshipms.domain.exceptions.SpaceshipNotFoundException;

@AllArgsConstructor
@Service
public class CreateSpaceshipUseCase {

    @Autowired
    private final SpaceshipService spaceshipService;

    private Spaceship spaceship;


    public Spaceship createSpaceship(Spaceship spaceship) {
        this.spaceship = spaceship;
        validateSpaceshipData(spaceship);
        return spaceshipService.createSpaceship(spaceship);
    }

    private void validateSpaceshipData(Spaceship spaceship) {
        if (spaceship.getName()== null || spaceship.getName().isBlank()) {
           throw new SpaceshipNotFoundException("The name of the ship cannot be empty");
        }

    }
}
