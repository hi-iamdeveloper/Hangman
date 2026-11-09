import java.util.*;

public class HangmanGame {

    private final Set<Character> enteredLetters = new HashSet<>();
    private static final int ATTEMPTS = 6;
    private final PictureStorage pictureStorage = new PictureStorage();
    private char[] hiddenLetters;
    private String word;

    void startGame(Scanner scanner, WordProvider provider) {

        word = provider.getWord();
        hiddenLetters = initialize(word.length());
        int tries = 0;
        enteredLetters.clear();

        System.out.println("Игра запущена! Слово состоит из " + word.length() + " букв");
        System.out.println(hiddenLetters);

        while (tries < ATTEMPTS) {

            System.out.print(pictureStorage.getPicture(tries));
            displayEnteredLetter(getEnteredLetters());
            System.out.println("Слово: "  + String.valueOf(getHiddenLetters()));
            System.out.println("Введите букву");
            System.out.println("Осталось попыток: " + (ATTEMPTS - tries));

            String input = scanner.nextLine();

            if (input.length() != 1) {
                System.out.println("Нужно вводить одну букву!\n");
                continue;
            }

            char letter = input.charAt(0);
            letter = Character.toLowerCase(letter);
            if (letter == 'ё') {
                letter = 'е';
            }


            if (isLetterValid(letter)) {
                if (isLetterContainsInAWord(letter)) {
                    enteredLetters.add(letter);
                } else {
                    enteredLetters.add(letter);
                    tries++;
                }
            } else {
                continue;
            }

            if (isWin()) {
                System.out.println("Поздравляю, вы победили! Слово: " + word);
                return;
            }

        }

        System.out.println("Вы програли, слово было - " + word);

    }

    private boolean isLetterValid(char letter) {
        if (!Character.isLetter((letter))) {
            System.out.print("Нужно вводить буквы!\n");
            return false;
        } else if (!isLetterRussian(letter)) {
            System.out.println("Нужно вводить русские буквы!\n");
            return false;
        } else if (isLetterUsed(letter)) {
            System.out.println("Вы уже вводили эту букву!\n");
            return false;
        }

        return true;
    }

    private boolean isLetterUsed(char letter) {

        return enteredLetters.contains(letter);

    }

    char[] initialize(int length) {

        char[] temp = new char[length];

        Arrays.fill(temp, '_');

        return temp;
    }

    private boolean isWin() {
        return new String(hiddenLetters).indexOf('_') == -1;
    }

    private void displayEnteredLetter(Set<Character> enteredLetters) {
        System.out.println("Введенные буквы: " + enteredLetters);
    }

    private boolean isLetterRussian(char letter) {
        return ((letter >= 'а' && letter <= 'я') || letter == 'ё');
    }

    private boolean isLetterContainsInAWord(char letter) {
        boolean contains = false;

        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == letter) {
                hiddenLetters[i] = letter;
                contains = true;
            }
        }

        if (contains) {
            System.out.println("Да, такая буква есть!");
            return true;
        } else {
            System.out.println("Нет, такой буквы нету");
            return false;
        }
    }

    public char[] getHiddenLetters() {
        return hiddenLetters;
    }

    public Set<Character> getEnteredLetters() {
        return enteredLetters;
    }
}
