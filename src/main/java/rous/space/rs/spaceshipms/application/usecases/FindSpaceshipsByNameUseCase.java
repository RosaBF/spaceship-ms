package rous.space.rs.spaceshipms.application.usecases;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rous.space.rs.spaceshipms.application.services.SpaceshipService;
import rous.space.rs.spaceshipms.domain.Spaceship;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@RequiredArgsConstructor
@Service
public class FindSpaceshipsByNameUseCase {

    private final SpaceshipService spaceshipService;

    public Page<Spaceship> findSpaceshipsByName(String name, Pageable pageable) {
        return spaceshipService.findByNameContaining(name, pageable);
    }
}
