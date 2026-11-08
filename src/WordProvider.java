import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Random;

public class WordProvider {

    private final Random RANDOM = new Random();
    private final List<String> words;

    public WordProvider(String filename) {
        Path path = Path.of(filename);

            try {
                words = Files.readAllLines(path, StandardCharsets.UTF_8);
                if (words.isEmpty()) {
                    throw new IllegalStateException("There is no words in file");
                }
            } catch (IOException e) {
                throw new UncheckedIOException("Couldn't load a file: " + path, e);
            }

    }


    public String getWord() {
        return words.get(RANDOM.nextInt(words.size()));
    }

}
