package ohtu;

public class TennisGame {

    private int player1Score = 0;
    private int player2Score = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(this.player1Name)) {
            player1Score += 1;
        } else {
            player2Score += 1;
        }
    }

    public String getScore() {
        String scoreAsString = "";
        if (player1Score == player2Score) {
            scoreAsString = even();
        } else if (player1Score >= 4 || player2Score >= 4) {
            scoreAsString = endGame();
        } else {
            scoreAsString = countPoints(scoreAsString);
        }
        return scoreAsString;
    }

    private String countPoints(String scoreAsString) {
        scoreAsString = pointsToString(player1Score, scoreAsString);
        scoreAsString += "-";
        scoreAsString = pointsToString(player2Score, scoreAsString);
        return scoreAsString;
    }

    private String pointsToString(int score, String scoreAsString) {
        switch (score) {
            case 0:
                scoreAsString += "Love";
                break;
            case 1:
                scoreAsString += "Fifteen";
                break;
            case 2:
                scoreAsString += "Thirty";
                break;
            case 3:
                scoreAsString += "Forty";
                break;
            default:
                scoreAsString = "Deuce";
                break;
        }
        return scoreAsString;
    }

    private String endGame() {
        int minusResult = player1Score - player2Score;
        if (minusResult == 1) {
            return "Advantage player1";
        } else if (minusResult == -1) {
            return "Advantage player2";
        } else if (minusResult >= 2) {
            return "Win for player1";
        } else {
            return "Win for player2";
        }
    }

    private String even() {
        String scoreAsString = pointsToString(player1Score, "");

        if (!scoreAsString.contains("Deuce")) {
            scoreAsString += "-All";
        }

        return scoreAsString;
    }
}
