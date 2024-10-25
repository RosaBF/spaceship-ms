package rous.space.rs.spaceshipms.application.usecases;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rous.space.rs.spaceshipms.application.service.SpaceshipService;
import rous.space.rs.spaceshipms.domain.Spaceship;
import rous.space.rs.spaceshipms.domain.exceptions.SpaceshipNotFoundException;

@RequiredArgsConstructor
@Service
public class GetSpaceshipByIdUseCase {

    private final SpaceshipService spaceshipService;

    public Spaceship getSpaceshipById(Long id) {
        Spaceship spaceship = spaceshipService.getSpaceshipById(id);
        if (spaceship == null) {
            throw new SpaceshipNotFoundException("No se encontró la nave con el ID: " + id);
        }
        return spaceship;
    }
}
