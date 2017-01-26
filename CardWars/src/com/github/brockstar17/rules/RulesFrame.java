package com.github.brockstar17.rules;

import java.awt.Container;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.github.brockstar17.CardWars;

@SuppressWarnings("serial")
public class RulesFrame extends JFrame implements WindowListener, KeyListener
{

	private CardWars cw;
	private JTextArea text;

	// private Font norm = new Font("Quicksand-Bold", Font.PLAIN, 20);

	public RulesFrame(CardWars cw)
	{
		super("Rules and Gameplay of CardWars");

		this.cw = cw;
		addWindowListener(this);

		text = new JTextArea();
		text.setEditable(false);
		text.setLineWrap(true);
		text.setWrapStyleWord(true);
		text.setFont(CardWars.QSB);

		displayRules();
		JScrollPane sp = new JScrollPane(text);
		getContentPane().add(sp);

		setSize(this.cw.getWidth(), this.cw.getHeight());
		setLocationRelativeTo(null);

		Container c = getContentPane();
		c.add(new RulesPanel());
		c.add(sp);

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
		setResizable(false);
	}

	@Override
	public void windowActivated(WindowEvent e) {
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// System.out.println("Closing");
		cw.setEnabled(true);
		cw.setVisible(true);
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

	@Override
	public void keyPressed(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
		switch(e.getKeyCode())
		{
		case KeyEvent.VK_ESCAPE:
			this.dispose();
			break;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	private static Scanner s;

	private void displayRules() {

		try
		{
			s = new Scanner(CardWars.rules);
		} catch (FileNotFoundException e)
		{
			System.out.println("File not found: CWRules.txt");
		}

		String d;

		// int h = (int)(this.getHeight()*.1);

		while(s.hasNextLine())
		{
			d = s.nextLine();
			if(d.contains(":") && !d.contains("The first method:"))
			{
				text.append(d);
				text.append("\n");
				text.append("\n");
			}

			else
			{
				text.append(d);
				text.append("\n");
			}

		}

		text.setCaretPosition(0);

	}

}
