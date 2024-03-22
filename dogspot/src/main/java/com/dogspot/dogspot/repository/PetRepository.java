package com.dogspot.dogspot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.dogspot.dogspot.model.Pet;

public interface PetRepository extends JpaRepository<Pet, Long> {
}
