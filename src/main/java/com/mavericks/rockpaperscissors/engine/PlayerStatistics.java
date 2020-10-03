package com.mavericks.rockpaperscissors.engine;

public class PlayerStatistics {
    private String id;
    private String selection;
    private int score;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSelection() {
        return selection;
    }

    public void setSelection(String selection) {
        this.selection = selection;
    }

    public int getScore() {
        return score;
    }

    public void updateScore(int currentRoundScore) {
        score += currentRoundScore;
    }

    @Override
    public String toString() {
        return "Player Id:: " + id + " selected -" + selection + " and scored :: " + getScore();
    }
}
