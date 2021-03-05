package com.example.car_game.repositories;


import com.example.car_game.entities.Game;
import com.example.car_game.entities.Podium;
import org.springframework.data.repository.CrudRepository;

public interface PodiumRepository extends CrudRepository<Podium, Integer> {

    public Podium findByGame(Game game);
}
