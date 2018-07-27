package com.github.hasanmirzae.briefcasedesktop.controllers;

import com.github.hasanmirzae.briefcasedesktop.entities.AppProperty;
import com.github.hasanmirzae.briefcasedesktop.repositories.AppPropertyRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/properties")
public class AppPropertiesController {

    private AppPropertyRepository repository;

    public AppPropertiesController(AppPropertyRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public Iterable<AppProperty> getAll(){
        return repository.findAll();
    }

    @PostMapping()
    public AppProperty insert(@RequestBody AppProperty property){
        return repository.save(property);
    }

    @PutMapping
    public AppProperty update(@RequestBody AppProperty property){
        return repository.save(property);
    }

    @DeleteMapping
    public void delete(@PathVariable Long id){
        repository.deleteById(id);
    }

}
