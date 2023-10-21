package baseball;

public class GameScore {
    private final Person person;
    private final Computer computer;

    public GameScore(Person person, Computer computer) {
        this.person = person;
        this.computer = computer;
    }

    public BallStrikeCount calculateScore() {
        BallStrikeCount ballStrikeCount = new BallStrikeCount();

        for (int i = 0; i < GameConstants.LIST_SIZE; i++) {
            int personNum = person.getNumberAt(i);

            if (computer.containsNumber(personNum)) {
                calculateBall(i, personNum, ballStrikeCount);
                calculateStrike(i, personNum, ballStrikeCount);
            }
        }
        return ballStrikeCount;
    }

    private void calculateBall(int i, int personNum, BallStrikeCount ballStrikeCount) {
        if (computer.getNumberAt(i) != personNum) {
            ballStrikeCount.increaseBall();
        }
    }

    private void calculateStrike(int i, int personNum, BallStrikeCount ballStrikeCount) {
        if (computer.getNumberAt(i) == personNum) {
            ballStrikeCount.increaseStrike();
        }
    }
}
