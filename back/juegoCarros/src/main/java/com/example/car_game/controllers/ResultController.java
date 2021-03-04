package com.example.car_game.controllers;

import com.example.car_game.models.ResultModel;
import com.example.car_game.services.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ResultController {

    @Autowired
    private ResultService resultService;

    @GetMapping(value = "api/results")
    public Iterable<ResultModel> list() {
        return resultService.list();
    }

    @PostMapping(value = "api/result")
    public ResultModel save (@Valid @RequestBody ResultModel resultModel){
        return resultService.save(resultModel);
    }

    @PutMapping(value = "api/result")
    public ResultModel update(@Valid @RequestBody ResultModel resultModel){
        if(resultModel.getId() != null){
            return resultService.save(resultModel);
        }
        throw new RuntimeException("No existe el id para actualizar");
    }

    @GetMapping(value = "api/{id}/result")
    public ResultModel get(@PathVariable("id") Integer id){
        return resultService.getResultModel(id);
    }

    @DeleteMapping(value = "api/{id}/result")
    public void delete(@PathVariable("id")Integer id){
        resultService.delete(id);
    }


}
