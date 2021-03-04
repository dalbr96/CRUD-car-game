package com.example.car_game.controllers;

import com.example.car_game.models.PartialResultModel;
import com.example.car_game.services.PartialResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class PartialResultController {

    @Autowired
    private PartialResultService partialResultService;

    @PostMapping(value = "api/partial-result")
    public PartialResultModel save(@RequestBody PartialResultModel partialResultModel) {
        return partialResultService.save(partialResultModel);
    }

    @PutMapping(value = "api/partial-result")
    public PartialResultModel update(@RequestBody PartialResultModel partialResultModel) {
        if(partialResultModel.getId() != null){
            return partialResultService.save(partialResultModel);
        }
        else{
            throw new RuntimeException("There is not partial result to update");
        }
    }

    @DeleteMapping(value = "api/{id}/partial-result")
    public void delete(@PathVariable("id") Integer id){
        partialResultService.delete(id);
    }

    @GetMapping(value = "api/{id}/partial-result")
    public PartialResultModel get (@PathVariable("id") Integer id){
        return partialResultService.get(id);
    }

    @GetMapping(value = "api/partial-result/game/{id}")
    public Iterable<PartialResultModel> getByGame(@PathVariable("id") Integer id){
        return partialResultService.getByGame(id);
    }

}
