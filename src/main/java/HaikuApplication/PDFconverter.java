package HaikuApplication;


import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class PDFconverter {
    static Random random = new Random();
    static Scanner scanner = new Scanner(System.in);
    static boolean isNameFound;
    static int lineCounter = 0;
    static String poems = "";


    public void getPoemConverted() {
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
                    Document document = new Document();
                    PdfWriter.getInstance(document, new FileOutputStream(randomizer(0,1000)+"Haiku.pdf"));
                    document.open();
                    Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);
                    document.add( new Paragraph( "Subject: " + stringLikeArray[4] ) );
                    document.add( new Paragraph( "Time of writing: " + stringLikeArray[5] ) );
                    document.add( new Paragraph( stringLikeArray[0] ) );
                    document.add( new Paragraph( stringLikeArray[1] ) );
                    document.add( new Paragraph( stringLikeArray[2] ) );
                    document.close();

                    isNameFound = true;
                }


            }
        } catch (FileNotFoundException | DocumentException e) {
            System.out.println("File could not be found!");
            e.printStackTrace();
        }
    }

    public int randomizer(int min, int max){
        return random.nextInt(max-min+1)+min;
    }

}