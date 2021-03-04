package com.example.car_game.entities;

import javax.persistence.*;

@Entity
public class PartialResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    private Player player;

    @ManyToOne
    private Game game;

    private int partialDistance;

    private String color;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public int getPartialDistance() {
        return partialDistance;
    }

    public void setPartialDistance(int partialDistance) {
        this.partialDistance = partialDistance;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
