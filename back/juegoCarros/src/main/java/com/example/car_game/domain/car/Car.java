package com.example.car_game.domain.car;

import com.example.car_game.entities.Player;


public class Car {

    private Player driver;
    private int distance;
    private String color;

    public Car(Player driver, int distance, String color){
        this.driver = driver;
        this.distance = distance;
        this.color  = color;
    }

    public void setDriver(Player driver){
        this.driver = driver;
    }

    public void moveOnTrack(int distance){
        this.distance += distance;
    }

    public Player driver(){
        return this.driver;
    }

    public int distance(){
        return this.distance;
    }

    public String color(){
        return this.color;
    }
}
