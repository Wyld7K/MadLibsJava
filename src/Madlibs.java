
/**
 * @author Hudson Wesel
 * @version 1.0.0
 * GameEngine for MadLibs
 */

import java.util.*;
import java.util.Scanner;
import java.lang.Thread;
import java.lang.Math;

public class Madlibs {
    // ========VARIABLES========

    private String userAnswer;

    // private boolean isPlayingRiddle;
    private String riddle;
    private String riddleAnswer;
    private int numRiddleAttempts;
    private String inputtedRiddleAnswer;

    private Scanner scanner = new Scanner(System.in);

    private ArrayList<String> answers = new ArrayList<String>();

    /********************
     * Methods
     *********************/

    /**
     * Madlibs constructor method
     * 
     * @param story
     */

    public Madlibs() {
        this.numRiddleAttempts = 2;
        this.inputtedRiddleAnswer = "";

    }

    /**********************
     * Game Riddle Engine
     *********************/
    /**
     * Postconditions: Chooses and sets random riddle and answer
     */

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

    /**
     * Postcondition: sets riddle and riddle's answer
     * 
     * @param riddle       Riddle question
     * @param riddleAnswer Riddle answer
     */

    public void setRiddle(String riddle, String riddleAnswer) {
        this.riddle = riddle;
        this.riddleAnswer = riddleAnswer;

    }

    /**
     * Postcondition: prints riddle
     */
    public void printRiddle() {
        System.out.println("Here is the riddle: " + this.riddle);
        System.out.println("Just print the word without any articles");
    }

    /**
     * Postcondition: Message printed to the user
     * 
     * @param finalMessage Message whether answer is correct
     */

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

    /**
     * Game riddle logic that determines when and if the player got the answer
     */
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

            return;

        } else {
            System.out.println("It's okay, try again next time!");
            sleepThread(2);
            System.out.println("I won't give you the answer though. Play Again!");
            sleepThread(2);
            return;

        }

    }

    /**********************
     * Madlibs Engine
     *********************/
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
     * 
     */

    public void askQuestion(String question) {
        System.out.print(question);

        this.userAnswer = scanner.nextLine();

        addAnswer();
    }

    // =====getElement Method=====
    /**
     * 
     * @param {index} Index of element
     * @return
     *         String element
     */

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

    /**
     * "FILLER" is replaces for each element from answers array list
     * 
     * @param story
     */

    // public void setStory(String story) {
    // this.story = story;
    // }

    public void printStory(String story) {
        System.out.println();
        System.out.println(story);
    }

    // =====sleepThread Method=====
    /**
     * Postcondition: Pauses threads from processing code for time seconds
     * 
     * @param {time}
     *               duration of thread sleep in seconds
     */

    public void sleepThread(int time) {
        // Thread.sleep() must be wrapped in try/catch to run without error
        try {
            Thread.sleep(time * 1000);
        } catch (InterruptedException e) {
            System.out.println("ERROR : " + e.getMessage());

        }
    }

    public static void main(String[] args) {

        Madlibs game = new Madlibs();

        // Clears console
        System.out.print("\033[H\033[2J");
        System.out.println("Welcome to a normal MadLibs & Prepare For Adventure!");
        game.sleepThread(2);
        System.out.println("Starting Game...");
        game.sleepThread(2);

        // =======MADLIBS QUESTIONS=======

        game.askQuestion("Please Give Me A Name 📇: ");
        game.askQuestion("Please Give Me An Infinitive formatted (to VERB)✏️: ");

        game.askQuestion("Please Give Me A Noun ❇️: ");
        game.askQuestion("Please Give Me A Place 🏝: ");
        game.askQuestion("Please Give Me A Animal🐱: ");
        game.askQuestion("Please Give Me Another Name❡: ");
        game.askQuestion("Please Give Me Another Animal🐱: ");
        game.askQuestion("Please Give Me An Evil Villian Name😈 : ");
        game.askQuestion("(PG) Please Give Me A Criminal Offense💀: ");

        // Basic Madlibs game
        String storyPartOne = game.getElement(0) + " is on a quest " + game.getElement(1) + " and" +
                " their buddies needs your help! " + "\n" +
                "Your cautious so you will bring a " + game.getElement(2) + " to help you on your quest! " + "\n" +
                "You begin your search in " + game.getElement(3) + " and you find a " + game.getElement(4) + "\n" +
                "You name it " + game.getElement(5) + " and it's hungry for some " +
                game.getElement(6) + "\n" +

                "After" + game.getElement(5) + "was full. You go to help the buddies of" + game.getElement(0) +
                "\n" +
                "Turns out an evil character named " + game.getElement(7) + " who comitted " + game.getElement(8) + "\n"
                +
                "Also kidnapped the buddies of " + game.getElement(0);
        game.getElement(0);

        // Riddle Game
        String storyPartTwo = "HAHAHAHHAHAA YOU\"VE MADE IT TO THE END " + game.getElement(7) + " Laughs!"
                + "\n" +
                "\"You will never solve my riddle!\"";

        // game.setStory(storyPartOne);
        game.printStory(storyPartOne);

        game.sleepThread(6);
        System.out.println();

        game.printStory(storyPartTwo);

        game.playRiddleGame();

        // Extra feature that prints all answers inputted from user
        game.printAnswers();

    }

}
