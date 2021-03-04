package com.example.car_game.domain.track;

import com.example.car_game.domain.car.Car;
import com.example.car_game.domain.track.values.Position;

public class Track {
    private Car car;
    private Position position;
    private int meters;
    private boolean finalDisplacement;


    public Track(Car car, Position position){
        this.car = car;
        this.position = position;
        this.meters = position.getGoal();
        this.finalDisplacement = false;
    }

    public void addCar(Car car){
        this.car = car;
    }

    public void reachGoal(){
        if(actualPosition() >= desiredPosition()){

            this.finalDisplacement = true;
        }
        else{

            this.finalDisplacement = false;
        }
    }

    public void moveCar(int meters){
        this.position.changeActualPosition(meters);
        this.car.moveOnTrack(meters);
    }

    public int meters(){
        return this.meters;
    }

    public int actualPosition(){
        return this.position.getActual();
    }

    public int desiredPosition(){
        return this.position.getGoal();
    }

    public boolean isFinalDisplacement(){
        return finalDisplacement;
    }
}
