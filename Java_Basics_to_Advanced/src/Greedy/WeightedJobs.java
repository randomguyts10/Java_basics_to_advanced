package Greedy;
import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

class Job{

	int start;
	int finish;
	int profit;
	
	public Job(int start, int finish, int profit)
	{
		this.start = start;
		this.finish = finish;
		this.profit = profit;
	}	

}

class JobComparator implements Comparator<Job>
{
	public int compare(Job a, Job b)
	{
		return Integer.compare(a.finish, b.finish);
//		return a.finish > b.finish;
	}

}



public class WeightedJobs {
	
	public static void main(String[] args) {
		
		Job[] input = new Job[4];
		input[0] = new Job(3, 10, 20);
		input[1] = new Job(1, 2, 50);
		input[2] = new Job(6, 19, 150);
		input[3] = new Job(2, 100, 200);
		
		for(Job i : input)
		{
			System.out.println(i.start + " " + i.finish + " " + i.profit);
		}

		System.out.println(Integer.compare(input[0].finish, input[1].finish));
		
		Arrays.sort(input, new JobComparator());
		
		System.out.println(Integer.compare(input[0].finish, input[1].finish));
		
		System.out.println("After Sorting");
		for(Job i : input)
		{
			System.out.println(i.start + " " + i.finish + " " + i.profit);
		}
		
	}

}
