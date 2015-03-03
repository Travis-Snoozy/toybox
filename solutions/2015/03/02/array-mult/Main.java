// Solution: O(n) time, O(n) space.
// Third solution; 1N less time, 2N less space than second solution.
public class Main
{
	private static final int data[] = { 6, 7, 2, 2, 3 };
	public static void main(String args[])
	{
		printArray(data);
		int results[] = new int[data.length];
		int backward = 1;
		results[0] = 1;
		results[data.length - 1] = 1;
		for(int i = 1; i < data.length; i++)
		{
			results[i] = results[i-1] * data[i-1];
		}
		printArray(results);
		for(int i = data.length-2; i >= 0; i--)
		{
			backward *= data[i+1];
			results[i] *= backward;
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
