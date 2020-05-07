/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.codejava.Lab11;

import Game.Player;
import java.util.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Hazi Catalin
 */
@RestController
@RequestMapping("/players")

public class PlayerController {
    private final List<Player> players = new ArrayList<>();
    public PlayerController() {
        players.add(new Player("George", 1));
        players.add(new Player("Andrei", 2));
    }
    @GetMapping
     public List<Player> getPlayers() {
        return players;
     }

    @PostMapping
    public void createPlayer(@RequestParam String name) {
        int id = 1 + players.size();
        players.add(new Player("Radu", id));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable int id, @RequestParam String name) {
        Player player = findById(id);
        if (player == null) {
            return new ResponseEntity<>(
            "Product not found", HttpStatus.NOT_FOUND); //or GONE
        }
        player.setName(name);
        return new ResponseEntity<>(
        "Product updated successsfully", HttpStatus.OK);
    }

}
