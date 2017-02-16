package com.github.brockstar17.war;

import javax.swing.JDialog;
import javax.swing.JFrame;

import com.github.brockstar17.CardWars;
import com.github.brockstar17.PlayingCard;

@SuppressWarnings("serial")
public class WarResults extends JDialog
{
	private Spoils p, o;
	private CardWars cw;

	public WarResults(Spoils p, Spoils o, CardWars cw)
	{
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		this.p = p;
		this.o = o;
		this.cw = cw;
		printColor(o.getDeciding().getName() + " was Player 2");
		printColor(p.getDeciding().getName() + " was Player 1");
		printColor(whoWon());
		this.dispose();
	}

	private String whoWon() {
		if(this.p.getDeciding().getValue() == this.o.getDeciding().getValue())
		{
			finagleIt();
			return "Continue the war";
		}

		else if(this.p.getDeciding().getValue() > this.o.getDeciding().getValue())
		{
			p.returnSpoils();
			CardWars.testColor++;
			return "Player One wins the war";
		}

		else
		{
			o.returnSpoils();
			CardWars.testColor++;
			return "Player 2 wins the war";
		}
	}

	private void finagleIt() {
		PlayingCard[] p = new PlayingCard[] { CardWars.playerDeck.get(0), CardWars.playerDeck.get(1), CardWars.playerDeck.get(2) };
		PlayingCard[] o = new PlayingCard[] { CardWars.otherDeck.get(0), CardWars.otherDeck.get(1), CardWars.otherDeck.get(2) };
		PlayingCard p1 = CardWars.playerDeck.get(3),
				o1 = CardWars.otherDeck.get(3);

		CardWars.otherDeck.remove(0);
		CardWars.otherDeck.remove(1);
		CardWars.otherDeck.remove(2);
		CardWars.otherDeck.remove(3);

		CardWars.playerDeck.remove(0);
		CardWars.playerDeck.remove(1);
		CardWars.playerDeck.remove(2);
		CardWars.playerDeck.remove(3);

		new WarResults(new Spoils(CardWars.playerDiscard, p1, p), new Spoils(CardWars.otherDiscard, o1, o), cw);
	}

	private void printColor(String toPrint) {
		if(CardWars.testColor % 2 == 0)
		{
			System.err.println(toPrint);
		}
		else
		{
			System.out.println(toPrint);
		}
	}

}
