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

public class HandHoldem extends Hand
{		
	/**
	 * A hand containing two cards
	 * @param firstCard : the first card
	 * @param secondCard : the second card
	 */
	public HandHoldem(Card firstCard, Card secondCard)
	{
		cards = new Card[2];
		cards[0] = firstCard;
		cards[1] = secondCard;
	}
}
