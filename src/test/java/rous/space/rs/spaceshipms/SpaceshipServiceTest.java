package rous.space.rs.spaceshipms;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import rous.space.rs.spaceshipms.application.services.SpaceshipService;
import rous.space.rs.spaceshipms.domain.Spaceship;
import rous.space.rs.spaceshipms.infrastructure.database.SpaceshipRepository;
import java.util.Collections;



import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
public class SpaceshipServiceTest {

    @Autowired
    private SpaceshipService spaceshipService;

    @Mock
    private SpaceshipRepository spaceshipRepositoryMock;


    @Test
    public void testCreateSpaceship() {
        // Create a mock Spaceship object
        Spaceship mockSpaceship = new Spaceship("Enterprise", "NX-01");

        // Call the service method under test
        Spaceship savedSpaceship = spaceshipService.createSpaceship(mockSpaceship);

        // Verify interaction with spaceshipRepository.save()
        when(spaceshipRepositoryMock.save(mockSpaceship)).thenReturn(mockSpaceship);

        // Verify results
        assertEquals(savedSpaceship, mockSpaceship);

    }


    @Test
    public void testFindAll() {
        // Mock spaceshipRepository.findAll
        Page<Spaceship> expectedSpaceships = new PageImpl<>(Collections.emptyList(), PageRequest.of(0, 10), 0);
        when(spaceshipRepositoryMock.findAll(PageRequest.of(0, 10))).thenReturn(expectedSpaceships);

        // Call findAll method
        Page<Spaceship> actualSpaceships = spaceshipService.findAll(PageRequest.of(0, 10));

        // Verify results
        assertEquals(expectedSpaceships, actualSpaceships);
    }
}





