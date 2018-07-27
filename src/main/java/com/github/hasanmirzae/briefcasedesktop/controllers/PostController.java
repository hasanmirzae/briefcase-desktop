package com.github.hasanmirzae.briefcasedesktop.controllers;

import com.github.hasanmirzae.briefcasedesktop.entities.Post;
import com.github.hasanmirzae.briefcasedesktop.repositories.PostRepository;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public Post insert(@RequestBody Post post){
        return repository.save(post);
    }

    @PutMapping
    public Post update(@RequestBody Post post){
        return repository.save(post);
    }

    @DeleteMapping
    public void delete(@PathVariable Long id){
        repository.deleteById(id);
    }

}
