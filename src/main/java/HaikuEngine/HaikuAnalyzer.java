package HaikuEngine;

import HaikuApplication.Write;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Scanner;

public class HaikuAnalyzer {
    private Scanner scanner = new Scanner(System.in);
    private String firstLine;
    private String secondLine;
    private String thirdLine;
    private ArrayList<Character> firstLineToAnalyze = new ArrayList<Character>();
    private ArrayList<Character> secondLineToAnalyze= new ArrayList<Character>();
    private ArrayList<Character> thirdLineToAnalyze= new ArrayList<Character>();
    private String saveName;
    private String subject;
    private int syllableCounter;

    public HaikuAnalyzer(String firstLine, String secondLine, String thirdLine, String saveName, String subject) {
        this.firstLine = firstLine;
        this.secondLine = secondLine;
        this.thirdLine = thirdLine;
        this.saveName = saveName;
        this.subject = subject;
    }

    public void setSaveName() {
        this.saveName = scanner.nextLine();
    }

    public void setSubject() {
        this.subject = scanner.nextLine();
    }

    public void setFirstLine(String firstLine) {
        try {
            do {
                firstLine = scanner.nextLine();

                for (int i = 0; i < firstLine.length(); i++) {
                    firstLineToAnalyze.add(firstLine.charAt(i));
                }

                for (char i = 0;
                     i < firstLineToAnalyze.size(); i++) {
                    char j = firstLineToAnalyze.get(i);
                    if (j == 'a' || j == 'e' || j == 'y' || j == 'u' || j == 'i' || j == 'o') {
                        syllableCounter++;
                        char l = firstLineToAnalyze.get(i + 1);
                        if (j == l) {
                            syllableCounter--;
                        }

                    }
                }
                if (syllableCounter != 5 && syllableCounter != 0) {

                    syllableCounter = 0;
                    firstLine = "";
                    firstLineToAnalyze = new ArrayList<Character>();
                    System.out.print("Try again:");
                }
            } while (syllableCounter != 5);

            syllableCounter = 0;
            this.firstLine = firstLine;
        } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            System.out.println("Too many duplicate letters!");
        }
    }
    public void setSecondLine(String secondLine) {
        try {
        syllableCounter = 0;
        do {
            secondLine = scanner.nextLine();
        for (int i = 0; i < secondLine.length(); i++) {
            secondLineToAnalyze.add(secondLine.charAt(i));
        }
            for (char i = 0;
                 i < secondLineToAnalyze.size(); i++) {
                char j = secondLineToAnalyze.get(i);
                if (j == 'a' || j == 'e' || j == 'y' || j == 'u' || j == 'i' || j == 'o') {
                    syllableCounter++;
                    char l = secondLineToAnalyze.get(i+1);
                    if (j == l) {
                        syllableCounter--;
                    }
            }
        } if (syllableCounter != 7 && syllableCounter !=0) {

                syllableCounter = 0;
                secondLine = "";
                secondLineToAnalyze = new ArrayList<Character>();
                System.out.print("Try again:");
            }
        }while (syllableCounter != 7);

        syllableCounter = 0;
        this.secondLine = secondLine;
    } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
        System.out.println("Too many duplicate letters!");
    }
    }

    public void setThirdLine(String thirdLine) {
        try {
        syllableCounter = 0;
        do {
            thirdLine = scanner.nextLine();
            for (int i = 0; i < thirdLine.length(); i++) {
                thirdLineToAnalyze.add(thirdLine.charAt(i));
            }
            for (char i = 0; i < thirdLineToAnalyze.size(); i++) {
                char j = thirdLineToAnalyze.get(i);
                if (j == 'a' || j == 'e' || j == 'y' || j == 'u' || j == 'i' || j == 'o') {
                    syllableCounter++;
                    char l = thirdLineToAnalyze.get(i+1);
                    if (j == l) {
                        syllableCounter--;
                    }}
            } if (syllableCounter != 5 && syllableCounter !=0) {

                syllableCounter = 0;
                thirdLine = "";
                thirdLineToAnalyze = new ArrayList<Character>();
                System.out.print("Try again:");
            }
        }while (syllableCounter != 5);
    } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
        System.out.println("Too many duplicate letters!");
    }
        syllableCounter = 0;
        this.thirdLine = thirdLine;
        Write write = new Write();
        write.writerToFile(this.firstLine + ";" + this.secondLine + ";" + this.thirdLine + ";" + this.saveName + ";"
        + this.subject + ";" + new Timestamp(System.currentTimeMillis()));
    }

}

