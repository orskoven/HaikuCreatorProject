package UI;

import HaikuApplication.PDFconverter;
import HaikuApplication.Read;
import HaikuEngine.HaikuAnalyzer;
import com.itextpdf.text.DocumentException;

import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Menu {
    static Scanner scanner = new Scanner(System.in);
    static String idUserNameInput;
    static String haikuSubject;
    static String firstLine;
    static String secondLine;
    static String thirdLine;
    static int userChoice = 0;
    static HaikuAnalyzer haikuAnalyzer = new HaikuAnalyzer(firstLine,secondLine,
            thirdLine,idUserNameInput,haikuSubject);
    static Read read = new Read();
    static PDFconverter pdFconverter = new PDFconverter();
    static int loadAttempts = 0;

    public static <noSuchElementException> void main(String[] args) throws InterruptedException, DocumentException, FileNotFoundException {
        do {
            SoundPlayer.play(".idea/Haiku/haikusounds.wav");
            MenuVisualization.main();
            System.out.println("What would you like to do?");

            System.out.println("• Press 1 - CREATE A HAIKU POEM\n• Press 2 - LOAD A HAIKU POEM" +
                    "\n• Press 3 - CONVERT HAIKU POEM TO PDF" +
                    "\n________________________________");
            userChoice = Integer.parseInt(scanner.nextLine());

            if (userChoice == 1) {

                System.out.print("Please type your name:");
                haikuAnalyzer.setSaveName();

                System.out.print("Please type a subject for the poem:");
                haikuAnalyzer.setSubject();

                System.out.print("Please type your first line:");
                haikuAnalyzer.setFirstLine(firstLine);

                System.out.print("Please type your second line:");
                haikuAnalyzer.setSecondLine(secondLine);

                System.out.print("Please type your third line:");
                haikuAnalyzer.setThirdLine(thirdLine);

            } else if (userChoice == 2) {
                try {
                    read.getPoem();
                } catch (NoSuchElementException noSuchElementException) {
                    try {
                        System.out.print("Please make another attempt!" + "\n");
                        read.getPoem();
                    } catch (NoSuchElementException noSuchElementException1) {
                        System.out.print("Please reload!");
                    }

                }
              } else if (userChoice == 3) {
               pdFconverter.getPoemConverted();

            }
        }while (userChoice != 1 && userChoice != 2 && userChoice != 3) ;

        }
}

