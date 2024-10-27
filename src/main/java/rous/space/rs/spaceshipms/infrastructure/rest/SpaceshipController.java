package rous.space.rs.spaceshipms.infrastructure.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rous.space.rs.spaceshipms.application.usecases.*;
import rous.space.rs.spaceshipms.domain.Spaceship;
import rous.space.rs.spaceshipms.domain.exceptions.SpaceshipNotFoundException;

import java.net.URI;
import java.util.List;

@RestController
public class SpaceshipController {

    @Autowired
    private CreateSpaceshipUseCase createSpaceshipUseCase;
    @Autowired
    private GetSpaceshipByIdUseCase getSpaceshipByIdUseCase;
    @Autowired
    private UpdateSpaceshipUseCase updateSpaceshipUseCase;
    @Autowired
    private DeleteSpaceshipUseCase deleteSpaceshipUseCase;
    @Autowired
    private GetAllSpaceshipsUseCase getAllSpaceshipsUseCase;
    @Autowired
    private FindSpaceshipsByNameUseCase findSpaceshipsByNameUseCase;

    @PostMapping("/spaceships")
    public ResponseEntity<Spaceship> createSpaceship(@RequestBody Spaceship spaceship) {


        Spaceship spaceshipCreated = createSpaceshipUseCase.createSpaceship(spaceship);
        return ResponseEntity.created(URI.create("/spaceships/" + spaceshipCreated.getId())).body(spaceshipCreated);
    }
    @GetMapping("/spaceships/{id}")
    public ResponseEntity<Spaceship> getSpaceshipById(@PathVariable Long id) {
        Spaceship spaceship = getSpaceshipByIdUseCase.getSpaceshipById(id);
        return ResponseEntity.ok(spaceship);
    }

    @PutMapping("/spaceships/{id}")
    public ResponseEntity<Spaceship> updateSpaceship(@PathVariable Long id, @RequestBody Spaceship updatedSpaceship) {
        Spaceship updated = updateSpaceshipUseCase.updateSpaceship(updatedSpaceship);
        return ResponseEntity.ok(updated);
    }

    @GetMapping("/spaceships")
    public List<Spaceship> getAllSpaceships() {

        return getAllSpaceshipsUseCase.getAllSpaceships();
    }

    @DeleteMapping("/spaceships/{id}")
    public ResponseEntity<?> deleteSpaceship(@PathVariable Long id) {
        try {
            deleteSpaceshipUseCase.deleteSpaceship(id);
            return ResponseEntity.noContent().build();
        } catch (SpaceshipNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/spaceships/search")
    public Page<Spaceship> findSpaceshipsByName(@RequestBody String name, Pageable pageable) {
        return findSpaceshipsByNameUseCase.findSpaceshipsByName(name, pageable);
    }


}
