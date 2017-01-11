package com.petstore;

import com.petstore.controller.PetManagerController;
import com.petstore.model.Pet;
import com.petstore.repository.PetManagerRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class PetManagerControllerTest {

    @InjectMocks
    private PetManagerController sc;

    @Mock
    private PetManagerRepository petRepository;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testPetGet() {
        Pet sw = new Pet();
        sw.setId(1l);
        when(petRepository.findOne(1l)).thenReturn(sw);

        Pet pet = sc.get(1L);
        verify(petRepository).findOne(1l);
        assertThat(pet.getId(), is(1l));
    }

}
