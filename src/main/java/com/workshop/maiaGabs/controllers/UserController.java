package com.workshop.maiaGabs.controllers;

import com.workshop.maiaGabs.models.dto.UserCreateDTO;
import com.workshop.maiaGabs.models.dto.UserUpdateDTO;
import com.workshop.maiaGabs.models.entities.User;
import com.workshop.maiaGabs.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/user")
@Validated
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id){
        User user = this.userService.findById(id);
        return ResponseEntity.ok().body(user);
    }

    @PostMapping
    public ResponseEntity<Void> create(@Valid @RequestBody UserCreateDTO userCreateDTO){

        User user = this.userService.fromDTO(userCreateDTO);
        User newUser = this.userService.create(user);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(newUser.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@Valid @RequestBody UserUpdateDTO userUpdateDTO, @PathVariable Long id){

        userUpdateDTO.setId(id);
        User user = this.userService.fromDTO(userUpdateDTO);
        this.userService.update(user);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){

        this.userService.delete(id);
        return ResponseEntity.noContent().build();
    }
}