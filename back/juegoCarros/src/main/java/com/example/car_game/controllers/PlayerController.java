package com.example.car_game.controllers;

import com.example.car_game.models.PlayerModel;
import com.example.car_game.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @GetMapping(value = "api/players")
    public Iterable<PlayerModel> list() {
        return playerService.list();
    }

    @PostMapping(value = "api/player")
    public PlayerModel save (@Valid @RequestBody PlayerModel playerModel){
        return playerService.save(playerModel);
    }

    @GetMapping(value = "api/{id}/player")
    public PlayerModel get(@PathVariable("id") Integer id){
        return playerService.getPlayerModel(id);
    }
}
