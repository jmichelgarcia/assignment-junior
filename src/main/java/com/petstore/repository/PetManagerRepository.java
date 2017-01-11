package com.petstore.repository;

import com.petstore.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PetManagerRepository extends JpaRepository<Pet, Long> {

    List<Pet> findAll();

    Pet saveAndFlush(Pet pet);

    Pet findOne(Long id);

    void delete(Pet existingPet);
}
