package org.ratajo.randoms;

/************************************************************************** 
 * This file is part of RandomNumberGenerator. 
 *  
 *  RandomNumberGenerator is free software: you can redistribute it and/or modify 
 *  it under the terms of the GNU General Public License as published by 
 *  the Free Software Foundation, either version 3 of the License, or 
 *  (at your option) any later version. 
 *   
 *  RandomNumberGenerator is distributed in the hope that it will be useful, 
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of 
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the 
 *  GNU General Public License for more details. 
 *   
 *  You should have received a copy of the GNU General Public License 
 *  along with RandomNumberGenerator.  If not, see //www.gnu.org/licenses/>. 
*************************************************************************/ 


import java.util.Random; 


/** 
 * RandomNumberGenerator creates random numbers according to one of the following distributions:
 * Poisson, Exponential, Geometric, Pareto, ParetoBounded, Uniform or Constant 
 *  
 * The method getRandom() will return the next random value.  
 * It can use a provided stream Random r, if needed, or use the default stream. 
 *  
 * For most of the distributions a single distribution parameter is needed.  
 * USAGE: double rand = Exponential.getRandom(0.25); 
 *  
 * When the wrong number of parameters is passed, IllegalArgumentException is thrown. 
 *  
 * Contact: zxy754219@gmail.com 
 *  
 * @author alexz3 
 *  
 * 
 */ 
public class RandomNumberGenerator {     
      
        public double getE(Random r, double p) { 
        	
        	double curRandom = r.nextDouble();
        	
            return -(Math.log(curRandom) / p); 
        } 
        public double getExponential(double p)
        {
        	return getE(defaultR,p);
        }
    public static final Random defaultR = new Random(); 

} 
