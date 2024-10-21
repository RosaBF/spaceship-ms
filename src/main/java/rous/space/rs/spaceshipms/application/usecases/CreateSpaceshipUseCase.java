package rous.space.rs.spaceshipms.application.usecases;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rous.space.rs.spaceshipms.application.services.SpaceshipService;
import rous.space.rs.spaceshipms.domain.Spaceship;
import rous.space.rs.spaceshipms.domain.exceptions.InvalidSpaceshipDataException;

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
        // Validaciones personalizadas con mensajes claros
        if (spaceship.getName() == null || spaceship.getName().isBlank()) {
            throw new InvalidSpaceshipDataException("El nombre de la nave no puede estar vacío");
        }
        // Agregar más validaciones según sea necesario, por ejemplo:
        // - Validar el año de fabricación
        // - Validar la capacidad de la tripulación
        // - Validar que no existan naves con el mismo nombre
    }
}
