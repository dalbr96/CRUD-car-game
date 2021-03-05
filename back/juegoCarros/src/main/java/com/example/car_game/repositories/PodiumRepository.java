package com.example.car_game.repositories;


import com.example.car_game.entities.Game;
import com.example.car_game.entities.Player;
import com.example.car_game.entities.Podium;
import com.example.car_game.entities.Result;
import org.springframework.data.repository.CrudRepository;

public interface PodiumRepository extends CrudRepository<Podium, Integer> {

    public Player findByPlayer(Player player);
}
