package com.dogspot.dogspot.Repositories;

import com.dogspot.dogspot.Entities.Cachorro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CachorroRepository extends JpaRepository<Cachorro, Long> {
}
