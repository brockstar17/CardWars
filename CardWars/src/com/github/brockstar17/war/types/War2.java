package com.github.brockstar17.war.types;

import java.awt.Container;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

import com.github.brockstar17.CardWars;
import com.github.brockstar17.Paint;
import com.github.brockstar17.PlayingCard;
import com.github.brockstar17.util.BoardSpaces;
import com.github.brockstar17.war.PaintWar;
import com.github.brockstar17.war.Spoils;
import com.github.brockstar17.war.WarResults;

@SuppressWarnings("serial")
public class War2 extends War implements WindowListener, MouseListener, MouseMotionListener
{
	private PaintWar pw;
	private PlayingCard p, o;

	public War2(CardWars cw, PlayingCard p, PlayingCard o)
	{
		this.cw = cw;
		this.p = p;
		this.o = o;
		setTitle("War Method 2");
		setSize(cw.getWidth(), cw.getHeight());

		Container c = getContentPane();
		this.pw = new PaintWar(this);
		c.add(pw);

		addWindowListener(this);
		addMouseListener(this);
		addMouseMotionListener(this);

		setLocationRelativeTo(null);

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
		setResizable(false);
	}

	@Override
	public void windowActivated(WindowEvent arg0) {
	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		cw.setVisible(true);
		cw.setEnabled(true);
		new WarResults(playerSpoils, otherSpoils, cw);
	}

	@Override
	public void windowClosing(WindowEvent arg0) {
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
	}

	@Override
	public void windowIconified(WindowEvent arg0) {
	}

	@Override
	public void windowOpened(WindowEvent arg0) {
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		int cell = BoardSpaces.getCell(mx, my);

		if(cell != -1 && cell != 4 && cell != 14)
		{
			if(CardWars.player1)
			{
				if(Paint.pCards[cell] != null)
				{
					this.playerSpoils = new Spoils(CardWars.playerDiscard, Paint.pCards[cell], new PlayingCard[] { CardWars.playerDeck.get(0), CardWars.playerDeck.get(1), CardWars.playerDeck.get(2), p });

					CardWars.playerDeck.remove(0);
					CardWars.playerDeck.remove(1);
					CardWars.playerDeck.remove(2);
					Paint.pCards[cell] = null;
					cw.playCards--;

					this.otherSpoils = new Spoils(CardWars.otherDiscard, CardWars.otherDeck.get(3), new PlayingCard[] { CardWars.otherDeck.get(0), CardWars.otherDeck.get(1), CardWars.otherDeck.get(2), o });
					CardWars.otherDeck.remove(0);
					CardWars.otherDeck.remove(1);
					CardWars.otherDeck.remove(2);
					CardWars.otherDeck.remove(3);

					this.dispose();

				}
			}
			else
			{
				if(Paint.oCards[cell] != null)
				{
					this.otherSpoils = new Spoils(CardWars.otherDiscard, Paint.oCards[cell], new PlayingCard[] { CardWars.otherDeck.get(0), CardWars.otherDeck.get(1), CardWars.otherDeck.get(2), o });

					CardWars.otherDeck.remove(0);
					CardWars.otherDeck.remove(1);
					CardWars.otherDeck.remove(2);
					Paint.oCards[cell] = null;
					cw.playCards--;

					this.playerSpoils = new Spoils(CardWars.playerDiscard, CardWars.playerDeck.get(3), new PlayingCard[] { CardWars.playerDeck.get(0), CardWars.playerDeck.get(1), CardWars.playerDeck.get(2), p });
					CardWars.playerDeck.remove(0);
					CardWars.playerDeck.remove(1);
					CardWars.playerDeck.remove(2);
					CardWars.playerDeck.remove(3);

					this.dispose();

				}
			}
		}
	}

	@Override
	public void mouseDragged(MouseEvent e) {
	}

	// this function will be for hovering
	@Override
	public void mouseMoved(MouseEvent e) {
		this.mx = e.getX();
		this.my = e.getY();
		repaint();
	}
}
