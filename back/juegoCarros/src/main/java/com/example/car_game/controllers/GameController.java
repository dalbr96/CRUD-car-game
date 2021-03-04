package com.example.car_game.controllers;

import com.example.car_game.models.GameModel;
import com.example.car_game.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class GameController {

    @Autowired
    private GameService gameService;


    @PostMapping(value = "api/game")
    public GameModel save (@Valid @RequestBody GameModel gameModel){
        return gameService.save(gameModel);
    }

}
