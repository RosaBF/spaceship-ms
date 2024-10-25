package rous.space.rs.spaceshipms.application.usecases;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import rous.space.rs.spaceshipms.application.service.SpaceshipService;
import rous.space.rs.spaceshipms.domain.Spaceship;

import java.util.List;
@Service
@AllArgsConstructor
public class GetAllSpaceshipsUseCase {

    private final SpaceshipService spaceshipService;

    // Indicate that an empty list is returned if spaceshipService is null
    public List<Spaceship> getAllSpaceships() {
        return spaceshipService == null ? List.of() : spaceshipService.findAll(Pageable.unpaged()).getContent();
    }
}
