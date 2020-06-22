/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.theaigames.game.texasHoldem.move;

/**
 *
 * @author olivier
 */

public class PreMoveInfo
{
	private int maxWinPot;
	private int amountToCall;
	
	public PreMoveInfo(int maxPot, int amountCall)
	{
		maxWinPot = maxPot;
		amountToCall = amountCall;
	}
	
	/**
	 * Returns a String representation of the current table situation.
	 */
	public String toString()
	{
		String str = "";
		
		str += String.format("Match maxWinPot %d\n", maxWinPot);		
		str += String.format("Match amountToCall %d", amountToCall);
		
		return str;
	}
}
