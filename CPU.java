/**
 * "Virtual" CPU
 *
 * This virtual CPU also maintains system time.
 *
 * @author Greg Gagne - March 2016
 */
 
public class CPU {
    /**
     * Run the specified task for the specified slice of time.
     */
    public static void run(Task task, int slice) {
        System.out.println("Will run " + task);
        pause(slice);
    }
    // pause program
    private static void pause(int slice) {
        long timestamp = System.currentTimeMillis();
        
        //pauses program using miliseconds
        while (System.currentTimeMillis() < timestamp + slice) {
        }
        return;
    }
}
