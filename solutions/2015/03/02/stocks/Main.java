// Solution: O(n) time, O(1) space.

public class Main
{
	// Finantial "data" thanks to random.org
	private static final int stock[] = { 71, 64, 14, 26, 52, 36, 46, 20, 7, 9 };
	public static void main(String args[])
	{
		int minIndex = 0;
		int maxIndex = 0;
		int buyIndex = 0;
		int sellIndex = 0;
		for(int i = 0; i < stock.length; i++) {
			if(stock[i] < stock[minIndex])
			{
				// We found a new minimum. Reset both min AND max,
				// because we can only sell in the future, not the
				// past.
				minIndex = i;
				maxIndex = i;
			} else if (stock[i] > stock[maxIndex]) {
				// We found a new maximum (local to our minimum).
				// Record it, so we can see if we have a new best-price.
				maxIndex = i;

				// Since we updated our local max, see if our local
				// delta beats the global delta. If so, record it.
				if((stock[maxIndex] - stock[minIndex]) > (stock[sellIndex] - stock[buyIndex]))
				{
					sellIndex = maxIndex;
					buyIndex = minIndex;
				}
			}
			// We don't care/do anything if the current stock price is
			// merely equal to the global min or local max. We also
			// don't care if the current stock price is somewhere in-
			// between the global min or local max.
		}
		System.out.printf("Buy at %d ($%d), sell at %d ($%d), for a profit of $%d.\n", buyIndex, stock[buyIndex], sellIndex, stock[sellIndex], stock[sellIndex] - stock[buyIndex]);
	}
}
