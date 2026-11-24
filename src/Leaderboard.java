import java.io.*;
import java.util.ArrayList;

public class Leaderboard {

    private final String fileName = "leaderboard.txt";

    // Save player information
    public void savePlayer(Player player) {

        try {

            FileWriter writer =
                    new FileWriter(fileName, true);

            writer.write(
                    player.getName()
                    + " - "
                    + player.getScore()
                    + "\n"
            );

            writer.close();

        } catch (IOException e) {

            System.out.println(
                    "Could not save leaderboard."
            );
        }
    }

    // Read leaderboard
    public ArrayList<String> readPlayers() {

        ArrayList<String> players =
                new ArrayList<>();

        try {

            File file =
                    new File(fileName);

            if (!file.exists()) {

                return players;
            }

            BufferedReader reader =
                    new BufferedReader(
                            new FileReader(file)
                    );

            String line;

            while ((line = reader.readLine()) != null) {

                players.add(line);
            }

            reader.close();

        } catch (IOException e) {

            System.out.println(
                    "Could not read leaderboard."
            );
        }

        return players;
    }
}