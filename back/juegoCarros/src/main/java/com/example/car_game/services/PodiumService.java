package com.example.car_game.services;

import com.example.car_game.assembler.Assembler;
import com.example.car_game.entities.Game;
import com.example.car_game.entities.Podium;
import com.example.car_game.models.PodiumModel;
import com.example.car_game.repositories.GameRepository;
import com.example.car_game.repositories.PlayerRepository;
import com.example.car_game.repositories.PodiumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PodiumService {

    @Autowired
    PodiumRepository podiumRepository;

    @Autowired
    PlayerRepository playerRepository;

    @Autowired
    GameRepository gameRepository;

    public PodiumModel save(PodiumModel podiumModel){

        Podium podium = Assembler.makePodium(podiumModel);

        podium.setFirstPlace(playerRepository.findById(podiumModel.getFirstPlayerId()).orElseThrow());
        podium.setSecondPlace(playerRepository.findById(podiumModel.getSecondPlayerId()).orElseThrow());
        podium.setThirdPlace(playerRepository.findById(podiumModel.getThirdPlayerId()).orElseThrow());
        podium.setGame(gameRepository.findById(podiumModel.getGameId()).orElseThrow());

        return Assembler.makePodiumModel(podiumRepository.save(podium));

    }

    public PodiumModel get(Integer id){
        Podium podium = podiumRepository.findById(id).orElseThrow(() ->
                new RuntimeException("There is not Podium with the id provided"));

        return Assembler.makePodiumModel(podium);

    }

    public PodiumModel getByGame(Integer id){
        Game game = gameRepository.findById(id).orElseThrow();
        return Assembler.makePodiumModel(podiumRepository.findByGame(game));
    }

}
