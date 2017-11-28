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
        if (playerName.equals("player1")) {
            player1Score += 1;
        } else {
            player2Score += 1;
        }
    }

    public String getScore() {
        String scoreInString = "";
        if (player1Score == player2Score) {
            scoreInString = even();
        } else if (player1Score >= 4 || player2Score >= 4) {
            scoreInString = endGame();
        } else {
            scoreInString = countPoints(scoreInString);
        }
        return scoreInString;
    }

    public String even() {
        String scoreInString = pointsToString(player1Score, "");
        if(!scoreInString.contains("Deuce")) {
            scoreInString += "-All";
        }
        return scoreInString;
    }

    private String countPoints(String scoreInString) {
        scoreInString = pointsToString(player1Score, scoreInString);
        scoreInString += "-";
        scoreInString = pointsToString(player2Score, scoreInString);
        return scoreInString;
    }

    private String pointsToString(int score, String scoreInString) {
        switch (score) {
            case 0:
                scoreInString += "Love";
                break;
            case 1:
                scoreInString += "Fifteen";
                break;
            case 2:
                scoreInString += "Thirty";
                break;
            case 3:
                scoreInString += "Forty";
                break;
            default:
                scoreInString += "Deuce";
                break;
        }
        return scoreInString;
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
}
