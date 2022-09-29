/**
 * @author Hudson Wesel
 * GameEngine for MadLibs
 */

import java.io.*;
import java.util.Scanner;
import java.lang.Thread;

public class Madlibs {
    
    // private boolean isPlaying = false;
    // Creates scanner object
    private Scanner scanner = new Scanner(System.in); 
    private String answer;

    /**
     * 
     * @param question
     * @return <String> Question asked to user
     */
    
    
    public String askQuestion(String question){
        System.out.print(question);
        answer = scanner.nextLine();

        return "InputtedAnswer"; // Use Scanner to get answer
    }





    /**
     * Replaces filler words with inputtedAnswer
     * @param inputtedAnswer
     * @return <String> story
     */

     public void addWord(String inputtedAnswer) {
        

     }

    public String writeStory(){
        // Find the place where answer should be inputted 
        // Return story
        return "THE STORY";
    }

    public void sleepThread(){
        try {
            Thread.sleep(4000);            
        } catch (InterruptedException e  ) {
            System.out.println("ERROR: Thread Interuption Quitting...");

        }
    }

    public static void main(String[] args) {

        System.out.println("Welcome to MadLibs...."); 


            
        }
    }
    




    

