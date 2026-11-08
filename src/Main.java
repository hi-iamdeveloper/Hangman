import java.util.*;



public static final Scanner SCANNER = new Scanner(System.in);
private static WordProvider provider;
private static final int START = 1;
private static final int QUIT = 2;


void main() {

    initializeProvider("src/words.txt");
    printGreeting();

    while (true) {
        printMenu();
        startGame();
    }
}

void printMenu() {

        System.out.println("Выберите, что вы хотите сделать:");
        System.out.println(START + " - начать игру");
        System.out.println(QUIT + " - выйти");

}

void startGame() {

    String input = SCANNER.nextLine();

    if (isNumber(input)) {
        int command = Integer.parseInt(input);
        switch (command) {
            case START:
                HangmanGame game = new HangmanGame();
                game.startGame(SCANNER, provider.getWord());
            case QUIT:
                return;
            default:
                System.out.println("Я не знаю такой команды!");
        }
    } else {
        System.out.println("Нужно ввести цифру!");
    }



}

void printGreeting() {
    System.out.println("Добро пожаловать в игру!");
}

private boolean isNumber(String s) {
    try {
        Integer.parseInt(s);
        return true;
    } catch (NumberFormatException e) {
        return false;
    }
}

WordProvider createProviderInitialize(String path) {
    return new WordProvider(path);
}

private static void initializeProvider(String path) {
    try {
        provider = new WordProvider(path);
    } catch (UncheckedIOException | IllegalStateException e) {
        System.err.println("Failed to start an app: " + e.getMessage());
        SCANNER.close();
        System.exit(1);
    }
}
