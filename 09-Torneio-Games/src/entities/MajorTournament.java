package entities;

public class MajorTournament extends Tournament {

    private final Double EXTRA_SPONSORSHIP = 10000.00;

    public MajorTournament() {
    }

    public MajorTournament(String tournamentName, Double registrationFee) {
        super(tournamentName, registrationFee);
    }

    @Override
    public Double totalPrize() {
        double price = registrationFee * getTeams().size() + EXTRA_SPONSORSHIP;
        return price - (price * 0.1);
    }

    @Override
    public String reportTournament() {
        StringBuilder sb = new StringBuilder();

        sb.append("\n\n==============================================");
        sb.append("\nTOURNAMENT: ").append(getTournamentName());
        sb.append("\nType: World Championship (Major)");
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
