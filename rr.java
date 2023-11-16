/**
 * Non-preemptive priority scheduling algorithm using RR.
 *
 * This algorithm will run tasks according to round-robin scheduling.
 */
 
import java.util.*;

public class RR implements Algorithm { 
    CPU cpu;
    LinkedList<Task> queue;

    //RR constructor
    public RR (List<Task> queue) {
        this.cpu = new CPU();
        this.queue = new LinkedList<>(queue);
    }


    public void schedule() {
        Task currentTask;
        Task newTask;
        int burstTime;
        int newBurstTime;
        //initalize queue size
        int originalQueueSize = queue.size();


        while (queue.size() > 0){
            //picks the next task as the current task
            currentTask = pickNextTask();
            //gets burst time of the task
            burstTime = currentTask.getBurst();
            
            // when burst time is greater than 10 and the queue size is bigger than 1, limit burst time to 10
            if (burstTime > 10 && queue.size() > 1) {
                burstTime = 10;
            }

            //execute the current task using CPU
            cpu.run(currentTask, burstTime);

            //calculate the new burst time after execution
            newBurstTime = currentTask.getBurst() - burstTime;
            //updates the current task with a new burst time
            currentTask.setBurst(newBurstTime);
            
            //places the task back into the queue
            queue.addLast(currentTask);
            // removes the executed task from the front of the queue
            queue.removeFirst();

            if (newBurstTime < 1) {
                //remove the task from queue after its completion
                Task finishTask = queue.removeLast();
                System.out.println("Task " + finishTask.getName() + " finished\n");
            }
        }
    }

    //gets the next task from the queue
    public Task pickNextTask() {
        Task task = queue.get(0);
        return task;
    }
}
