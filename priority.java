/**
 * Non-preemptive priority scheduling algorithm.
 */
 
import java.util.*;

public class Priority implements Algorithm { 
    CPU cpu;
    LinkedList<Task> queue;

    public Priority (List<Task> queue) {
        this.cpu = new CPU();
        //sorts priority from greatest to least 
        queue.sort((t1, t2) -> Integer.compare(t2.getPriority(), t1.getPriority()));
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

            queue.removeFirst();
            System.out.println("Task finished\n");
        }
    }

    public Task pickNextTask() {
        Task task = queue.get(0);
        return task;
    }
}
