package com.github.hasanmirzae.briefcasedesktop.controllers;

import com.github.hasanmirzae.briefcasedesktop.entities.Friend;
import com.github.hasanmirzae.briefcasedesktop.repositories.FriendRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController()
@RequestMapping("/api/friends")
public class FriendsController {


    private FriendRepository repository;

    public FriendsController(FriendRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public Iterable<Friend> getAll(){
        return repository.findAll();
    }

    @GetMapping("/count")
    public Long countFriends(){
        return repository.findCount();
    }

    @PostMapping
    public Friend insert(@RequestBody Friend friend){
        return repository.save(friend);
    }

    @PutMapping
    public Friend update(@RequestBody Friend friend){
        return repository.save(friend);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        repository.deleteById(id);
    }

    @GetMapping("/searchByUuid/{uuid}")
    public Optional<Friend> findByUuid(@PathVariable String uuid){
        return repository.findByUuid(uuid);
    }

    @PutMapping("/avatarByUuid")
    public void updateAvatarByUuid(@RequestParam String uuid, @RequestParam String uri){
        repository.updateAvatarByUuid(uuid, uri);
    }
}
