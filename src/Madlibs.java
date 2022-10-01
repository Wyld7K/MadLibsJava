
/**
 * @author Hudson Wesel
 * @version 1.0.0
 * GameEngine for MadLibs
 */

import java.io.*;
import java.util.*;
import java.util.Scanner;
import java.lang.Thread;
import java.lang.Math;

public class Madlibs {
    // ========VARIABLES========
    private String story;
    private String userAnswer;

    // private boolean isPlayingRiddle;
    private String riddle;
    private String riddleAnswer;
    private int numRiddleAttempts;
    private String inputtedRiddleAnswer;

    private Scanner scanner = new Scanner(System.in);

    private ArrayList<String> answers = new ArrayList<String>();

    // ========METHODS========

    // ========CONSTRUCTOR========
    /**
     * Madlibs constructor method
     * 
     * @param story
     */

    public Madlibs() {
        this.numRiddleAttempts = 2;
        this.inputtedRiddleAnswer = "";

    }

    public Madlibs(String story) {
        this.story = story;
        this.numRiddleAttempts = 0;

    }

    // ===========RIDDLE LOGIC===========

    // public void setIsPlayingRiddle() {
    // this.isPlayingRiddle = !this.isPlayingRiddle;
    // }

    public void chooseRiddle() {
        // Picks number 1-3
        int selectedRiddleIndex = (int) (Math.random() * 3) + 1;

        if (selectedRiddleIndex == 1) {
            setRiddle("I\'m tall when I\'m young, and I\'m short when I\'m old. What am I?", "candle");

        } else if (selectedRiddleIndex == 2) {
            setRiddle("What can’t talk but will reply when spoken to?", "echo");

        } else if (selectedRiddleIndex == 3) {
            setRiddle("What has words, but never speaks?", "book");

        }

    }

    public void setRiddle(String riddle, String riddleAnswer) {
        this.riddle = riddle;
        this.riddleAnswer = riddleAnswer;

    }

    public void printRiddle() {
        System.out.println("Here is the riddle: " + this.riddle);
        System.out.println("Just print the word without any articles");
    }

    public void sleepMessage(String finalMessage) {
        System.out.print("Your answer is");
        sleepThread(1);
        System.out.print(".");
        sleepThread(1);
        System.out.print(".");
        sleepThread(1);
        System.out.println(".");
        sleepThread(1);
        System.out.println(finalMessage);
    }

    public void playRiddleGame() {

        chooseRiddle();
        printRiddle();
        System.out.print("Please Give Me Your First Answer: ");
        inputtedRiddleAnswer = scanner.nextLine();

        System.out.println();

        while (!inputtedRiddleAnswer.equals(riddleAnswer) && numRiddleAttempts > 0) {

            sleepMessage("Incorrect");
            sleepThread(2);
            numRiddleAttempts--;

            if (numRiddleAttempts != 0) {
                System.out.println("Number of Attemps Remaining: " + numRiddleAttempts);
                System.out.print("Please give me an answer: ");
                inputtedRiddleAnswer = scanner.nextLine();

            }

        }
        // Finishes Riddle
        if (numRiddleAttempts > 0) {
            sleepMessage("CORRECT✅!");
            sleepThread(1);
            System.out.println("HOW DID YOU DO IT? Here's your trophy!🏆");

            // Play cool cound effect
            // Print answers & Facts
            // Should break out of riddleGame();
            return;

        } else {
            System.out.println("It's okay, try again next time!");
            sleepThread(2);
            System.out.println("I won't give you the answer though. Play Again!");
            sleepThread(2);
            return;
            // play again()

        }

    }

    // ===========MADLIBS LOGIC===========
    /**
     * Postcondition: Setst the story attribute to a String story
     * 
     * @param story
     */

    // =====askQuestion method=====
    /**
     * Postcondition: questions user, recieves input from user, calls user method
     * 
     * @param {question}
     *                   //Question asked to user
     */

    public void askQuestion(String question) {
        System.out.print(question);

        this.userAnswer = scanner.nextLine();

        addAnswer();
    }

    // =====getElement Method=====
    /** */

    public String getElement(int index) {
        return answers.get(index);
    }

    // =====addAnswer Method=====
    /**
     * Postcondition: adds inputted answer from askQuestion to ArrayList answers
     * 
     * @param {inputtedAnswer}
     *                         answer from user in askQuestion method
     */

    private void addAnswer() {
        answers.add(this.userAnswer);

    }

    // =====printAnswers Method=====
    /**
     * Postcondition: Prints all inputted answers from user
     */

    public void printAnswers() {
        System.out.println("Your Answers Were: " + answers);
    }

    public void printStory(String story) {
        for (String answer : answers) {
            story = story.replace("FILLER", answer);
        }

        System.out.println(story);
    }

    // =====sleepThread Method=====
    /**
     * Postcondition: Pauses threads from processing code for 4 seconds
     * 
     * @param {time}
     *               duration of thread sleep
     */

    public void sleepThread(int time) {
        // Thread.sleep() must be wrapped in try/catch to run without error
        try {
            Thread.sleep(time * 1000);
        } catch (InterruptedException e) {
            System.out.println("ERROR: Thread Interuption Quitting...");

        }
    }

    public static void main(String[] args) {

        Madlibs game = new Madlibs();
        System.out.print("\033[H\033[2J");
        System.out.println("Welcome to MadLibs & Prepare For Adventure!");
        game.sleepThread(2);
        System.out.println("Starting Game...");
        game.sleepThread(2);

        // =======MADLIBS QUESTIONS======= Use For loop

        game.askQuestion("Please Give Me A Name 📇: ");
        game.askQuestion("Please Give Me An Infinitive formatted (to VERB)✏️: ");

        game.askQuestion("Please Give Me A Noun ❇️: ");
        game.askQuestion("Please Give Me A Place 🏝: ");
        game.askQuestion("Please Give Me A Animal🐱: ");
        game.askQuestion("Please Give Me A Name❡: ");
        game.askQuestion("Please Give Me Another Animal🐱: ");
        game.askQuestion("Please Give Me An Evil Villian Name😈 : ");
        game.askQuestion("Please Give Me A Criminal Offense💀: ");
        // ok
        game.askQuestion("DID THE GAME WORK?: ");

        // Riddle Game happens

        String storyPartOne = "FILLER is on a quest FILLER their buddies and needs your help!" + "\n" +
                "Your cautious so will bring a FILLER to help you on your quest!" + "\n" +
                "You begin your search in FILLER and you find a FILLER! " + "\n" +
                "You name it FILLER and it's hungry for some FILLER and" +
                game.getElement(6) + "\n" +

                "After it was full. You go to help the buddies of" + game.getElement(0) +
                "\n" +
                "Turns out an evil character named FILLER who comitted FILLER " + "\n" +
                "Also " + game.getElement(8) + " has kidnapped the buddies of " +
                game.getElement(0);

        String storyPartTwo = "HAHAHAHHAHAA YOU\"VE MADE IT TO THE END " + game.getElement(8) + " Laughs!"
                + "\n" +
                "\"You will never solve my riddle!\"";

        game.printStory(storyPartOne);
        game.sleepThread(6);
        System.out.println();

        game.printStory(storyPartTwo);

        game.playRiddleGame();

        game.printAnswers();

        // Make feature that randomizes the now set answers and makes a new story

    }

    // Object with one phrase and answer

}
