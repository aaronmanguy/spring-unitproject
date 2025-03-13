package com.example.event.user;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UsersRepository usersRepository;

    @GetMapping
    public List<Users> getUsers() { return usersRepository.findAll();}

    @GetMapping("/{id}")
    Users getUserById(@PathVariable long id) { return usersRepository.findById(id).get();}

    @Transactional
    @PostMapping
    Users createUser(@RequestBody Users user) {return usersRepository.save(user);}

    @Transactional
    @PutMapping
    Users updateUser(@RequestBody Users user) {return usersRepository.save(user);}

    @Transactional
    @DeleteMapping("/{id}")
    void deleteUser(@PathVariable long id) {usersRepository.deleteById(id); }
}
