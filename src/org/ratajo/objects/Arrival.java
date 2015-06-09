package org.ratajo.objects;

import org.ratajo.randoms.RandomNumberGenerator;
import org.ratajo.simulations.Main;
import org.ratajo.simulations.Simulator;

public class Arrival extends Event{
	public int type;
	public double lamda;
	public Arrival(double arrival_time2, double lamda2,int type) {
		this.arrival_time = arrival_time2;
		this.lamda = lamda2;
		this.type = type;
		this.eventType="Arrival";
	}
	@Override
	public double process(Simulator sim) {
	
		
		double inter_arrival_time = sim.r.getExponential(lamda);
		Event next_arrival = new Arrival(arrival_time+inter_arrival_time,lamda,this.type);
		sim.events.add(next_arrival);
		
		Customer c = new Customer(arrival_time,type);
		/**
		 * find min len queue and add customer at that Queue
		 */
		simQueue minQ  = null;
		for(int i=0;i<sim.queues.size();++i)
		{
			simQueue cur = sim.queues.get(i);
			if(cur.type == type &&(minQ == null || cur.customers.size() < minQ.customers.size()))
				minQ = cur;
			
		}
		minQ.customers.add(c);
		
		
		Main.cur_time = arrival_time;
		return arrival_time;
		
	}
	
	
}
