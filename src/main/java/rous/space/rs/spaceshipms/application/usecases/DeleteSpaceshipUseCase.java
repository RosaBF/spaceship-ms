package rous.space.rs.spaceshipms.application.usecases;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rous.space.rs.spaceshipms.application.service.SpaceshipService;
import rous.space.rs.spaceshipms.domain.Spaceship;
import rous.space.rs.spaceshipms.domain.exceptions.SpaceshipNotFoundException;

@AllArgsConstructor
@Service
public class DeleteSpaceshipUseCase {

    @Autowired
    private final SpaceshipService spaceshipService;

    public void deleteSpaceship(Long id) {
        Spaceship existingSpaceship = spaceshipService.getSpaceshipById(id);
        if (existingSpaceship == null) {
            throw new SpaceshipNotFoundException("There's no spaceship with the ID: " + id);
        }
        spaceshipService.deleteSpaceship(id);
    }
}