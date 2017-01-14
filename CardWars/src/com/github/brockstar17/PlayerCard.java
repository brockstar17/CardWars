package com.github.brockstar17;

/*
 * Defines the object of the player's card
 */

public class PlayerCard
{
	private int x; // x pos of top left corner
	private int y; // y pos of top left corner
	private int w; // x pos of right edge of card
	private int l; // y pos of the bottom of card
	private String suit; //the suit of the card
	private int value; //the value of the card

	public PlayerCard(int px, int py, int sx, int sy, String suit, int value)
	{
		this.x = px;
		this.y = py;
		this.w = sx;
		this.l = sy;
		this.suit = suit.toLowerCase();
		this.value = value;
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

	// returns the y pos of the bottom edge of card
	public int getL() {
		return l;
	}
	
	public void setX(int x){
		this.x = x;
	}
	
	public void setY(int y){
		this.y = y;
	}
	
	public String getSuit(){
		return this.suit;
	}
	
	public int getValue(){
		return this.value;
	}
}
