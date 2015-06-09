package org.ratajo.objects;

import org.ratajo.randoms.RandomNumberGenerator;
import org.ratajo.simulations.Simulator;

public abstract class Event {
	
	public double arrival_time;
	public String eventType;
	public abstract double process(Simulator sim);
}
