import edu.princeton.cs.algs4.Queue;
import java.math.BigInteger;

public class FIBD {
	
	private double duration; 
	
	private double lifeLength;
	
	private BigInteger [] monthCache;
	
	public FIBD (double duration, double lifeLength)
	{
		this.duration = duration;
		this.lifeLength = lifeLength;
		monthCache = new BigInteger[(int) (duration + 1)];
		monthCache[1] = BigInteger.valueOf(1);
		monthCache[2] = BigInteger.valueOf(1);
	}
	
	public BigInteger calculateRabbits(double month)
	{
		return calculate(month);
	}
	
	private BigInteger calculate (double month)
	{
		if (month <= 2)
		{
			return monthCache[2];
		} else if (month <= lifeLength)
		{
			if(monthCache[(int) month] == null)
			{
				monthCache[(int)month] = calculate(month - 1).add(calculate(month - 2));
			}
			return monthCache[(int)month];
		} else
		{
			if(monthCache[(int)month] != null)
			{
				return monthCache[(int)month];
			}
			
			monthCache[(int)month] = BigInteger.valueOf(0);
			for (int i = 1; i < lifeLength; i++)
			{
				monthCache[(int)month] = monthCache[(int)month].add(calculate(month - 1 - i));
			}
			return monthCache[(int)month];
		}
	}
	
	
	
	public static void main(String[] args) {
		
		FIBD obj = new FIBD(95, 18);
		
		System.out.println(obj.calculateRabbits(95));
		
		for (int i = 0; i < 95; i++)
		{
			System.out.println(obj.monthCache[i + 1]);
		}
	}

}
