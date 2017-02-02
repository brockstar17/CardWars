package com.github.brockstar17.war;

import java.util.ArrayList;

import com.github.brockstar17.PlayingCard;

public class Spoils
{
	private PlayingCard[] spoils = new PlayingCard[3];
	private ArrayList<PlayingCard> list;
	private PlayingCard deciding;

	public Spoils(ArrayList<PlayingCard> list, PlayingCard d)
	{
		this.list = list;
		this.deciding = d;
	}

	public void returnSpoils() {
		for(int i = 0; i < spoils.length; i++)
		{
			list.add(spoils[i]);
		}
		list.add(deciding);
	}
}
