package Greedy;
import java.io.*;
import java.util.*;


class Pair{
	
	int weight, value;
	
	public Pair(int weight, int value)
	{
		this.weight = weight;
		this.value = value;
	}
	
}

class PairComparator implements Comparator<Pair>
{
	public int compare(Pair a, Pair b)
	{
		double ratio1 = (double)a.value/a.weight;
		double ratio2 = (double)b.value/b.weight;
		
		if(ratio1 < ratio2)
		{
			return 1;
		}else if(ratio1 > ratio2)
		{
			return -1;
		}
		else
		{
			return 0;
		}
	}
}


public class FractionalKnapsack {
	
    public static double maximumValue(Pair[] items, int n, int w) {
        // Write your code here.
	    // ITEMS contains {weight, value} pairs.
    	Arrays.sort(items, new PairComparator());
    	double ans = 0;
    	for(Pair i : items)
    	{
    		if (i.weight > w) {
    			double reqval = (double)w * ((double)i.value / (double)i.weight);
    			ans += reqval;
    			break;
				
			} else {
				ans += i.value;
				w = w - i.weight;

			}
    	}
    	
    	return ans;
    	
}
	
	public static void main(String[] args) {
//
//		List<Worker> input = new ArrayList<Worker>();
		Pair[] input = new Pair[6];
		
//		input.add(new Worker(1, 1, 5));
//		input.add(new Worker(2, 2, 2));
//		input.add(new Worker(3, 1, 1));
//		input.add(new Worker(1, 3, 4));
		
		input[0] = new Pair(50, 40);
		input[1] = new Pair(40, 50);
		input[2] = new Pair(90, 25);
		input[3] = new Pair(120, 100);
		input[4] = new Pair(10, 30);
		input[5] = new Pair(200, 45);
		
//		for(Pair i : input)
//		{
//			System.out.println(i.value + " " + i.weight);
//		}
//		
//		Arrays.sort(input, new PairComparator());
//		
//		for(Pair i : input)
//		{
//			System.out.println(i.value + " " + i.weight);
//		}
		
		System.out.println(maximumValue(input, 6, 200));
	}	 
	
}
