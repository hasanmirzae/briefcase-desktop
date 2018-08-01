package com.github.hasanmirzae.briefcasedesktop.controllers;

import com.github.hasanmirzae.briefcasedesktop.entities.Feed;
import com.github.hasanmirzae.briefcasedesktop.repositories.FeedRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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


    @GetMapping("/{id}")
    public Optional<Feed> getById(@PathVariable Long id){
        return repository.findById(id);
    }

    @PostMapping
    public Feed insert(@RequestBody Feed feed){
        return repository.save(feed);
    }

    @PutMapping
    public Feed update(@RequestBody Feed feed){
        return repository.save(feed);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        repository.deleteById(id);
    }

    @PutMapping("/excludes/{exclude}")
    public void updateExclude(@PathVariable String exclude){
        repository.updateExclude(exclude);
    }

    @PutMapping("/receivers/{receivers}")
    public void updateReceivers(@PathVariable String receivers){
        repository.updateReceivers(receivers);
    }


    @GetMapping("/byFriendUuid/{uuid}")
    public Iterable<Feed> getFeedsByFriendFeed(@PathVariable String uuid){
        return repository.findFeedsByFriendUuid(uuid);
    }


}
