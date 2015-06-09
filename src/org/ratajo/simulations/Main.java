package org.ratajo.simulations;
import java.util.ArrayList;
import java.util.List;

import org.ratajo.objects.*;
import org.ratajo.randoms.*;
public class Main {
	
	public static double no_of_samples=0;
	public static double cur_time=0;
	public static List<Customer> servedCustomers = new ArrayList<Customer>();
	public static double total_Q_size=0;
	public static void main(String args[])
	{
		Simulator sim = new SimulatorMM4(10,3);
		sim.simulate();
		double total_waiting_time=0;
		double total_time = 0;
		for(int i=0;i<servedCustomers.size();++i)
		{
			Customer c = servedCustomers.get(i);
			total_waiting_time+=(c.service_entrance_time-c.arrival_time);
			total_time+=(c.departure_time-c.arrival_time);
		}
		double total_customer = servedCustomers.size();
		System.out.print((total_Q_size/no_of_samples)+"\n");
		
		double avg_time = total_time/((double)servedCustomers.size());
		System.out.println(avg_time);
		
		System.out.println((total_waiting_time/((double)servedCustomers.size())));
		
	}

}
