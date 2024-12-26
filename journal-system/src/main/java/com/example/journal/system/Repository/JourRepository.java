package com.example.journal.system.Repository;

import com.example.journal.system.Entity.journey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JourRepository extends JpaRepository<journey,Long> {

}
