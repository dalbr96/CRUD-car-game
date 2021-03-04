package com.example.car_game.domain.game;

import com.example.car_game.domain.game.values.Pist;
import com.example.car_game.domain.game.values.Podium;
import com.example.car_game.entities.Player;

import java.util.HashMap;
import java.util.Map;

public class GameDomain {

    private Map<Integer, Player> players = new HashMap<Integer, Player>();
    private Pist pist;
    private boolean playing;
    private Podium podium = new Podium();

    public void createPlayer(Player player){
        players.put(player.getId(), player);
    }

    public Pist getPist() {
        return pist;
    }

    public void setPist(Pist pist) {
        this.pist = pist;
    }

    public void setFirstPlace(Player player){
        podium.setFirstPlace(player);
    }

    public void setSecondPlace(Player player){
     podium.setSecondPlace(player);
    }

    public void setThirdPlace(Player player){
         podium.setThirdPlace(player);
    }

    public void startGame(){
        this.playing = true;
    }

    public Map<Integer, Player> players() {
        return this.players;
    }

    public Pist pist() {
        return pist;
    }

    public boolean isPlaying() {
        return playing;
    }

    public void setPlaying(boolean playing) {
        this.playing = playing;
    }

    public Podium podium() {
        return podium;
    }

}
