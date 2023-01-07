package br.com.gaby.sistemaos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gaby.sistemaos.domain.User;
import br.com.gaby.sistemaos.service.UserDetailsServiceImpl;

@RestController
@RequestMapping("/api/auth/user")
public class UserController {

    @Autowired
    private UserDetailsServiceImpl userService;

    @GetMapping("list")
    public Iterable<User> listAll() {
        return userService.listAll();
    }
    
    @GetMapping("autocomplete/{name}")
    public Iterable<?> autocomplete(@PathVariable String name) {
        return userService.autocomplete(name);
    }

    @GetMapping("listbyname/{name}")
    public Iterable<User> listByName(@PathVariable String name) {
        return userService.listByName(name);
    }

    @PostMapping("create")
    public ResponseEntity<?> create(@RequestBody User user) {
        return userService.createUpdate(user, "cadastrar");
    }

    @PutMapping("update")
    public ResponseEntity<?> update(@RequestBody User user) {
        return userService.createUpdate(user, "alterar");
    }

    @DeleteMapping("delete/{id}") 
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return userService.delete(id);
    }
}
