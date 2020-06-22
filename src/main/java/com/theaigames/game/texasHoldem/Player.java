/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.theaigames.game.texasHoldem;

/**
 *
 * @author olivier
 */

import java.io.IOException;

import com.theaigames.engine.io.IOPlayer;
import com.theaigames.game.texasHoldem.move.PokerMove;

/**
 * Class that represents one Robot object and stores additional information such as the name that the bot receives and
 * which person is the author.
 */
public class Player
{
	private String name;
	private IOPlayer bot;
	private long timeBank;
	private long maxTimeBank;
	private long timePerMove;
	
	public Player(String name, IOPlayer bot, long maxTimeBank, long timePerMove)
	{
		this.bot = bot;
		this.name = name;
		this.maxTimeBank = maxTimeBank;
		this.timePerMove = timePerMove;
	}
	
	/**
	 * @return The String name of this Player
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @return The time left in this player's time bank
	 */
	public long getTimeBank() {
		return timeBank;
	}
	
	/**
	 * @return The Bot object of this Player
	 */
	public IOPlayer getBot() {
		return bot;
	}
	
	/**
	 * sets the time bank directly
	 */
	public void setTimeBank(long time) {
		this.timeBank = time;
	}
	
	/**
	 * updates the time bank for this player, cannot get bigger than maximal time bank or smaller than zero
	 * @param time : time consumed from the time bank
	 */
	public void updateTimeBank(long time) 
	{
		this.timeBank = Math.max(this.timeBank - time, 0);
		this.timeBank = Math.min(this.timeBank + this.timePerMove, this.maxTimeBank);
	}
	
	public void sendInfo(String info) 
	{
		try {
			this.bot.process(info, "input");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public PokerMove requestMove() 
	{
		long startTime = System.currentTimeMillis();
		
		try {
			this.bot.process(String.format("Action %s %d", this.name, this.timeBank), "input");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String response = this.bot.getResponse(this.timeBank);
		long timeElapsed = System.currentTimeMillis() - startTime;
		updateTimeBank(timeElapsed);
		
		if(response == "") {
			bot.addToDump("Error, action set to 'check'");
		} else {
			String[] parts = response.split("\\s");
			if(parts.length != 2)
				bot.addToDump("Bot input '" + response + "' does not split into two parts. Action set to \"check\"");
	    	else
	        	return new PokerMove(parts[0], (int) Double.parseDouble(parts[1]));
		}
		
		return new PokerMove("check", 0);
	}
}
