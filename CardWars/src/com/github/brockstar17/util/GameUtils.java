package com.github.brockstar17.util;

import java.util.ArrayList;
import java.util.Random;

import com.github.brockstar17.CardWars;
import com.github.brockstar17.Paint;
import com.github.brockstar17.PlayingCard;

public class GameUtils {

	private static Random rn = new Random();
	
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
	
	public static void initShuffle(){
		int pdx = BoardSpaces.getCellX(15);
		int pdy = BoardSpaces.getCellY(15);
		int odx = BoardSpaces.getCellX(4);
		int ody = BoardSpaces.getCellY(4);
		
		int cards = 0;
		int cards2 = 0;
		
		for(int i = 0; i < 13; i++)
		{
			for(int s = 0; s < 4; s++)
			{
				if(rn.nextInt(4) < 2 && cards < 26)
				{
					CardWars.playerDeck.add(new PlayingCard(pdx, pdy, CardWars.cellW, CardWars.cellH, getSuit(s), i+1));
					cards++;
				}
				else if(cards2 < 26)
				{
					CardWars.otherDeck.add(new PlayingCard(odx, ody, CardWars.cellW, CardWars.cellH, getSuit(s), i+1));
					cards2++;
				}
				else
				{
					CardWars.playerDeck.add(new PlayingCard(pdx, pdy, CardWars.cellW, CardWars.cellH, getSuit(s), i+1));
					cards++;
				}
			}
		}
		
		
		
		
	}
	
	private static String getSuit(int i){
		switch(i)
		{
		case 0:
			return "hearts";
		case 1:
			return "spades";
		case 2:
			return "clubs";
		case 3:
			return "diamonds";
		default:
			return null;
		}
	}
	
/*
 * for(int i = 0; i < deck.size(); i++)
		{
			
			if(i % 2 == 0)
			{
				CardWars.playerDeck.add(new PlayingCard(pdx, pdy, CardWars.cellW, CardWars.cellH, suits.get(i), deck.get(i)));
				System.out.println("card " + i/2 + " " + CardWars.playerDeck.get(i/2).getSuit() + " " + CardWars.playerDeck.get(i/2).getValue());
			}
			else
			{
				CardWars.otherDeck.add(new PlayingCard(odx, ody, CardWars.cellW, CardWars.cellH, suits.get(i), deck.get(i)));

			}
		}
 */
	
	
	
	
}
