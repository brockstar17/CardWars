package com.github.brockstar17.util;

import java.util.ArrayList;

import com.github.brockstar17.Paint;

public class GameUtils {

	
	public static int[] adjMoves(int cell)
	{
		
		
		if(cell == 5 || cell == 10)
		{
			
			return fill(new int[]{cell+1, cell + 5, cell-5});
		}
		else if(cell == 9 || cell == 14)
		{
			return fill(new int[]{cell-1, cell-5, cell+5});
		}
		else if(cell == 0)
		{
			return fill(new int[]{cell + 1, cell+5});
		}
		else if(cell == 19)
		{
			return fill(new int[]{cell-1, cell-5});
		}
		
		else if(cell > 15 && cell < 19)
		{
			return fill(new int[]{cell-1, cell+1, cell-5});
		}
		else if(cell > 0 && cell < 4)
		{
			return fill(new int[]{cell-1, cell+1, cell+5});
		}
		else
		{
			return fill(new int[]{cell+1, cell-1, cell+5, cell-5});
		}
		
		
	}
	
	private static int[] fill(int[] mov){
		ArrayList<Integer> ar = new ArrayList<Integer>();
		
		for(int i = 0; i < mov.length; i++)
		{
			if(Paint.pCards[mov[i]] == null && mov[i] != 4 && mov[i] != 15)
			{
				ar.add(mov[i]);
			}
			
		}
		
		int[] fin = new int[ar.size()];
		for(int i = 0; i < fin.length; i++)
		{
			fin[i] = ar.get(i);
		}
		
		return fin;
	}
	
	
}
