package com.dogspot.dogspot.Repositories;

import com.dogspot.dogspot.Entities.ONG;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ONGRepository extends JpaRepository<ONG, Long> {
}
