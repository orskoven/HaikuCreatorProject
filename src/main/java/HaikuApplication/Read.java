package HaikuApplication;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Scanner;

public class Read {
    static Scanner scanner = new Scanner(System.in);
    static boolean isNameFound;
    static int lineCounter = 0;

    public void getPoem() {
        System.out.print("Type your name to load a poem:");
        String usernameToLoad = scanner.next();
        File haikuPoems = new File(".idea/Haiku/Haikus.csv");
        try {
            Scanner sc = new Scanner(haikuPoems);
            while (sc.hasNextLine() || !isNameFound) {
                String line = sc.nextLine();
                String[] stringLikeArray = line.split(";");
                String username = stringLikeArray[3];
                    if (Objects.equals(usernameToLoad, username)) {
                        System.out.println("Subject: " + stringLikeArray[4] + "\n" +
                                "Time of writing: " + stringLikeArray[5] + "\n" +
                                stringLikeArray[0] + "\n"
                                + stringLikeArray[1] + "\n" +
                                stringLikeArray[2] + "\n");
                        isNameFound = true;
                    }



            }
        } catch (FileNotFoundException e) {
            System.out.println("File could not be found!");
            e.printStackTrace();
        }
    }
}
