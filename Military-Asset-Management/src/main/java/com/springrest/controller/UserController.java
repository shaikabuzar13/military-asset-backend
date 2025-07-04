package com.springrest.controller;

import com.springrest.dto.UserDTO;
import com.springrest.model.User;
import com.springrest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody UserDTO userDTO) {
        User savedUser = userService.registerUser(userDTO);
        return ResponseEntity.ok(savedUser);
    }

    // ✅ New endpoint to fetch logged-in user's role
    @GetMapping("/role")
    public ResponseEntity<String> getRole(Authentication authentication) {
        if (authentication == null || authentication.getAuthorities().isEmpty()) {
            return ResponseEntity.status(401).body("UNAUTHORIZED");
        }

        String role = authentication.getAuthorities().iterator().next().getAuthority();
        return ResponseEntity.ok(role); // returns "ROLE_ADMIN", "ROLE_COMMANDER", or "ROLE_LOGISTICS"
    }
}
