package org.ratajo.objects;

import org.ratajo.simulations.Main;
import org.ratajo.simulations.Simulator;

public class Departure extends Event {

	Server s;
	public double departure_time;
	public Departure(Server s,double departure_time)
	{
		this.eventType = "Departure";
		this.arrival_time = departure_time;
		this.departure_time = departure_time;
		this.s = s;
		s.status = 0;
		
	}
	@Override
	public double process(Simulator sim) {
		
		//System.out.println("in departure");
		s.status = 1;
		Main.cur_time = departure_time;
		return 0;
	}

}
