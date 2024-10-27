package rous.space.rs.spaceshipms.application.service;


import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import rous.space.rs.spaceshipms.domain.Spaceship;
import rous.space.rs.spaceshipms.infrastructure.database.SpaceshipRepository;



@Service
public class SpaceshipService {

    private final SpaceshipRepository spaceshipRepository;

    public SpaceshipService(SpaceshipRepository spaceshipRepository) {
        this.spaceshipRepository = spaceshipRepository;
    }

    public Spaceship createSpaceship(Spaceship spaceship) {
        return spaceshipRepository.save(spaceship);
    }
    @Cacheable("spaceships")
    public Spaceship getSpaceshipById(Long id) {
        return spaceshipRepository.findById(id).orElse(null);
    }

    public Spaceship updateSpaceship(Spaceship spaceship) {
        // Check if spaceship exists before update
        Spaceship existingSpaceship = getSpaceshipById(spaceship.getId());
        if (existingSpaceship == null) {
            throw new RuntimeException("Spaceship with id " + spaceship.getId() + " not found");
        }
        String newName = spaceship.getName() != null ? spaceship.getName() : existingSpaceship.getName();
        existingSpaceship.setName(newName);
        String newModel = spaceship.getModel() != null ? spaceship.getModel() : existingSpaceship.getModel();
        existingSpaceship.setModel(newModel);

        return spaceshipRepository.save(spaceship);
    }

    public void deleteSpaceship(Long id) {
        spaceshipRepository.deleteById(id);
    }

    public Page<Spaceship> findByNameContaining(String name, Pageable pageable) {
        return spaceshipRepository.findByNameContainingIgnoreCase(name, pageable);
    }

    public Page<Spaceship> findAll(Pageable pageable) {
        return spaceshipRepository.findAll(pageable);
    }
}