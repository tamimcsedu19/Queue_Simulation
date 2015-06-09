package org.ratajo.objects;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class simQueue {
	
	int type;   // if 1 its VIP Express Queue
	public Queue<Customer> customers;
	public simQueue(int type)
	{
		this.type = type;
		customers = new LinkedList<Customer>();
	}
	
	


}
