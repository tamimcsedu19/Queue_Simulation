package org.ratajo.objects;

import java.util.Comparator;

public class EventComparator implements Comparator<Event> {

	@Override
	public int compare(Event o1, Event o2) {
		if(o1.arrival_time > o2.arrival_time)
			return 1;
		else if(o1.arrival_time < o2.arrival_time)
			return -1;
		return 0;
	}

}
