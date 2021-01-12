package hm2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Scheduler {
	private List<Server> servers;	
	private int maxTasksPerServer;
        private int serverCnt;
	private Strategy strategy;

        SimLogger logger;
        
public Scheduler(int initialServersNum, int maxTasksPerServer, SelectionPolicy policy, SimLogger logger){
 
        this.logger = logger;
        this.maxTasksPerServer = maxTasksPerServer;        
        changeStrategy(policy); //init strategy object
        
        
        //init server list
        servers = new ArrayList<Server>();
        for(int i=1; i<=initialServersNum; i++)
        {
            Server s = new Server(i, logger);
            servers.add(s);
            //launch server
            Thread t = new Thread(s);
            t.start();
        }
        this.serverCnt = initialServersNum;
}

public enum SelectionPolicy{
	SHORTEST_QUEUE,SHORTEST_TIME
}

public void changeStrategy(SelectionPolicy policy){
	//apply strategy patter to instantiate the strategy with the concrete
	//strategy corresponding to policy
	if(policy == SelectionPolicy.SHORTEST_QUEUE){
		strategy = new ConcreteStrategyQueue(logger);
	}
	if(policy == SelectionPolicy.SHORTEST_TIME){
		strategy = new ConcreteStrategyTime();
	}
}

public boolean dispatchTask(Task t){	        
    return strategy.addTask(servers, t, maxTasksPerServer);
}

public List<Server> getServers(){
	return servers;
}

public long getAverageWaitingPeriod()
{    
    long avg = 0;
    
    for(Server s : servers)
        avg += s.getWaitingPeriod();
    
    avg /= servers.size();
    
    return avg;
}

public void addServerAndRedistributeTasks()
{
        //put all tasks in temporary queue (allTasks)        
        BlockingQueue<Task> allTasks = new ArrayBlockingQueue<Task>(100);        
        for(Server s : servers)
        {
            BlockingQueue<Task> tasks = s.getTasks();
            tasks.drainTo(allTasks);
        }
        
        //add new server
        this.serverCnt++;
        servers.add(new Server(this.serverCnt, logger));
        
        //redistribute tasks to all servers
        for(Task t: allTasks)
            this.dispatchTask(t);
}
}
