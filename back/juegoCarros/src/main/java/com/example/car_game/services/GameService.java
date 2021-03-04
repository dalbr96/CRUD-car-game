package com.example.car_game.services;

import com.example.car_game.assembler.Assembler;
import com.example.car_game.entities.Game;
import com.example.car_game.entities.Player;
import com.example.car_game.models.GameModel;
import com.example.car_game.repositories.GameRepository;
import com.example.car_game.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private PlayerRepository playerRepository;

    public Player get (Integer id){
        return playerRepository.findById(id).orElseThrow();
    }

    public GameModel save (GameModel gameModel){
        Game game = Assembler.makeGame(gameModel);
        return Assembler.makeGameModel(gameRepository.save(game));
    }


}
