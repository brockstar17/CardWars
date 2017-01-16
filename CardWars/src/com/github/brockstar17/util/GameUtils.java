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
			if((Paint.pCards[mov[i]] == null || Paint.oCards[mov[i]] != null) && mov[i] != 4 && mov[i] != 15)
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
		
		PlayingCard[] cards = new PlayingCard[52];
		
		int count = 0;
		
		for(int i = 0; i < 13; i++)
		{
			for(int s = 0; s < 4; s++)
			{
				cards[count] = new PlayingCard(pdx, pdy, CardWars.cellW, CardWars.cellH, getSuit(s), i+1);
				count++;
			}
		
		}
		
		
		
		for(int i = 0; i  < 4; i++)
		{
			iShuffle(cards);
			
		}
		
		for(int i = 0; i < cards.length; i++)
		{
			if(i%2 == 0)
			{
				CardWars.playerDeck.add(cards[i]);
			}
			else
			{
				cards[i].setX(odx);
				cards[i].setY(ody);
				CardWars.otherDeck.add(cards[i]);
			}
		}
		
		/*
		//debug
		for(int i = 0; i < CardWars.playerDeck.size(); i++)
		{
			System.out.println(CardWars.playerDeck.get(i).getName() + " " + i);
		}*/
		
		
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
	
	private static void iShuffle(PlayingCard[] list){
		for(int i = 0; i < list.length; i++)
		{
			int to = rn.nextInt(list.length);
			int from = rn.nextInt(list.length);
			PlayingCard temp = list[from];
			list[from] = list[to];
			list[to] = temp;
		}
		
	}
	

	
	public static void shuffle(ArrayList<PlayingCard> list){
		
		
		for(int i = 0; i < list.size(); i++)
		{
			int to = rn.nextInt(list.size());
			int from = rn.nextInt(list.size());
			PlayingCard temp = list.get(from);
			list.set(from, list.get(to));
			list.set(to, temp);
		}
	}
	
	
	/*
	 * CardWars.otherDeck.add(new PlayingCard(odx, ody, CardWars.cellW, CardWars.cellH, getSuit(s), i+1));
					cards2++;
					CardWars.playerDeck.add(new PlayingCard(pdx, pdy, CardWars.cellW, CardWars.cellH, getSuit(s), i+1));
					cards++;
	 */
	
}
