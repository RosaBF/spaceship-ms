package rous.space.rs.spaceshipms;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import rous.space.rs.spaceshipms.application.service.SpaceshipService;
import rous.space.rs.spaceshipms.domain.Spaceship;
import rous.space.rs.spaceshipms.infrastructure.database.SpaceshipRepository;
import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
public class SpaceshipServiceTest {

    @InjectMocks
    private SpaceshipService spaceshipService;

    @Mock
    private SpaceshipRepository spaceshipRepositoryMock;

  @MockBean
    private CacheManager cacheManager;

    @BeforeEach
    public void setUp() {
        Cache cache = Mockito.mock(Cache.class);
        when(cacheManager.getCache("spaceships")).thenReturn(cache);
    }


    @Test
    public void testCreateSpaceship() {
        // Create a mock Spaceship object
        Spaceship mockSpaceship = new Spaceship("Enterprise", "NX-01");

        when(spaceshipRepositoryMock.save(mockSpaceship)).thenReturn(mockSpaceship);

        // Call the service method under test
        Spaceship savedSpaceship = spaceshipService.createSpaceship(mockSpaceship);

        // Verify results
        assertEquals(savedSpaceship, mockSpaceship);

    }

    @Test
    public void testGetSpaceshipById_found() {
        // Given
        Long id = 1L;
        Spaceship mockSpaceship = new Spaceship("Enterprise", "NX-01");
        Mockito.when(spaceshipRepositoryMock.findById(id)).thenReturn(Optional.of(mockSpaceship));

        // When
        Spaceship result = spaceshipService.getSpaceshipById(id);

        // Then
        assertNotNull(result);
        assertEquals(mockSpaceship, result);
        Mockito.verify(spaceshipRepositoryMock, Mockito.times(1)).findById(id);
    }


    @Test
    public void testGetSpaceshipById_notFound() {
        // Given
        Long id = 2L;
        Mockito.when(spaceshipRepositoryMock.findById(id)).thenReturn(Optional.empty());

        // When
        Spaceship result = spaceshipService.getSpaceshipById(id);

        // Then
        assertNull(result);
        Mockito.verify(spaceshipRepositoryMock, Mockito.times(1)).findById(id);
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





