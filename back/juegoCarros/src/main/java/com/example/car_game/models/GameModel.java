package com.example.car_game.models;

import com.sun.istack.NotNull;

import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;

public class GameModel {
    
    
    private Integer id;

    @NotNull
    @Min(3)
    private Integer numberOfPlayers;
    
    @NotNull
    @Positive
    private int distance;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public void setNumberOfPlayers(Integer numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

}
