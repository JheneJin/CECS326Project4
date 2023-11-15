/**
 * Non-preemptive priority scheduling algorithm using RR.
 *
 * This algorithm will run tasks according to round-robin scheduling.
 */
 
import java.util.*;

public class RR implements Algorithm { 
    CPU cpu;
    LinkedList<Task> queue;

    public RR (List<Task> queue) {
        this.cpu = new CPU();
        this.queue = new LinkedList<>(queue);
    }

    public void schedule() {
        Task currentTask;
        Task newTask;
        int burstTime;
        int newBurstTime;
        int originalQueueSize = queue.size();


        while (queue.size() > 0){
            currentTask = pickNextTask();
            burstTime = currentTask.getBurst();
            
            if (burstTime > 10 && queue.size() > 1) {
                burstTime = 10;
            }

            cpu.run(currentTask, burstTime);

            newBurstTime = currentTask.getBurst() - burstTime;
            currentTask.setBurst(newBurstTime);

            queue.addLast(currentTask);
            queue.removeFirst();

            if (newBurstTime < 1) {
                queue.removeLast();
                System.out.println("Task finished\n");
            }
        }
    }

    public Task pickNextTask() {
        Task task = queue.get(0);
        return task;
    }
}
