import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Random;

public class WordProvider {

    private final Random random = new Random();
    List<String> words;

    public WordProvider(String PATH) {
        Path path = Path.of(PATH);

            try {
                words = Files.readAllLines(path, StandardCharsets.UTF_8);
                if (words.isEmpty()) {
                    throw new IllegalStateException("Слова в файле отсутсвуют");
                }
            } catch (IOException e) {
                throw new UncheckedIOException("Не удалось загрузить слова: " + PATH, e);
            }

    }


    public String getWord() {
        return words.get(random.nextInt(words.size()));
    }

}
