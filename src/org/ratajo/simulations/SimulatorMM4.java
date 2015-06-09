package org.ratajo.simulations;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import org.ratajo.objects.*;
import org.ratajo.randoms.RandomNumberGenerator;

public class SimulatorMM4 extends Simulator {

	double serverMu;
	public SimulatorMM4(double lamda,double serverMu)
	{
		super();
		this.lamda = lamda;
		this.serverMu = serverMu;
		for(int i=0;i<4;++i)
			servers.add(new Server(serverMu,0));
		queues.add(new simQueue(0));
		events.add(new Arrival(0,lamda,0));
		
	}
	@Override
	public void init() {
		
		
	}

	@Override
	public void checkQ() {
		
		
		Queue customerQ = queues.get(0).customers;
		if(customerQ.size() >0)
		{
			Server emptyServer = null;
			for(int i=0;i<servers.size();++i)
			{
				if(servers.get(i).status == 1)
					emptyServer = servers.get(i);
			}
			if(emptyServer!=null)
			{
				Customer c = (Customer) customerQ.poll();
				c.service_entrance_time = Main.cur_time;
				c.departure_time = emptyServer.getnext()+Main.cur_time;
				Main.servedCustomers.add(c);
				emptyServer.status = 0;
				//System.out.println("adding departure event at: "+c.departure_time);
				events.add(new Departure(emptyServer,c.departure_time));
			}
			else
			{
				Main.total_Q_size += customerQ.size();
				Main.no_of_samples++;
			}
		}

	}

}
