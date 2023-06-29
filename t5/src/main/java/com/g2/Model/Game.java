package com.g2.Model;

public class Game {
    private static int counter = 0;
    private String username;
    private long gameId;
    private String playerClass;
    private String robot;

    public Game(String username, long gameId, String playerClass, String robot) {
        this.username = username;
        this.gameId = generateGameId();
        this.playerClass = playerClass;
        this.robot = robot;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public long getGameId() {
        return gameId;
    }

    public void setGameId(long gameId) {
        this.gameId = gameId;
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

    private synchronized int generateGameId() {
        return ++counter;
    }

}
