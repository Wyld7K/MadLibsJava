/**
 * @author Hudson Wesel
 * GameEngine for MadLibs
 */
public class GameRunner {
    
    // private boolean isPlaying = false;
    private int numLines; // number of lines
    private String[] inputtedAnswers = new String[9];
    // public static int replaceIntIndex
    public String askQuestion(String question){
        System.out.println(question);
        return "InputtedAnswer"; // Use Scanner to get answer
    }
    /**
     * Getters
     * @return int numLines
     */
    public int getNumLines(){
        return numLines;
    }

    /**
     * Replaces filler words with inputtedAnswer
     * @param inputtedAnswer
     * @return String story
     */

     public void addWord(String inputtedAnswer) {

     }

    public String writeStory(){
        // Find the place where answer should be inputted 
        // Return story
        return "THE STORY";
    }
   
    public static void main(String[] args) {
        String answer;
        System.out.println("Welcome to MadLibs...."); 
                    
        // for (int i = 0; i <= GameRunner.getNumLines(); i++) {
            //Ask Question
            // answer = GameRunner.askQuestion("My Question");
            // Re-Write Story



            
        }


    }
    
}
