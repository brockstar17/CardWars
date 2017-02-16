package com.github.brockstar17.war;

import java.util.ArrayList;

import com.github.brockstar17.PlayingCard;

public class Spoils
{
	private PlayingCard[] spoils;
	private ArrayList<PlayingCard> list;
	private PlayingCard deciding;

	/**
	 * 
	 * @param list
	 *            should be a discard list
	 * @param d
	 *            the deciding card
	 * @param spoils
	 *            an array containing the three cards
	 */
	public Spoils(ArrayList<PlayingCard> list, PlayingCard d, PlayingCard[] spoils)
	{
		this.list = list;
		this.deciding = d;
		this.spoils = spoils;
	}

	public void returnSpoils() {
		for(int i = 0; i < spoils.length; i++)
		{
			list.add(spoils[i]);
		}
		list.add(deciding);
	}

	public PlayingCard getDeciding() {
		return this.deciding;
	}
}
