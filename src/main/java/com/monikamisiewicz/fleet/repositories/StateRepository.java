package com.monikamisiewicz.fleet.repositories;

import com.monikamisiewicz.fleet.models.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StateRepository extends JpaRepository<State, Integer> {
}
