package FootballTeamGenerator;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String name;
    private List<Player> players;

    public Team(String name) {
        this.setName(name);
        players = new ArrayList<>();
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }

    public void removePlayer(String player) {

        if (players.stream().noneMatch(e -> e.getName().equals(player))) {
            String message = String.format("Player %s is not in %s team.", player, this.name);
            throw new IllegalArgumentException(message);
        }
        this.players.remove(players.stream().filter(e -> e.getName().equals(player)).findFirst().get());
    }

    public double getRating() {
        return this.players.stream().mapToDouble(Player::overallSkillLevel).sum();
    }


}
