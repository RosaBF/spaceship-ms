package rous.space.rs.spaceshipms.application.usecases;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rous.space.rs.spaceshipms.application.service.SpaceshipService;
import rous.space.rs.spaceshipms.domain.Spaceship;
import rous.space.rs.spaceshipms.domain.exceptions.SpaceshipNotFoundException;

@RequiredArgsConstructor
@Service
public class DeleteSpaceshipUseCase {

    private final SpaceshipService spaceshipService;

    public void deleteSpaceship(Long id) {
        Spaceship existingSpaceship = spaceshipService.getSpaceshipById(id);
        if (existingSpaceship == null) {
            throw new SpaceshipNotFoundException("There's no spaceship with the ID: " + id);
        }
        spaceshipService.deleteSpaceship(id);
    }
}