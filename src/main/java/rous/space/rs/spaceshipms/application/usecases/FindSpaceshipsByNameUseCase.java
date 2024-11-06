package rous.space.rs.spaceshipms.application.usecases;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rous.space.rs.spaceshipms.application.service.SpaceshipService;
import rous.space.rs.spaceshipms.domain.Spaceship;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@AllArgsConstructor
@Service
public class FindSpaceshipsByNameUseCase {

    @Autowired
    private final SpaceshipService spaceshipService;

    public Page<Spaceship> findSpaceshipsByName(String name, Pageable pageable) {
        return spaceshipService.findByNameContaining(name, pageable);
    }
}
