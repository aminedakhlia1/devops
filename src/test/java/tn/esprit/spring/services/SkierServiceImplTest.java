package tn.esprit.spring.services;

import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.spring.entities.Skier;
import tn.esprit.spring.entities.Subscription;
import tn.esprit.spring.repositories.ISkierRepository;
import tn.esprit.spring.repositories.ISubscriptionRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class SkierServiceImplTest {

    @InjectMocks
    private SkierServicesImpl skierServices;

    @Mock
    private ISkierRepository skierRepository;

    @Mock
    private ISubscriptionRepository subscriptionRepository;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testRetrieveAllSkiers() {
        // Create a list of Skier objects for testing
        List<Skier> skiers = new ArrayList<>();
        skiers.add(new Skier());
        skiers.add(new Skier());

        // Mock the behavior of skierRepository.findAll()
        Mockito.when(skierRepository.findAll()).thenReturn(skiers);

        List<Skier> result = skierServices.retrieveAllSkiers();

        // Verify that the result is not null and contains two Skier objects
        assertNotNull(result);
        assertEquals(2, result.size());
    }

    @Test
    public void testAddSkier() {
        Skier skier = new Skier();
        Subscription subscription = new Subscription();
        skier.setSubscription(subscription);

        // Mock the behavior of skierRepository.save()
        Mockito.when(skierRepository.save(skier)).thenReturn(skier);

        Skier result = skierServices.addSkier(skier);

        // Verify that the returned Skier object has an end date set based on the subscription type
        assertNotNull(result);
        assertNotNull(result.getSubscription().getEndDate());
    }

    @Test
    public void testAssignSkierToSubscription() {
        Long numSkier = 1L;
        Long numSubscription = 2L;

        Skier skier = new Skier();
        Subscription subscription = new Subscription();
        skier.setSubscription(subscription);

        // Mock the behavior of skierRepository.findById() and subscriptionRepository.findById()
        Mockito.when(skierRepository.findById(numSkier)).thenReturn(Optional.of(skier));
        Mockito.when(subscriptionRepository.findById(numSubscription)).thenReturn(Optional.of(subscription));

        Skier result = skierServices.assignSkierToSubscription(numSkier, numSubscription);

        // Verify that the returned Skier object has the assigned subscription
        assertNotNull(result);
        assertEquals(subscription, result.getSubscription());
    }
}
