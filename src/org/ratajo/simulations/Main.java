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
	public static void clear()
	{
		no_of_samples=0;
		cur_time=0;
		servedCustomers = new ArrayList<Customer>();
		total_Q_size=0;
	}

	public static void main(String args[]) {
		double times = 9;
		double W=0,Wq=0;
		
		double lamda = 39, mu = 10;
		while (times < 10.0) {
			clear();
			Simulator sim = new SimulatorMM4(39, 10);
			sim.simulate();
			double total_waiting_time = 0;
			double total_time = 0;
			for (int i = 0; i < servedCustomers.size(); ++i) {
				Customer c = servedCustomers.get(i);
				total_waiting_time += (c.service_entrance_time - c.arrival_time);
				total_time += (c.departure_time - c.arrival_time);
			}
			double total_customer = servedCustomers.size();

			W += total_time / ((double) servedCustomers.size());
			Wq += total_waiting_time / ((double) servedCustomers.size());
			++times;
		}
		double Lq = lamda * (Wq/1);
		double L = lamda * (W/1);
		System.out.println(L);

		System.out.println(Lq);

	}

}
