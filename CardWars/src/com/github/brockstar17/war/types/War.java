package com.github.brockstar17.war.types;

import javax.swing.JDialog;

import com.github.brockstar17.CardWars;
import com.github.brockstar17.war.Spoils;

@SuppressWarnings("serial")
public class War extends JDialog
{
	protected CardWars cw;
	public int mx = 0, my = 0;

	public Spoils playerSpoils;
	public Spoils otherSpoils;

}
