public class PictureStorage {
    private static final String[] PICTERS = {
            """
             -----
             |   |
             |
             |
             |
             |
            _|_
            """,

            """
             -----
             |   |
             |   O
             |
             |
             |
            _|_
            """,

            """
             -----
             |   |
             |   O
             |   |
             |
             |
            _|_
            """,

            """
             -----
             |   |
             |   O
             |  /|
             |
             |
            _|_
            """,

            """
             -----
             |   |
             |   O
             |  /|\\
             |
             |
            _|_
            """,

            """
             -----
             |   |
             |   O
             |  /|\\
             |  /
             |
            _|_
            """,

            """
             -----
             |   |
             |   O
             |  /|\\
             |  / \\
             |
            _|_
            """
    };

    public String getPicture(int num) {
        return PICTERS[num];
    }
}