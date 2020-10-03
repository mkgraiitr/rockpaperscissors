package com.mavericks.rockpaperscissors.engine;

public class PlayerCurrentScore {
    private String id;
    private String name;
    private int currentScore;

    public PlayerCurrentScore(String id, String name, int currentScore) {
        this.id = id;
        this.name = name;
        this.currentScore = currentScore;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCurrentScore() {
        return currentScore;
    }

    public void setCurrentScore(int currentScore) {
        this.currentScore = currentScore;
    }
}
