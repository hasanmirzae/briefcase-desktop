package com.github.hasanmirzae.briefcasedesktop.controllers;

import com.github.hasanmirzae.briefcasedesktop.entities.Feed;
import com.github.hasanmirzae.briefcasedesktop.repositories.FeedRepository;
import com.github.hasanmirzae.briefcasedesktop.repositories.FeedRepository;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/api/feeds")
public class FeedsController {


    private FeedRepository repository;

    public FeedsController(FeedRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public Iterable<Feed> getAll(){
        return repository.findAll();
    }

    @PostMapping
    public Feed insert(@RequestBody Feed feed){
        return repository.save(feed);
    }

    @PutMapping
    public Feed update(@RequestBody Feed feed){
        return repository.save(feed);
    }

    @DeleteMapping
    public void delete(@PathVariable Long id){
        repository.deleteById(id);
    }

}
