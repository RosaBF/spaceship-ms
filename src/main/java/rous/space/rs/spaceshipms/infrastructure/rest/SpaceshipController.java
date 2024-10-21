package rous.space.rs.spaceshipms.infrastructure.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import rous.space.rs.spaceshipms.application.usecases.CreateSpaceshipUseCase;
import rous.space.rs.spaceshipms.domain.Spaceship;
import java.net.URI;

@RestController
public class SpaceshipController {

    @Autowired
    private CreateSpaceshipUseCase createSpaceshipUseCase;

    @PostMapping("/spaceships")
    public ResponseEntity<Long> createSpaceship(@RequestBody Spaceship spaceship) {


        Long spaceshipId = createSpaceshipUseCase.createSpaceship(spaceship);
        return ResponseEntity.created(URI.create("/spaceships/" + spaceshipId)).body(spaceshipId);
    }
}
