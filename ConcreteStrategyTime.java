package hm2;

import java.util.List;

public class ConcreteStrategyTime implements Strategy{

	@Override
	public boolean addTask(List<Server> servers, Task t, int maxTasksPerServer) {
		//pick server with shortest waitingPeriod
		Server smin = null;
                long min = Long.MAX_VALUE;
                for(Server s :  servers)
                {
                    long wp = s.getWaitingPeriod(); 
                    if(min > wp)
                    {
                        min = wp;
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
