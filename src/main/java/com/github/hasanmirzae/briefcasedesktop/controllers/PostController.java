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

    @GetMapping("/searchByUuid/{uuid}")
    public Optional<Post> getByUuid(@PathVariable String uuid){
        return repository.findByUuid(uuid);
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

    @GetMapping("/byPosterUuidAndUuid")
    public Optional<Post> getPostsByPosterUuidAndUuid(@RequestParam String posterUuid, @RequestParam String postUuid){
        return  repository.findByPosterUuidAndUuid(posterUuid, postUuid);
    }


}
