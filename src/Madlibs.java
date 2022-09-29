
/**
 * @author Hudson Wesel
 * GameEngine for MadLibs
 */

import java.io.*;
import java.util.*;
import java.util.Scanner;
import java.lang.Thread;

public class Madlibs {
    // ========VARIABLES========
    private String story;
    private String userAnswer;

    private Scanner scanner = new Scanner(System.in);

    private ArrayList<String> answers = new ArrayList<String>();

    // ========METHODS========

    // ========CONSTRUCTOR========
    /**
     * Madlibs constructor method
     * 
     * @param story
     */

    public Madlibs(String story) {
        this.story = story;
    }

    // =====askQuestion method=====
    /**
     * Postcondition: questions user, recieves input from user, calls user method
     * 
     * @param {question} //Question asked to user
     */

    public void askQuestion(String question) {
        System.out.print(question);
        userAnswer = scanner.nextLine();
        addAnswer(userAnswer);
    }

    // =====addAnswer Method=====
    /**
     * Postcondition: adds inputted answer from askQuestion to ArrayList answers
     * 
     * @param {inputtedAnswer} answer from user in askQuestion method
     */

    private void addAnswer(String inputtedAnswer) {
        answers.add(userAnswer);
    }

    // =====printAnswers Method=====
    /**
     * Postcondition: Prints all inputted answers from user
     */

    public void printAnswers() {
        System.out.println("Your Answers Were: " + answers);
    }

    public void printStory() {
        for (String answer : answers) {
            story = story.replace("FILLER", answer);
        }

        System.out.println(story);
    }

    // =====sleepThread Method=====
    /**
     * Postcondition: Pauses threads from processing code for 4 seconds
     * 
     * @param {time} duration of thread sleep
     */

    public void sleepThread(int time) {
        // Thread.sleep() must be wrapped in try/catch to run without error
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            System.out.println("ERROR: Thread Interuption Quitting...");

        }
    }

    public static void main(String[] args) {

        String story1 = "FILLER is on a quest FILLER their buddies and needs your help!" +
                "Your cautious so will bring a FILLER to help you on your quest!" +
                "You begin your search at FILLER";

        Madlibs game = new Madlibs(story1);

        System.out.println("Welcome to MadLibs & Prepare For Adventure!");
        game.sleepThread(500);
        System.out.println("Starting Game...");
        game.sleepThread(1000);

        // =======MADLIBS QUESTIONS=======
        game.askQuestion("Please Give Me A Name 📇: ");
        game.askQuestion("Please Give Me An Infinitive formatted (to VERB)✏️: ");

        game.askQuestion("Please Give Me A Noun ❇️: ");
        game.askQuestion("Please Give Me A Place 🏝: ");

        game.printStory();

        game.printAnswers();

    }
}
