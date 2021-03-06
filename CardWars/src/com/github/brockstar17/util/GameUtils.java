package com.github.brockstar17.util;

import java.util.ArrayList;
import java.util.Random;

import com.github.brockstar17.CardWars;
import com.github.brockstar17.Paint;
import com.github.brockstar17.PlayingCard;

public class GameUtils
{

	private static Random rn = new Random();

	public static int[] adjMoves(int cell) {

		if(cell == 5 || cell == 10)
		{

			return fill(new int[] { cell + 1, cell + 5, cell - 5 });
		}
		else if(cell == 9 || cell == 14)
		{
			return fill(new int[] { cell - 1, cell - 5, cell + 5 });
		}
		else if(cell == 0)
		{
			return fill(new int[] { cell + 1, cell + 5 });
		}
		else if(cell == 19)
		{
			return fill(new int[] { cell - 1, cell - 5 });
		}

		else if(cell > 15 && cell < 19)
		{
			return fill(new int[] { cell - 1, cell + 1, cell - 5 });
		}
		else if(cell > 0 && cell < 4)
		{
			return fill(new int[] { cell - 1, cell + 1, cell + 5 });
		}
		else
		{
			return fill(new int[] { cell + 1, cell - 1, cell + 5, cell - 5 });
		}

	}

	private static int[] fill(int[] mov) {
		ArrayList<Integer> ar = new ArrayList<Integer>();

		for(int i = 0; i < mov.length; i++)
		{
			if(CardWars.player1)
			{
				if((Paint.pCards[mov[i]] == null || (Paint.pCards[mov[i]] == null && Paint.oCards[mov[i]] != null)) && mov[i] != 4 && mov[i] != 15)
				{
					ar.add(mov[i]);
				}
			}
			else
			{
				if((Paint.oCards[mov[i]] == null || (Paint.oCards[mov[i]] == null && Paint.pCards[mov[i]] != null)) && mov[i] != 4 && mov[i] != 15)
				{
					ar.add(mov[i]);
				}
			}

		}

		int[] fin = new int[ar.size()];
		for(int i = 0; i < fin.length; i++)
		{
			fin[i] = ar.get(i);
		}

		return fin;
	}

	public static void initShuffle() {
		int pdx = BoardSpaces.getCellX(15);
		int pdy = BoardSpaces.getCellY(15);
		int odx = BoardSpaces.getCellX(4);
		int ody = BoardSpaces.getCellY(4);

		PlayingCard[] cards1 = new PlayingCard[52];
		PlayingCard[] cards2 = new PlayingCard[52];

		int count = 0;

		for(int i = 0; i < 13; i++)
		{
			for(int s = 0; s < 4; s++)
			{
				cards1[count] = new PlayingCard(pdx, pdy, CardWars.cellW, CardWars.cellH, getSuit(s), i + 1);
				cards2[count] = new PlayingCard(odx, ody, CardWars.cellW, CardWars.cellH, getSuit(s), i + 1);
				count++;
			}

		}

		for(int i = 0; i < 4; i++)
		{
			iShuffle(cards1);
			iShuffle(cards2);

		}

		for(int i = 0; i < cards1.length; i++)
		{

			CardWars.playerDeck.add(cards1[i]);

			cards2[i].setX(odx);
			cards2[i].setY(ody);
			CardWars.otherDeck.add(cards2[i]);

		}

	}

	private static String getSuit(int i) {
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

	private static void iShuffle(PlayingCard[] list) {
		for(int i = 0; i < list.length; i++)
		{
			int to = rn.nextInt(list.length);
			int from = rn.nextInt(list.length);
			PlayingCard temp = list[from];
			list[from] = list[to];
			list[to] = temp;
		}

	}

	public static void shuffle(ArrayList<PlayingCard> list) {

		for(int i = 0; i < list.size(); i++)
		{
			int to = rn.nextInt(list.size());
			int from = rn.nextInt(list.size());
			PlayingCard temp = list.get(from);
			list.set(from, list.get(to));
			list.set(to, temp);
		}
	}

	public static boolean canMove(int cell, int clicked) {
		for(int i = 0; i < adjMoves(clicked).length; i++)
		{
			if(cell == adjMoves(clicked)[i])
			{
				return true;
			}
		}

		return false;
	}

	public static boolean isSpawnEmpty(int cell) {
		if(CardWars.player1)
		{
			if(Paint.pCards[cell] == null)
			{
				return true;
			}
		}
		else
		{
			if(Paint.oCards[cell] == null)
			{
				return true;
			}
		}
		return false;
	}

	/**
	 * 
	 * @return 1 if player lost, 2 if opp lost, 0 if neither lost
	 */
	public static int checkWin() {
		if(Paint.isSpawnFull() != 0)
		{
			System.out.println("Player " + Paint.isSpawnFull() + " Lost");
			return Paint.isSpawnFull();
		}
		if(CardWars.playerDeck.size() == 0)
		{
			System.out.println("Player 2 Wins");
			return 1;
		}
		if(CardWars.otherDeck.size() == 0)
		{
			System.out.println("Player 1 Wins");
			return 2;
		}
		return 0;
	}

}
