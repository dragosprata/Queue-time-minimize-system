package hm2;

import java.util.List;

import hm2.Scheduler.SelectionPolicy;
import hm2.SimulatorFrame;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class SimulationManager implements Runnable{
	

        //data modifiable from UI
        public int timeLimit = 100; //simulation interval - sec
        public int minArrInterval = 1; //sec
        public int maxArrInterval = 6; //sec
        public int minProcessingTime = 5; //sec  (aka service time)
        public int maxProcessingTime = 30; //sec (aka service time)
        public int initialServersNum = 3;
        public int maxTasksPerServer = 10;
        public SelectionPolicy selectionPolicy = SelectionPolicy.SHORTEST_QUEUE;       
			
	//entity responsible with queue management and client distribution
	private Scheduler scheduler;
	
        //frame for displaying simulation
	private SimulatorFrame frame;
	//pool of tasks (client shopping in the store)
	private List<Task> generatedTasks;
        
        private long initialTime;//sec
        private SimLogger logger;
        
public void setLogger(SimLogger logger)       
{
    this.logger = logger;
}
public int getAvgWaitingPeriod()
{
    int avg=0;
    List<Server> servers = scheduler.getServers();
    for(Server s : servers)
    {
        avg += s.getWaitingPeriod();
    }
    avg /= servers.size();
    
    return avg;
}

//mean of service time for all tasks in all servers
public int getAvgServiceTime()
{
    int avg=0;
    int cnt=0;
    List<Server> servers = scheduler.getServers();
    for(Server s : servers)
    {
        BlockingQueue<Task> tasks = s.getTasks();
        for(Task t : tasks)
        {
            avg += t.getProcessingTime();
            cnt++;
        }
    }
    if(cnt==0)
        return 0;
    
    return avg/cnt;
}
public long getEmptyQueueTimePerc()
{
    long avg=0;
    List<Server> servers = scheduler.getServers();
    for(Server s : servers)
        avg += s.getEmptyQueueTime();
    avg /= servers.size();
    
    long crtSimTime = System.currentTimeMillis()/1000 - this.initialTime;
    return 100 * avg / crtSimTime;
}
public void addServerAndRedistributeTasks()
{
    scheduler.addServerAndRedistributeTasks();
}
@Override
public void run() {
                    
        //get initial time
        this.initialTime = System.currentTimeMillis()/1000;
        this.logger.setInitialTime(initialTime);
        
        //init a few Servers
        scheduler = new Scheduler(initialServersNum, maxTasksPerServer, selectionPolicy, logger);

        int taskID = 1;
                
        if( System.currentTimeMillis()/1000 - initialTime < timeLimit )
            logger.log("Store opens doors for "+this.timeLimit+ " seconds" );
        //generate Clients at random intervals
        while( System.currentTimeMillis()/1000 - initialTime < timeLimit )
        {            
            
            //generate client
            Task t = new Task(System.currentTimeMillis()/1000, //arrivalTime in seconds
                    this.minProcessingTime,
                    this.maxProcessingTime,
                    taskID++);
            
            //send client to some queue
            boolean dispatch = scheduler.dispatchTask(t);
            if(!dispatch)
                logger.log("Client "+ t.id + " found queue too long and left");
            
            //wait a random interval
            //generate random waitPeriod in interval (minArrInterval..maxArrInteval) seconds
            Random rand = new Random();
            int waitPeriod = rand.nextInt(maxArrInterval-minArrInterval)+minArrInterval; 
            try {
                Thread.sleep(1000 * waitPeriod);
            } catch (InterruptedException ex) {
                JOptionPane.showMessageDialog(null, "Sleep error");
            }
        }
        
        logger.log("Store closes");
        
}
public void changeStrategy(SelectionPolicy policy){
    scheduler.changeStrategy(policy);
}
public List<Server> getServers(){
	return scheduler.getServers();
}

}

