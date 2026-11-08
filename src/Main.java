import java.util.*;


WordProvider provider = wordProviderInitialize("src/words.txt");
public static final Scanner SCANNER = new Scanner(System.in);


void main() {

    firstGreeting();

    while (true) {
        printMenu();
        startGame();
    }
}

void printMenu() {

        System.out.println("Выберите, что вы хотите сделать:");
        System.out.println("1 - начать игру");
        System.out.println("2 - выйти");

}

void startGame() {

    int parsedInput;

    String input = SCANNER.nextLine();

    try {
        parsedInput = Integer.parseInt(input);
        switch (parsedInput) {
            case 1:
                HangmanGame game = new HangmanGame();
                game.startGame(SCANNER, provider.getWord());
            case 2:
                return;
            default:
                System.out.println("Я не знаю такой команды!");

        }
    } catch (NumberFormatException e) {
        System.out.println("Нужно вводить цифры!");
    }


}

void firstGreeting() {
    System.out.println("Добро пожаловать в игру!");
}

WordProvider wordProviderInitialize(String path) {
    return new WordProvider(path);
}
