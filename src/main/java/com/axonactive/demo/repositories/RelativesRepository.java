package com.axonactive.demo.repositories;

import com.axonactive.demo.entities.Relatives;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RelativesRepository extends JpaRepository<Relatives, Long> {

}
