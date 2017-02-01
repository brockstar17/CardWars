package com.github.brockstar17.attack;

public class AttackUtil
{

	public static String compare(int player1, int player2) {
		if(player1 != 1 && player2 != 1)
		{
			if(player1 > player2)
			{
				return "p1";
			}
			else if(player1 < player2)
			{
				return "p2";
			}
			else
			{
				return "war";
			}
		}
		else
		{
			if(player1 == 1 && player1 != player2)
			{
				return "p1";
			}
			else if(player2 == 1 && player1 != player2)
			{
				return "p2";
			}
			else
			{
				return "war";
			}
		}
	}

}
