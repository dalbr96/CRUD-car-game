package com.example.car_game.models;

public class PodiumModel {

    private Integer id;

    private Integer firstPlayerId;

    private Integer secondPlayerId;

    private Integer thirdPlayerId;

    private Integer gameId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFirstPlayerId() {
        return firstPlayerId;
    }

    public void setFirstPlayerId(Integer firstPlayerId) {
        this.firstPlayerId = firstPlayerId;
    }

    public Integer getSecondPlayerId() {
        return secondPlayerId;
    }

    public void setSecondPlayerId(Integer secondPlayerId) {
        this.secondPlayerId = secondPlayerId;
    }

    public Integer getThirdPlayerId() {
        return thirdPlayerId;
    }

    public void setThirdPlayerId(Integer thirdPlayerId) {
        this.thirdPlayerId = thirdPlayerId;
    }

    public Integer getGameId() {
        return gameId;
    }

    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }
}
