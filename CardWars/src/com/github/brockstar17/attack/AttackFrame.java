package com.github.brockstar17.attack;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.github.brockstar17.CardWars;
import com.github.brockstar17.Paint;
import com.github.brockstar17.PlayingCard;
import com.github.brockstar17.util.ImageUtils;
import com.github.brockstar17.war.WarFrame;

@SuppressWarnings("serial")
public class AttackFrame extends JDialog implements WindowListener
{

	private CardWars cw;
	private AttackPanel ap;
	private int w;
	private int l;
	private int cell;
	protected String winner;

	private PlayingCard player, opp;

	public AttackFrame(CardWars cw, PlayingCard player, PlayingCard other, int cell)
	{
		setUndecorated(true);
		JPanel p = (JPanel) getContentPane();
		p.setBorder(BorderFactory.createLineBorder(Color.BLACK, 4));

		this.cw = cw;
		this.player = player;
		this.opp = other;
		this.w = (int) (cw.getWidth() * .75);
		this.l = ImageUtils.calcWidth(400, this.w, 200);
		this.cell = cell;
		addWindowListener(this);

		setSize(w, l);

		this.ap = new AttackPanel(this);
		Container c = getContentPane();
		c.add(ap);

		setLocationRelativeTo(null);

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
		setResizable(false);
	}

	@Override
	public void windowActivated(WindowEvent e) {

	}

	@Override
	public void windowClosed(WindowEvent e) {
		attackDiscard(cell, player, opp);
		CardWars.select = false;
		CardWars.highlight = true;
		cw.countTurn();
		cw.winner = this.winner;
		this.cw.setVisible(true);
		this.cw.setEnabled(true);

	}

	@Override
	public void windowClosing(WindowEvent e) {

	}

	@Override
	public void windowDeactivated(WindowEvent e) {

	}

	@Override
	public void windowDeiconified(WindowEvent e) {

	}

	@Override
	public void windowIconified(WindowEvent e) {

	}

	@Override
	public void windowOpened(WindowEvent e) {

	}

	public PlayingCard getPlayerCard() {

		return this.player;
	}

	public PlayingCard getOppCard() {
		return this.opp;
	}

	public int getW() {
		// System.out.println("w " + this.w);
		return this.w;
	}

	public int getL() {
		// System.out.println("l " + this.l);
		return this.l;
	}

	private void attackDiscard(int cell, PlayingCard player, PlayingCard opp) {
		if(cell != -1 && CardWars.player1)
		{
			if(winner == "p2")
			{
				System.out.println("Lost: P1");
				player = Paint.pCards[Paint.clicked];
				Paint.pCards[Paint.clicked] = null;
				cw.decrPlayCard();
				// System.out.println("Adding to other: " + player.getName());
				CardWars.otherDiscard.add(player);

			}
			else if(winner == "p1")
			{
				System.out.println("Lost: P2");
				opp = Paint.oCards[cell];
				Paint.oCards[cell] = null;
				player = Paint.pCards[Paint.clicked];
				Paint.pCards[Paint.clicked] = null;
				Paint.pCards[cell] = player;
				cw.decrOppCards();
				// System.out.println("Adding to player: " + opp.getName());
				CardWars.playerDiscard.add(opp);

			}
			else // war
			{
				this.dispose();
				cw.setEnabled(false);
				new WarFrame(cw);
			}

		}
		else if(cell != -1)
		{
			if(winner == "p2")
			{
				System.out.println("Lost: P1");
				player = Paint.pCards[cell];
				Paint.pCards[cell] = null;
				opp = Paint.oCards[Paint.clicked];
				Paint.oCards[Paint.clicked] = null;
				Paint.oCards[cell] = opp;
				cw.decrPlayCard();
				// System.out.println("Adding to other: " + player.getName());
				CardWars.otherDiscard.add(player);
			}
			else if(winner == "p1")
			{
				System.out.println("Lost: P2");
				opp = Paint.oCards[Paint.clicked];
				Paint.oCards[Paint.clicked] = null;
				cw.decrOppCards();
				// System.out.println("Adding to player: " + opp.getName());
				CardWars.playerDiscard.add(opp);

			}
			else // war
			{
				this.dispose();
				cw.setEnabled(false);
				new WarFrame(cw);
			}

		}
	}

}
