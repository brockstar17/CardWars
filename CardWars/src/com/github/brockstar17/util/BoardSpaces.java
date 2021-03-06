package com.github.brockstar17.util;

import com.github.brockstar17.CardWars;
import com.github.brockstar17.Paint;
import com.github.brockstar17.PlayingCard;

public class BoardSpaces
{

	private static int[] cornX = new int[20];
	private static int[] cornY = new int[20];

	public static void initCorners() {
		for(int i = 0; i < cornX.length; i++)
		{
			if(i <= 4)
			{
				cornX[i] = (int) (CardWars.screenX * .0381) + (int) (CardWars.screenX * .245 * i * .747);
				cornY[i] = (int) (CardWars.screenY * .049);
			}
			else if(i <= 9)
			{
				cornX[i] = (int) (CardWars.screenX * .0381) + (int) (CardWars.screenX * .245 * (i - 5) * .747);
				cornY[i] = (int) (CardWars.screenY * .272);
			}
			else if(i <= 14)
			{
				cornX[i] = (int) (CardWars.screenX * .0381) + (int) (CardWars.screenX * .245 * (i - 10) * .747);
				cornY[i] = (int) (CardWars.screenY * .495);
			}
			else
			{
				cornX[i] = (int) (CardWars.screenX * .0381) + (int) (CardWars.screenX * .245 * (i - 15) * .747);
				cornY[i] = (int) (CardWars.screenY * .72);
			}
		}
	}

	public static int getCellX(int i) {
		return cornX[i];
	}

	public static int getCellY(int i) {
		return cornY[i];
	}

	public static int getCell(int x, int y) {
		if(CardWars.player1)
		{
			for(int i = 0; i < cornX.length; i++)
			{
				if(x > cornX[i] && x < cornX[i] + CardWars.cellW && y > cornY[i] && y < cornY[i] + CardWars.cellH)
				{
					PlayingCard card = Paint.pCards[i];
					if(card != null)
					{
						setCellHighCard(true);
						return i;
					}
					else
					{
						setCellHighCard(false);
						return i;
					}
				}
			}
		}
		else
		{
			for(int i = 0; i < cornX.length; i++)
			{
				if(x > cornX[i] && x < cornX[i] + CardWars.cellW && y > cornY[i] && y < cornY[i] + CardWars.cellH)
				{
					PlayingCard card = Paint.oCards[i];
					if(card != null)
					{
						setCellHighCard(true);
						return i;
					}
					else
					{
						setCellHighCard(false);
						return i;
					}
				}
			}
		}
		return -1;
	}

	public static boolean hasCard(int cell) {
		if(Paint.pCards[cell] == null && Paint.oCards[cell] == null)
		{
			return false;
		}
		return true;
	}

	private static void setCellHighCard(boolean hasCard) {
		Paint.cellHighCard = hasCard;
	}

	public static boolean hasOtherCard(int cell) {
		if(cell != 1 && cell != 2 && cell != 3 && cell != 9 && cell != 14)
		{
			if(Paint.oCards[cell] == null)
			{
				return false;
			}
			return true;
		}
		else
		{
			if(Paint.pCards[cell] == null)
			{
				return false;
			}
			return true;
		}
	}
}
