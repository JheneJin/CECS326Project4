/**
 * FCFS scheduling algorithm.
 */
 
import java.util.*;

public class FCFS implements Algorithm { 
    CPU cpu;
    LinkedList<Task> queue;
    //FCFS Constructor
    public FCFS (List<Task> queue) {
        this.cpu = new CPU();
        this.queue = new LinkedList<>(queue);
    }

    public void schedule() {
        Task currentTask;
        int burstTime; 
        //initalize queue size
        int originalQueueSize = queue.size();


        for (int i=0; i < originalQueueSize; i++){
            //picks the next task as the current task
            currentTask = pickNextTask();
            //gets burst time of the task
            burstTime = currentTask.getBurst();

            //execute the current task using CPU
            cpu.run(currentTask, burstTime);

            //remove the task from queue after its completion
            Task finishTask = queue.removeFirst();
            System.out.println("Task " + finishTask.getName() + " finished\n");
        }
    }
 
    //gets the next task from the queue
    public Task pickNextTask() {
        Task task = queue.get(0);
        return task;
    }
}
