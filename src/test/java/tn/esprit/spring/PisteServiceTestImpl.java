import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import tn.esprit.spring.entities.Piste;
import tn.esprit.spring.repositories.IPisteRepository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

class PisteServicesImplTest {

    @Mock
    private IPisteRepository pisteRepository;

    @InjectMocks
    private PisteServicesImpl pisteServices;

    public PisteServicesImplTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void retrieveAllPistes() {
        // Arrange
        Piste piste = new Piste(); // You need to create a sample Piste object for testing
        when(pisteRepository.findAll()).thenReturn(Collections.singletonList(piste));

        // Act
        List<Piste> result = pisteServices.retrieveAllPistes();

        // Assert
        assertEquals(1, result.size());
        assertEquals(piste, result.get(0));
        verify(pisteRepository, times(1)).findAll();
    }

    @Test
    void addPiste() {
        // Arrange
        Piste piste = new Piste(); // You need to create a sample Piste object for testing
        when(pisteRepository.save(piste)).thenReturn(piste);

        // Act
        Piste result = pisteServices.addPiste(piste);

        // Assert
        assertNotNull(result);
        assertEquals(piste, result);
        verify(pisteRepository, times(1)).save(piste);
    }

    @Test
    void removePiste() {
        // Arrange
        Long numPiste = 1L; // You need to set a sample Piste ID for testing

        // Act
        pisteServices.removePiste(numPiste);

        // Assert
        verify(pisteRepository, times(1)).deleteById(numPiste);
    }

    @Test
    void retrievePiste() {
        // Arrange
        Long numPiste = 1L; // You need to set a sample Piste ID for testing
        Piste piste = new Piste(); // You need to create a sample Piste object for testing
        when(pisteRepository.findById(numPiste)).thenReturn(Optional.of(piste));

        // Act
        Piste result = pisteServices.retrievePiste(numPiste);

        // Assert
        assertNotNull(result);
        assertEquals(piste, result);
        verify(pisteRepository, times(1)).findById(numPiste);
    }
}
