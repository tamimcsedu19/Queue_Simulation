package org.ratajo.objects;
import org.ratajo.randoms.*;
public class Server {
	public RandomNumberGenerator serverDistribution;
	double mu;
	public int status;  // 0 for closed 1 for open
	double working_time;
	int type;
	public Server(double mu,int type)
	{
		this.type = type;
		serverDistribution = new RandomNumberGenerator();
		status = 1;
		this.mu = mu;
		
	}
	public double getnext() {
		return serverDistribution.getExponential(mu);
		
	}
	
	
	

}
