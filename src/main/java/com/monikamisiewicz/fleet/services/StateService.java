package com.monikamisiewicz.fleet.services;

import com.monikamisiewicz.fleet.models.State;
import com.monikamisiewicz.fleet.repositories.StateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StateService {

    private final StateRepository stateRepository;

    public List<State> getStates() {
        return stateRepository.findAll();
    }

    public void save(State state) {
        stateRepository.save(state);
    }

    public Optional<State> findById(int id) {
        return stateRepository.findById(id);
    }

    public void delete(Integer id) {
        stateRepository.deleteById(id);
    }
}
