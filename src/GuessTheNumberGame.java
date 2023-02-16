import java.util.Random;

public class GuessTheNumberGame {

    GameScanner scanner = new GameScanner();
    int userGuess = 0;
    int attempts = 0;
    boolean continuePlaying = true;
    int maxAttempts;
    int correctNumber = 0;

    public GuessTheNumberGame(int maxAttempts) {
        this.maxAttempts = maxAttempts;
    }

    public void play() {
        GamePrinter.printGameTitle();
        do {

            resetGameStats();
            GamePrinter.printGuessMessage();
            GamePrinter.printDebugMessage(correctNumber);

            while (correctNumber != userGuess && attempts < maxAttempts) {
                readUserInput();
            }

            if (correctNumber != userGuess) {
                GamePrinter.printLooseMessage(maxAttempts,correctNumber);
            }

            continuePlaying = checkUserWantTryAgain().equals("yes");

        } while (continuePlaying);

        GamePrinter.printGameEnd();
        scanner.close();
    }

    private String checkUserWantTryAgain() {
        GamePrinter.printRetryQuestion();
        return scanner.scanInputAndReturnToLowerCase();
    }

    private void resetGameStats() {
        userGuess = 0;
        attempts = 0;
        correctNumber = new Random().nextInt(100) + 1;
    }

    private void readUserInput() {
        String input = scanner.nextLine();
        attempts++;
        tryParseAndReadUserInput(input);
    }

    private void tryParseAndReadUserInput(String input) {
        try {
            userGuess = Integer.parseInt(input);
            GamePrinter.printUserInputCheckMessage(userGuess, correctNumber, attempts, maxAttempts);
        } catch (NumberFormatException e) {
            GamePrinter.printTooLowMessage(input, attempts, maxAttempts);
        }
    }

}
