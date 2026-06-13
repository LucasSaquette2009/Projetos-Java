package entities;

import java.util.ArrayList;
import java.util.List;

public abstract class Tournament {

    private String tournamentName;
    protected Double registrationFee;

    private List<Team> teams = new ArrayList<>();

    public Tournament() {
    }

    public Tournament(String tournamentName, Double registrationFee) {
        this.tournamentName = tournamentName;
        this.registrationFee = registrationFee;
    }

    public String getTournamentName() {
        return tournamentName;
    }

    public void setTournamentName(String tournamentName) {
        this.tournamentName = tournamentName;
    }

    public Double getRegistrationFee() {
        return registrationFee;
    }

    public void setRegistrationFee(Double registrationFee) {
        this.registrationFee = registrationFee;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void addTeam(Team team) {
        teams.add(team);
    }

    public void removeTeam(Team team) {
        teams.remove(team);
    }

    public abstract Double totalPrize();

    public abstract String reportTournament();
}
