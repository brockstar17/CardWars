package com.github.brockstar17;

/*
 * Defines the object of the player's card
 */

public class Player
{
	private int x; // x pos of top left corner
	private int y; // y pos of top left corner
	private int w; // x pos of right edge of card
	private int l;

	public Player(int px, int py, int sx, int sy)
	{
		this.x = px;
		this.y = py;
	}

	// returns the x pos of this card
	public int getX() {
		return x;
	}

	// returns the y loc of this card
	public int getY() {
		return y;
	}

	// returns the x pos of the right edge of card
	public int getW() {
		return w;
	}
}
