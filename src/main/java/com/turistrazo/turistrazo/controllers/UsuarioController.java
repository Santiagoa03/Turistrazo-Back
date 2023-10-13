package com.turistrazo.turistrazo.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.turistrazo.turistrazo.models.Usuario;
import com.turistrazo.turistrazo.services.UsuarioService;

@RestController
@RequestMapping("/api/users")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/register")
    public Usuario postSave(@RequestBody Usuario user) {
        return usuarioService.postSave(user);
    }

    @GetMapping("/{userId}")
    public Usuario getUserProfile(@PathVariable Integer userId) {
        return usuarioService.getUserProfile(userId);
    }

    @GetMapping("/email/{email}")
    public Optional<Usuario> getUserProfile(@PathVariable String email) {
        return usuarioService.getUserByEmail(email);
    }
}
