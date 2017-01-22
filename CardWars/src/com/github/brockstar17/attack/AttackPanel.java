package com.github.brockstar17.attack;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;
import javax.swing.Timer;

import com.github.brockstar17.CardWars;
import com.github.brockstar17.Paint;
import com.github.brockstar17.PlayingCard;
import com.github.brockstar17.util.ImageUtils;

@SuppressWarnings("serial")
public class AttackPanel extends JPanel implements ActionListener
{

	private AttackFrame af;
	private PlayingCard player, opp;
	private String winner;

	private boolean burn = false;
	private BufferedImage pl, op;
	private int cx1, cx2, cy;

	public AttackPanel(AttackFrame frame)
	{
		this.af = frame;
		this.player = frame.getPlayerCard();
		this.opp = frame.getOppCard();
		this.cx1 = (int) (frame.getW() * .15);
		this.cx2 = (int) (frame.getW() * .65);
		this.cy = (int) (frame.getL() * .25);
		this.pl = Paint.getSuitArray(player.getSuit())[player.getValue() - 1];
		this.op = Paint.getDeckBack(CardWars.backDeck, CardWars.userDeck);
		this.winner = AttackUtil.compare(player.getValue(), opp.getValue());
		af.winner = this.winner;
		Timer timer = new Timer(30, this);
		timer.start();
	}

	@Override
	protected void paintComponent(Graphics g) {

		super.paintComponent(g);

		g.drawImage(ImageUtils.scale(CardWars.attackBack, af.getWidth(), af.getHeight()), 0, 0, null);

		if(!burn)
		{
			g.drawImage(pl, (int) (af.getWidth() * .15), (int) (af.getHeight() * .25), null);

			g.drawImage(op, (int) (af.getWidth() * .65), (int) (af.getHeight() * .25), null);

		}

		if(CardWars.player1 && burn)
		{

			if(winner == "p1")
			{
				drawFire(g, cx2);

			}
			else if(winner == "p2")
			{
				drawFire(g, cx1);

			}
		}
		else if(burn)
		{

			if(winner == "p1")
			{
				drawFire(g, cx2);
			}
			else if(winner == "p2")
			{
				drawFire(g, cx1);
			}
		}

	}

	private int count = 0;
	private int moved = 0;
	private double exp = 1.022;

	@Override
	public void actionPerformed(ActionEvent e) {
		if(count > 20)
		{
			burn = true;

			if((int) (cy * exp) < (int) (af.getHeight() * .25) + CardWars.yin.getHeight())
			{

				cy = (int) (cy * exp);
				repaint();
				moved += (int) (cy * exp) - cy;
			}
			else
			{
				af.dispose();
			}
		}

		count++;
	}

	private void drawFire(Graphics g, int x) {
		if(x == cx1)
		{
			// g.drawImage(CardWars.behFlame, cx1, (int)(af.getHeight() * .25), cx1 + player.getW(), cy, null);
			if(count % 5 == 0 && moved < pl.getHeight())
			{
				g.drawImage(op, cx2, (int) (af.getHeight() * .25), null);
				g.drawImage(pl.getSubimage(0, moved, pl.getWidth(), pl.getHeight() - moved), cx1, cy, null);
				g.drawImage(CardWars.flame1, cx1, cy, null);
			}
			else if(moved < pl.getHeight())
			{
				g.drawImage(op, cx2, (int) (af.getHeight() * .25), null);
				g.drawImage(pl.getSubimage(0, moved, pl.getWidth(), pl.getHeight() - moved), cx1, cy, null);
				g.drawImage(CardWars.flame2, cx1, cy, null);
			}
		}
		else
		{
			// g.drawImage(CardWars.behFlame, cx2, cy, null);
			if(count % 5 == 0 && moved < pl.getHeight())
			{
				g.drawImage(pl, cx1, (int) (af.getHeight() * .25), null);
				g.drawImage(op.getSubimage(0, moved, pl.getWidth(), pl.getHeight() - moved), cx2, cy, null);
				g.drawImage(CardWars.flame1, cx2, cy, null);
			}
			else if(moved < pl.getHeight())
			{
				g.drawImage(pl, cx1, (int) (af.getHeight() * .25), null);
				g.drawImage(op.getSubimage(0, moved, pl.getWidth(), pl.getHeight() - moved), cx2, cy, null);
				g.drawImage(CardWars.flame2, cx2, cy, null);
			}
		}
	}

}
