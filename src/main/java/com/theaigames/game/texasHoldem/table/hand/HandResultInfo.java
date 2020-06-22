/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.theaigames.game.texasHoldem.table.hand;

/**
 *
 * @author olivier
 */
import java.util.ArrayList;

import com.theaigames.game.texasHoldem.Player;

public class HandResultInfo
{
	private ArrayList<Player> bots;
	private String[] botCodeNames;
	private int[] potParts;
	private Hand[] hands;
	
	public HandResultInfo(ArrayList<Player> botList, String[] botNames, int[] potDistribution)
	{
		bots = botList;
		botCodeNames = botNames;
		potParts = potDistribution;
		hands = new Hand[bots.size()];
	}
	
	
	/**
	 * Sets the hand of a bot that is involved in the showdown.
	 * @param botName : the name of the bot
	 * @param hand : the hand of the bot
	 */
	public void setBotHand(int seat, Hand hand)
	{
		if(seat >= bots.size() || seat < 0)
			System.err.println("The given bot is not part of this match!");
		else
			hands[seat] = hand;
	}
	
	
	/**
	 * Returns a String representation of the match result information.
	 */
	public String toString()
	{
		String str = "";
		for(int i = 0; i < bots.size(); i++)
			if(hands[i] != null)
				str += String.format("%s hand %s\n", botCodeNames[i], hands[i].toString());
		for(int i = 0; i < bots.size(); i++)
			if(potParts[i] > 0)
				str += String.format("%s wins %d\n", botCodeNames[i], potParts[i]);
				
		str = str.trim();
		return str;
	}
}
