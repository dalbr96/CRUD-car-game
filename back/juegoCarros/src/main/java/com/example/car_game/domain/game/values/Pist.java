package com.example.car_game.domain.game.values;

public class Pist {

    private int kilometers;

    private int numTracks;

    public Pist(int kilometers, int numTracks) {
        this.kilometers = kilometers;
        this.numTracks = numTracks;
    }

    public int getKilometers() {
        return kilometers;
    }

    public void setKilometers(int kilometers) {
        this.kilometers = kilometers;
    }

    public int getNumTracks() {
        return numTracks;
    }

    public void setNumTracks(int numTracks) {
        this.numTracks = numTracks;
    }


}
