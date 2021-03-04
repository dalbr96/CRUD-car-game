package com.example.car_game.repositories;

import com.example.car_game.entities.Player;
import com.example.car_game.entities.Result;
import org.springframework.data.repository.CrudRepository;

public interface ResultRepository extends CrudRepository<Result, Integer> {
    public Result findByPlayer(Player player);
}
