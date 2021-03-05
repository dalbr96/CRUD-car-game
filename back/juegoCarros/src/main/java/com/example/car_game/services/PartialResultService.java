package com.example.car_game.services;


import com.example.car_game.assembler.Assembler;
import com.example.car_game.entities.Game;
import com.example.car_game.entities.PartialResult;
import com.example.car_game.models.PartialResultModel;
import com.example.car_game.repositories.GameRepository;
import com.example.car_game.repositories.PartialResultRepository;
import com.example.car_game.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PartialResultService {

    @Autowired
    PartialResultRepository partialResultRepository;

    @Autowired
    GameRepository gameRepository;

    @Autowired
    PlayerRepository playerRepository;

    public PartialResultModel get(Integer id){
        return Assembler.makePartialResultModel(partialResultRepository.findById(id).orElseThrow());
    }

    public PartialResultModel save(PartialResultModel partialResultModel){

        PartialResult partialResult = Assembler.makePartialResult(partialResultModel);
        partialResult.setGame(gameRepository.findById(partialResultModel.getGameId()).orElseThrow());
        partialResult.setPlayer(playerRepository.findById(partialResultModel.getPlayerId()).orElseThrow());

        return Assembler.makePartialResultModel(partialResultRepository.save(partialResult));
    }

    public void delete(Integer id){

        PartialResult partialResult = Assembler.makePartialResult(get(id));
        partialResultRepository.delete(partialResult);
    }

    public Iterable<PartialResultModel> getByGame(Integer id){

        Game game = gameRepository.findById(id).orElseThrow();

        Iterable<PartialResult> partialResults = partialResultRepository.findAllByGame(game);
        List<PartialResultModel> partialResultsModel = new ArrayList<>();

        for(PartialResult result : partialResults){
            partialResultsModel.add(Assembler.makePartialResultModel(result));
        }

        return partialResultsModel;
    }

}
