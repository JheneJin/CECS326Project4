/**
 * FCFS scheduling algorithm.
 */
 
import java.util.*;

public class FCFS implements Algorithm { 
    CPU cpu;
    LinkedList<Task> queue;

    public FCFS (List<Task> queue) {
        this.cpu = new CPU();
        this.queue = new LinkedList<>(queue);
    }

    public void schedule() {
        Task currentTask;
        int burstTime; 
        int originalQueueSize = queue.size();


        for (int i=0; i < originalQueueSize; i++){
            currentTask = pickNextTask();
            burstTime = currentTask.getBurst();

            cpu.run(currentTask, burstTime);

            Task finishTask = queue.removeFirst();
            System.out.println("Task " + finishTask.getName() + " finished\n");
        }
    }

    public Task pickNextTask() {
        Task task = queue.get(0);
        return task;
    }
}
