package hm2;

import java.util.List;

public class ConcreteStrategyQueue implements Strategy{
        SimLogger logger;
        public ConcreteStrategyQueue(SimLogger logger)
        {
            this.logger = logger;
        }
        
	@Override
	public boolean addTask(List<Server> servers, Task t, int maxTasksPerServer) {		
		//pick server with shortest queue (smin)
                Server smin = null;
                int min = Integer.MAX_VALUE;                
                for(Server s : servers)
                {
                    int qlen = s.getQueueLen();
                    //if empty queue, use it
                    if(qlen == 0)
                    {                        
                        smin = s;                        
                        break;
                    }
                    
                    if(min > qlen)
                    {                        
                        min = qlen;
                        smin = s;                        
                    }
                }

                if(smin.getTasks().size() >= maxTasksPerServer)
                    return false;
                
                //add task to server
                smin.addTask(t);
                return true;
	}

}
