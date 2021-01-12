package hm2;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server implements Runnable{

    //clients queue
    private BlockingQueue<Task> tasks;
    //current total time needed for all clients in queue (seconds)
    private AtomicLong waitingPeriod;
    //total time the queue is empty
    private AtomicLong emptyQueueTime; // milliseconds !!!

    int id;
    SimLogger logger;
    
    public Server(int id, SimLogger logger){
                        
            this.id = id;
            this.logger = logger;
        
            //initialize queue 
            tasks = new ArrayBlockingQueue<Task>(100);
            
            waitingPeriod = new AtomicLong(0);            
            emptyQueueTime = new AtomicLong(0);
            
    }

    public void addTask(Task newTask){
        
        //add task to queue
        tasks.add(newTask);        
        
        //increment the waiting
        waitingPeriod.set(waitingPeriod.get() + newTask.getProcessingTime());
        
        logger.log("Client "+ newTask.id + " with serv time "+ newTask.getProcessingTime() + " goes to queue "+this.id);
    }
    
    public int getQueueLen()
    {
        return tasks.size();
    }
    
    public long getWaitingPeriod()
    {
        return this.waitingPeriod.get();
    }
	
    //seconds
    public long getEmptyQueueTime()
    {
        return this.emptyQueueTime.get()/1000;
    }
    public void run() {
	while(true){
            
                //if tasks exist
		if(!tasks.isEmpty())
                {
                    //consider oldest task from queue
                    Task t = tasks.peek();
                    
                    try {
                        //stop the thread for a time equal with the task's processing time
                        Thread.sleep(t.getProcessingTime()*1000); //sec to millisec                        
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();//if someone kills thread 
                    }
                    
                    logger.log("Client "+ t.id + " leaves queue "+this.id);
                    
                    //remove task from queue
                    tasks.remove();                          
                    
                    //decrement the waitingPeriod with the processingTime of the task
                    this.waitingPeriod.set(this.waitingPeriod.get() - t.getProcessingTime());
                }
                else
                {
                    try {
                        Thread.sleep(200); //ms
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();//if someone kills thread 
                    }
                    this.emptyQueueTime.set(this.emptyQueueTime.get() + 200);
                }
	}	
}
	
public BlockingQueue<Task> getTasks(){
    return tasks;	
}	

}
