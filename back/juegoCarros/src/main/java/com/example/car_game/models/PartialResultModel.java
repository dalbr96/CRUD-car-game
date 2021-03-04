package com.example.car_game.models;

public class PartialResultModel {

    private Integer id;
    private Integer playerId;
    private Integer gameId;
    private Integer partialDistance;
    private String color;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Integer playerId) {
        this.playerId = playerId;
    }

    public Integer getGameId() {
        return gameId;
    }

    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }

    public Integer getPartialDistance() {
        return partialDistance;
    }

    public void setPartialDistance(Integer partialDistance) {
        this.partialDistance = partialDistance;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
