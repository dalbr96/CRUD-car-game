package com.example.car_game.controllers;

import com.example.car_game.services.RunGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class RunGameController {

    @Autowired
    RunGameService runGameService;

    @GetMapping(value = "api/{id}/run-game")
    public void runGame(@PathVariable("id") Integer id){

        runGameService.startGame(id);
    }
}
