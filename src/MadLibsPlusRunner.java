
/**
 * @author Hudson Wesel
 * @version 1.0.0
 * 
 */

import java.lang.Thread;

public class MadLibsPlusRunner {

    public static void main(String[] args) {
        Madlibs.main(args);
        try {
            Thread.sleep(7000);

        } catch (Exception e) {
            System.out.println(e);
            // TODO: handle exception
        }
        System.out.print("\033[H\033[2J");
        System.out.println("STARTING SIMPLE FACTS");
        SimpleFacts.main(args);

    }

}
