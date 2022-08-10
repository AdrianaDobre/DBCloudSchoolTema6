package com.dobreadrianaliatema6.dobreadrianaliatema6.repository;

import com.dobreadrianaliatema6.dobreadrianaliatema6.model.Visit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface VisitRepository extends JpaRepository<Visit, Integer> {
    List<Visit> findAll();
    Optional<Visit> findById(Integer id);
}
