package com.github.hasanmirzae.briefcasedesktop.controllers;

import com.github.hasanmirzae.briefcasedesktop.entities.Post;
import com.github.hasanmirzae.briefcasedesktop.repositories.PostRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController()
@RequestMapping("/api/posts")
public class PostController {


    private PostRepository repository;

    public PostController(PostRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public Iterable<Post> getAll(){
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Post> getById(@PathVariable Long id){
        return repository.findById(id);
    }

    @PostMapping
    public Post insert(@RequestBody Post post){
        return repository.save(post);
    }

    @PutMapping
    public Post update(@RequestBody Post post){
        return repository.save(post);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        repository.deleteById(id);
    }

    @GetMapping("/byPosterUuidAndRemoteId")
    public Post getPostsByPosterUuidAndRemoteId(@RequestParam String posterUuid, @RequestParam Long remoteId){
        return  repository.findByPosterUuidAndRemoteId(posterUuid, remoteId);
    }


}
