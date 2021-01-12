package hm2;

import java.util.List;

import hm2.Server;

public interface Strategy {
	
	public boolean addTask(List<Server> servers,Task t, int maxTasksPerServer);

}
