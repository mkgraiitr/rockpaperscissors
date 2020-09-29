package com.mavericks.rockpaperscissors.engine;

import java.util.ArrayList;
import java.util.List;

public class Round {
    private List<PlayerStatistics> allPlayerStatistics = new ArrayList<>();

    public List<PlayerStatistics> getPlayerStatistics() {
        return allPlayerStatistics;
    }

    public void setPlayerStatistics(PlayerStatistics playerStatistics) {
        allPlayerStatistics.add(playerStatistics);
    }

    public void setPlayerStatistics(int index, PlayerStatistics playerStatistics) {
        allPlayerStatistics.set(index, playerStatistics);
    }

    @Override
    public String toString() {
        return allPlayerStatistics.toString();
    }
}
