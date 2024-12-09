package com.sample.englishauction.controller;

import com.sample.englishauction.exception.ResourceNotFoundException;
import com.sample.englishauction.model.AppUser;
import com.sample.englishauction.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/users")
public class UserController
{
    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public AppUser createUser(@RequestBody AppUser appUser) {
        return userRepository.save(appUser);
    }


    @GetMapping("{id}")
    public AppUser getUserbyId(@PathVariable long id)
    {
        AppUser appUser = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User do not exist with id:" + id));
        return appUser;
    }

    @PutMapping("{id}")
    public ResponseEntity<AppUser> updateUser(@PathVariable long id, @RequestBody AppUser appUserDetails) {
        AppUser updateAppUser = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User do not exist with id: " + id));


        updateAppUser.setUserName(appUserDetails.getUserName());
        userRepository.save(updateAppUser);
        return ResponseEntity.ok(updateAppUser);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteUser (@PathVariable long id)
    {
        AppUser appUser = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User with that id does not exist!"));
        userRepository.delete(appUser);

        return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }



}
