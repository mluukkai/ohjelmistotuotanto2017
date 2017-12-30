package ohtu;

public class TennisGame {

    private int scoreOne = 0;
    private int scoreTwo = 0;
    private String playerOne;
    private String playerTwo;

    public TennisGame(String player1Name, String player2Name) {
        this.playerOne = player1Name;
        this.playerTwo = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName == "player1") {
            scoreOne += 1;
        } else {
            scoreTwo += 1;
        }
    }

    public String getScore() {
        
        String score = "";
        if (scoreOne == scoreTwo) {
            return case1(score);
        } else if (scoreOne > 3 || scoreTwo > 3) {
            return case2(score);
        } else {
            return case3(score);
        }
    }

    public String case1(String score) {

        switch (scoreOne) {
            case 0:
                score = "Love-All";
                break;
            case 1:
                score = "Fifteen-All";
                break;
            case 2:
                score = "Thirty-All";
                break;
            case 3:
                score = "Forty-All";
                break;
            default:
                score = "Deuce";
                break;
        }
        return score;
    }

    public String case2(String score) {

        int minusResult = scoreOne - scoreTwo;
        if (minusResult == 1) {
            score = "Advantage player1";
        } else if (minusResult == -1) {
            score = "Advantage player2";
        } else if (minusResult >= 2) {
            score = "Win for player1";
        } else {
            score = "Win for player2";
        }

        return score;
    }

    public String case3(String score) {

        int tempScore = 0;

        for (int i = 1; i < 3; i++) {
            if (i == 1) {
                tempScore = scoreOne;
            } else {
                score += "-";
                tempScore = scoreTwo;
            }
            switch (tempScore) {
                case 0:
                    score += "Love";
                    break;
                case 1:
                    score += "Fifteen";
                    break;
                case 2:
                    score += "Thirty";
                    break;
                case 3:
                    score += "Forty";
                    break;
            }
        }
        return score;
    }
}
