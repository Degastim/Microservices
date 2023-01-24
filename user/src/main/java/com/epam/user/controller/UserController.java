package com.epam.user.controller;

import com.epam.user.dto.UserAmountOfPost;
import com.epam.user.dto.UserDTO;
import com.epam.user.dto.UserNameDTO;
import com.epam.user.handler.ResponseMessage;
import com.epam.user.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

    private UserService userService;

    @GetMapping("/{id}")
    public UserDTO find(@PathVariable long id) {
        return userService.findById(id);
    }

    @PostMapping
    public UserDTO create(@RequestBody(required = false) UserNameDTO userNameDTO) {
        return userService.create(userNameDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseMessage> delete(@PathVariable long id) {
        userService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage("OK"));

    }

    @PutMapping("/{id}")
    public UserDTO update(@PathVariable long id, @RequestBody(required = false) UserNameDTO userNameDTO) {
        return userService.update(id, userNameDTO);
    }

    @PatchMapping("/{id}")
    public UserDTO updateUserAmountOfPost(@PathVariable long id, @RequestBody(required = false) UserAmountOfPost userAmountOfPost) {
        return userService.updateAmountOfPost(id, userAmountOfPost);
    }
}
