package entities;

import java.util.ArrayList;
import java.util.List;

public class Team {

    private String teamName;
    private String tag;

    private List<Player> players = new ArrayList<>();

    public Team() {
    }

    public Team(String teamName, String tag) {
        this.teamName = teamName;
        this.tag = tag;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void removePlayer(Player player) {
        players.remove(player);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("\n\n[ " + teamName + " ]\n");
        for (Player p : players) {
            sb.append(p);
        }

        return sb.toString();
    }
}
