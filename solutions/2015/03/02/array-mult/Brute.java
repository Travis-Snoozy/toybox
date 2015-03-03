// Solution: O(n^3) time, O(n) space.
// First solution.

public class Brute {
	private static final int data[] = { 6, 7, 2, 2, 3 };
	public static void main(String args[])
	{
		System.out.print("{");
		String prefix = " ";
		for(int i = 0; i < data.length; i++)
		{
			System.out.print(prefix + data[i]);
			prefix = ", ";
		}
		System.out.println(" }");
		int results[] = new int[data.length];
		for(int i = 0; i < data.length; i++)
		{
			results[i] = 1;
			for(int j = 0; j < data.length; j++)
			{
				if(j == i)
				{
					continue;
				}
				results[i] *= data[j];
			}
		}
		System.out.print("{");
		prefix = " ";
		for(int i = 0; i < results.length; i++)
		{
			System.out.print(prefix + results[i]);
			prefix = ", ";
		}
		System.out.println(" }");
	}
}
