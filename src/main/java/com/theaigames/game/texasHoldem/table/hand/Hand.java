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
import com.theaigames.game.texasHoldem.table.cards.Card;

public abstract class Hand
{
	protected Card[] cards;
	
	
	/**
	* Returns a specific card of this hand
	*/
	public Card getCard(int index)
	{
		if(index >= 0 && index < cards.length)
			return cards[index];
		else
			return null;
	}
	
	
	/**
	 * Returns the number of cards in the hand/
	 */
	public int getNumberOfCards()
	{
		return cards.length;
	}
	
	
	/**
	* Returns an array of the two hand cards
	*/
	public Card[] getCards()
	{
		return cards;
	}
	
	
	/**
	 * Returns a string representation of the hand
	 */
	public String toString()
	{
		String str = "[";
		for(int i = 0; i < cards.length - 1; i++)
			str += cards[i].toString() + ",";
		
		str += cards[cards.length - 1].toString() + "]";
		return str;
	}
}
