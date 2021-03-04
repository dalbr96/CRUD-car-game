package com.example.car_game.repositories;

import com.example.car_game.entities.Game;
import com.example.car_game.entities.PartialResult;
import com.example.car_game.entities.Player;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PartialResultRepository extends CrudRepository<PartialResult, Integer> {

    public List<PartialResult> findAllByGame(Game game);

    public PartialResult findByPlayer(Player player);
}
