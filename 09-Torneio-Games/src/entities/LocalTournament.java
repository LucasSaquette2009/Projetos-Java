package entities;

public class LocalTournament extends Tournament {

    private final Double EXTRA_FEE = 500.00;

    public LocalTournament() {
    }

    public LocalTournament(String tournamentName, Double registrationFee) {
        super(tournamentName, registrationFee);
    }

    @Override
    public Double totalPrize() {
        return registrationFee * getTeams().size() + EXTRA_FEE;
    }

    @Override
    public String reportTournament() {
        StringBuilder sb = new StringBuilder();

        sb.append("\n\n==============================================");
        sb.append("\nTOURNAMENT: ").append(getTournamentName());
        sb.append("\nType: Local Champion (Local)");
        sb.append("\nRegistration Fee per Team: ").append(String.format("$ %.2f", registrationFee));
        sb.append("\n==============================================");

        sb.append("\n\nRegistered Teams:");

        for (Team t : getTeams()) {
            sb.append(t);
        }

        sb.append("\n----------------------------------------------");
        sb.append("\nTOURNAMENT FINANCIALS:");
        sb.append("\nNumber of Registered Teams: ").append(getTeams().size());
        sb.append("\nTotal Registration Revenue: ").append(String.format("$ %.2f", getTeams().size() * registrationFee));
        sb.append("\nTOTAL PRIZE POOL (with bonus/taxes): ").append(String.format("$ %.2f", totalPrize()));
        sb.append("\n----------------------------------------------");

        return sb.toString();
    }
}
