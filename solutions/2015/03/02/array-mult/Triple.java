// Solution: O(n) time, O(n) space.
// Second solution.
public class Triple
{
	private static final int data[] = { 6, 7, 2, 2, 3 };
	public static void main(String args[])
	{
		printArray(data);
		int results[] = new int[data.length];
		int backwards[] = new int[data.length];
		int forwards[] = new int[data.length];
		forwards[0] = 1;
		backwards[data.length - 1] = 1;

		for(int i = 1; i < data.length; i++)
		{
			forwards[i] = forwards[i-1] * data[i-1];
		}
		printArray(forwards);
		for(int i = data.length-2; i >= 0; i--)
		{
			backwards[i] = backwards[i+1] * data[i+1];
		}
		printArray(backwards);
		for(int i = 0; i < data.length; i++)
		{
			results[i] = forwards[i] * backwards[i];
		}
		printArray(results);
	}
	private static void printArray(int arr[])
	{
		System.out.print("{");
		String prefix = " ";
		for(int i = 0; i < arr.length; i++)
		{
			System.out.print(prefix + arr[i]);
			prefix = ", ";
		}
		System.out.println(" }");
	}
}
