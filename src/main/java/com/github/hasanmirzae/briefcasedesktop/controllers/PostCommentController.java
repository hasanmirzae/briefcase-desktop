package com.github.hasanmirzae.briefcasedesktop.controllers;

import com.github.hasanmirzae.briefcasedesktop.entities.PostComment;
import com.github.hasanmirzae.briefcasedesktop.repositories.PostCommentRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController()
@RequestMapping("/api")
public class PostCommentController {


    private PostCommentRepository repository;

    public PostCommentController(PostCommentRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/postComments")
    public Iterable<PostComment> getAll(){
        return repository.findAll();
    }


    @GetMapping("/postComments/{id}")
    public Optional<PostComment> getById(@PathVariable Long id){
        return repository.findById(id);
    }

    @GetMapping("/posts/{postId}/postComments")
    public Iterable<PostComment> getByPostId(@PathVariable Long postId){
        return repository.findByPostId(postId);
    }

    @PostMapping("/postComments")
    public PostComment insert(@RequestBody PostComment postComment){
        return repository.save(postComment);
    }

    @PutMapping("/postComments")
    public PostComment update(@RequestBody PostComment postComment){
        return repository.save(postComment);
    }

    @DeleteMapping("/postComments/{id}")
    public void delete(@PathVariable Long id){
        repository.deleteById(id);
    }


}
