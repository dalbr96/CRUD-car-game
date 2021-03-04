package com.example.car_game.services;

import com.example.car_game.assembler.Assembler;
import com.example.car_game.entities.Player;
import com.example.car_game.entities.Result;
import com.example.car_game.models.ResultModel;
import com.example.car_game.repositories.PlayerRepository;
import com.example.car_game.repositories.ResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ResultService {

    @Autowired
    private ResultRepository resultRepository;

    @Autowired
    private PlayerRepository playerRepository;

    public Iterable<ResultModel> list(){

        Iterable<Result> results = resultRepository.findAll();
        List<ResultModel> resultModelList = new ArrayList<>();

        for(Result result: results){
            resultModelList.add(Assembler.makeResultModel(result));
        }

        return resultModelList;
    }

    public ResultModel save (ResultModel resultModel){
        Result result = Assembler.makeResult(resultModel);
        result.setPlayer(getPlayer(resultModel.getPlayerId()));
        return Assembler.makeResultModel(resultRepository.save(result));
    }

    public Player getPlayer(Integer id) {
        return playerRepository.findById(id).orElseThrow();
    }

    public Result getResult(Integer id) {
        return resultRepository.findById(id).orElseThrow();
    }

    public ResultModel getResultModel(Integer id){
        Result result = getResult(id);
        return Assembler.makeResultModel(result);
    }

    public void delete(Integer id){
        resultRepository.delete(getResult(id));
    }
}
