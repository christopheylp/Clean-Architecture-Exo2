import java.util.Scanner;

public class GameScanner {
    Scanner scanner = new Scanner(System.in);

    public String scanInputAndReturnToLowerCase() {
        return scanner.nextLine().trim().toLowerCase();
    }

    public String nextLine() {
        return scanner.nextLine();
    }

    public void close() {
        scanner.close();
    }
}
