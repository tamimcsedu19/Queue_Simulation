package org.ratajo.simulations;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import org.ratajo.objects.*;
import org.ratajo.randoms.RandomNumberGenerator;

public abstract class Simulator {
	public List<Server> servers;
	public List<simQueue> queues;
	public Queue<Event> events;
	public double lamda;
	public RandomNumberGenerator r;
	public abstract void init();
	public abstract void checkQ();
	Simulator()
	{
		queues = new ArrayList<simQueue>();
		servers = new ArrayList<Server>();
		Comparator<Event> comparator = new EventComparator();
		events = new PriorityQueue<Event>(100000,comparator);
		r = new RandomNumberGenerator();
	}
	public void simulate()
	{
		
		while(Main.cur_time < 10000)
		{
			
			Event cur = events.poll();
			if(cur.eventType.compareTo("Arrival") == 0)
				cur = (Arrival) cur;
			else
				cur = (Departure) cur;
			
			
			if(cur == null)
				break;
			else
				cur.process(this);
			
			checkQ();
		
		
		}
		
	}
	
	
	

}
