package com.dogspot.dogspot.Repository;
import com.dogspot.dogspot.Entities.Tutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TutorRepository extends JpaRepository<Tutor, Integer> {
}