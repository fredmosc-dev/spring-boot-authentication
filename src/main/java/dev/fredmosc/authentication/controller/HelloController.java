package dev.fredmosc.authentication.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @GetMapping
    public ResponseEntity<?> hello() {
        return ResponseEntity.ok("Cheguei");
    }

    // TODO: 10/06/2020 Implements Authorizes
    @GetMapping("/oi")
    @PreAuthorize("hasAuthority('USER')")
    public ResponseEntity<?> ola() {
        return ResponseEntity.ok("ola");
    }
}
