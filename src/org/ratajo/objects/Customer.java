package org.ratajo.objects;

public class Customer {
	public Customer(double arrival_time2, int type2) {
		this.arrival_time = arrival_time2;
		this.type = type2;
	}
	public double arrival_time;
	public double departure_time;
	public double service_entrance_time;
	int type;
	public String toString()
	{
		return "Entrance: "+arrival_time+"\n"
				+"service: "+service_entrance_time+"\n"
				+"departure: "+departure_time+"\n";
		
	}
	
}
