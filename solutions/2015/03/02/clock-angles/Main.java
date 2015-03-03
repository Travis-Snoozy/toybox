// Solution: O(n) time, O(n) space.
// The problem states that angles are given in full degrees. However, the hours
// hand moves in increments of 0.5 degree per minute, which means there has to
// be a fudge factor to bin the query of (say) 100 as to whether that includes
// 99.5 or 100.5 (or both, or neither).

import java.util.*;

public class Main
{
	private static final int SCALE = 2; // half-degree resolution.
	private static final int CIRCLE = 360 * SCALE;
	private static final int MAXANGLES = CIRCLE / 2; // only 0-179 degrees; the rest are mirrors.

	private static ArrayList<ArrayList<Integer>> angles;

	static
	{
		angles = new ArrayList<ArrayList<Integer>>();
		for(int i = 0; i < MAXANGLES; i++)
		{
			angles.add(new ArrayList<Integer>());
		}

		int hourDeg = 0;
		int minuteDeg = 0;
		// For each minute in the first 1/4 of the day (the rest are
		// mirrors offset by 6 hours apiece)
		for(int i = 0; i < 60 * 6; i++)
		{
			// Process the hands in their current position.
			int deg = hourDeg - minuteDeg;
			deg = normalize(deg);
			angles.get(deg).add(i);

			// Clock marches forward...
			hourDeg += CIRCLE / (360*2); // .5 degree
			minuteDeg += (CIRCLE*6)/360; // 6 degrees
		}
	}
	private static int normalize(int deg)
	{
		// Get positive.
		while(deg < 0)
		{
			deg += CIRCLE;
		}
		

		if(deg >= MAXANGLES)
		{
			deg %= MAXANGLES;
		}

		return deg;
	}
	private static void printTimeFromMinutes(int minutes)
	{
		String am = "AM";
		int h = minutes / 60;
		if(h >=12)
		{
			am = "PM";
		}
		h %= 12;
		if(h == 0) {
			h = 12;
		}
		int m = minutes % 60;

		System.out.printf("%d:%02d %s\n", h, m, am);
	}
	private static void printResult(ArrayList<Integer> result)
	{
		for(int i = 0; i < result.size(); i++)
		{
			int time = result.get(i).intValue();
			for(int j = 0; j < 4; j++) {
				printTimeFromMinutes(time);
				time += 60 * 6; // add 6 hours' of minutes.
			}
		}
	}
	public static void main(String args[])
	{
		if(args.length < 1)
		{
			System.out.println("Please specify a number of whole degrees.");
		}
		int deg = Integer.parseInt(args[0]);
		printResult(angles.get(deg * SCALE));
	}
}
