package rous.space.rs.spaceshipms.application.usecases;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rous.space.rs.spaceshipms.application.services.SpaceshipService;
import rous.space.rs.spaceshipms.domain.Spaceship;
import rous.space.rs.spaceshipms.domain.exceptions.SpaceshipNotFoundException;


@Service
public class CreateSpaceshipUseCase {

    @Autowired
    SpaceshipService spaceshipService;

    private Spaceship spaceship;



    public Spaceship createSpaceship(Spaceship spaceship) {
        this.spaceship = spaceship;
        validateSpaceshipData(spaceship);
        return spaceshipService.createSpaceship(spaceship);
    }

    private void validateSpaceshipData(Spaceship spaceship) {
        if (spaceship.getName()== null || spaceship.getName().isBlank()) {
            throw new SpaceshipNotFoundException("El nombre de la nave no puede estar vacío");
        }

    }
}
