package com.github.hasanmirzae.briefcasedesktop.controllers;

import com.github.hasanmirzae.briefcasedesktop.entities.Post;
import com.github.hasanmirzae.briefcasedesktop.entities.Request;
import com.github.hasanmirzae.briefcasedesktop.repositories.PostRepository;
import com.github.hasanmirzae.briefcasedesktop.repositories.RequestRepository;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/api/requests")
public class RequestController {


    private RequestRepository repository;

    public RequestController(RequestRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public Iterable<Request> getAll(){
        return repository.findAll();
    }

    @PostMapping
    public Request insert(@RequestBody Request request){
        return repository.save(request);
    }

    @PutMapping
    public Request update(@RequestBody Request request){
        return repository.save(request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        repository.deleteById(id);
    }

    @DeleteMapping("/byUuidAndIsMine")
    public void deleteByUuidAndIsMine(@RequestParam String uuid, @RequestParam Boolean isMine){
        repository.deleteByUuidAndIsMine(uuid, isMine);
    }


}
