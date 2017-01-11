package com.petstore.controller;

import com.petstore.model.Pet;
import com.petstore.repository.PetManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/")
public class PetManagerController {

    @Autowired
    private PetManagerRepository petRepository;

    @RequestMapping(value = "pets", method = RequestMethod.GET)
    public List<Pet> list() {
        return petRepository.findAll();
    }

    @RequestMapping(value = "pets", method = RequestMethod.POST)
    public Pet create(@RequestBody Pet pet) {
        return petRepository.saveAndFlush(pet);
    }

    @RequestMapping(value = "pets/{id}", method = RequestMethod.GET)
    public Pet get(@PathVariable Long id) {
        return petRepository.findOne(id);
    }

    @RequestMapping(value = "pets/{id}", method = RequestMethod.DELETE)
    public Pet delete(@PathVariable Long id) {
        Pet existingPet = petRepository.findOne(id);
        petRepository.delete(existingPet);
        return existingPet;
    }
}
