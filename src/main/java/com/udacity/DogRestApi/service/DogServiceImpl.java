package com.udacity.DogRestApi.service;

import com.udacity.DogRestApi.entity.Dog;
import com.udacity.DogRestApi.exception.DogNotFoundException;
import com.udacity.DogRestApi.repository.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DogServiceImpl implements DogService {

    @Autowired
    DogRepository dogRepository;
    @Override
    public List<Dog> retrieveDogs() {
        return (List<Dog>) dogRepository.findAll();
    }

    @Override
    public List<String> retrieveDogBreed() {
        return dogRepository.findAllBreed();
    }

    @Override
    public String retrieveDogBreedById(Long id) {
        Optional<String> optionalBreed = Optional.ofNullable(dogRepository.findBreedById(id));
        return optionalBreed.orElseThrow(DogNotFoundException::new);
    }

    @Override
    public List<String> retrieveDogNames() {
        return dogRepository.findAllName();
    }
}
