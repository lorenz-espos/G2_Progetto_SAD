package com.g2.Model;

public class Game {
    private String username;
    private long gameId;
    private String playerClass;
    private String robot;

    public Game() {
        this.gameId = 0;
    }

    public Game(String username, long gameId, String playerClass, String robot) {
        this.username = username;
        this.gameId = gameId;
        this.playerClass = playerClass;
        this.robot = robot;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public long  getGameId() {
        return gameId;
    }

    public void setGameId(long gameId) {
        //incremento l'id del gioco per ogni partita poichè in gameID mi viene restituito come l'ultimo id del file
        this.gameId = ++gameId;
    }

    public String getPlayerClass() {
        return playerClass;
    }

    public void setPlayerClass(String playerClass) {
        this.playerClass = playerClass;
    }

    public String getRobot() {
        return robot;
    }

    public void setRobot(String robot) {
        this.robot = robot;
    }

}
