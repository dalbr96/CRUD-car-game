package com.example.car_game.controllers;

import com.example.car_game.models.PodiumModel;
import com.example.car_game.services.PodiumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class PodiumController {

    @Autowired
    PodiumService podiumService;

    @GetMapping("api/{id}/podium")
    public PodiumModel get(@PathVariable("id") Integer id){
        return podiumService.get(id);
    }

    @PostMapping("api/podium")
    public PodiumModel save(@RequestBody PodiumModel podiumModel){
        return podiumService.save(podiumModel);
    }

    @GetMapping("api/podium/{id}")
    public PodiumModel getByGame(@PathVariable("id") Integer id){
        return podiumService.getByGame(id);
    }


}
