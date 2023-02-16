public class GamePrinter {
    static void printGameTitle() {
        System.out.println("-===========================-");
        System.out.println("=== GUESS THE NUMBER GAME ===");
        System.out.println("-===========================-");
    }

    static void printGameEnd() {
        System.out.println("== Thanks for playing! ==");
    }

    static void printLooseMessage(int maxAttempts, int correctNumber) {
        System.out.println("You lose after " + maxAttempts + " tries, the expected number was " + correctNumber);
    }

    static void printRetryQuestion() {
        System.out.println("----------------------------------------------------");
        System.out.println("Do you want to try again with a new number (yes/no)?");
    }

    static void printTooLowMessage(String input, int attempts, int maxAttempts) {
        System.out.println("Your input was '" + input + "', please enter a valid integer. " + (maxAttempts - attempts) + "/" + maxAttempts + " tries left");
    }


    static void printDebugMessage(int correctNumber) {
        System.out.println("debug : the expected number is " + correctNumber);
    }

    static void printGuessMessage() {
        System.out.println("Guess the number (between 1 and 100)!");
    }

    static void printUserInputCheckMessage(int userGuess, int correctNumber, int attempts, int maxAttempts) {
        if (userGuess == correctNumber) {
            GamePrinter.printWinMessage(attempts);
        } else {
            String divergence = userGuess < correctNumber ? "smaller" : "greater";
            GamePrinter.printDivergenceMessage(divergence, attempts, maxAttempts);
        }
    }

    static void printDivergenceMessage(String divergence, int attempts, int maxAttempts) {
        System.out.println("Wrong! Your number is " + divergence + " than the correct one. " + (maxAttempts - attempts) + "/" + maxAttempts + " tries left");
    }

    static void printWinMessage(int attempts) {
        System.out.println("You found it after " + attempts + " tries!");
    }


}
