/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.theaigames.engine.io;

/**
 *
 * @author olivier
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * InputStreamGobbler class
 * 
 * @author Jackie Xu <jackie@starapple.nl>, Jim van Eeden <jim@starapple.nl>
 */
public class InputStreamGobbler extends Thread {
	
	private InputStream inputStream;
	private IOPlayer player;
	private String type;
	private StringBuffer buffer;

	InputStreamGobbler(InputStream inputStream, IOPlayer player, String type) {
        this.inputStream = inputStream;
        this.player = player;
        this.type = type;
        this.buffer = new StringBuffer();
    }

    public void run() {
    	String lastLine;
    	
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(this.inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            while ((lastLine = bufferedReader.readLine()) != null) {
                if (!lastLine.contains("VM warning") && buffer.length() < 1000000) { //catches bots that return way too much (infinite loop)
                    if (this.type.equals("output"))
                	   this.player.response = lastLine;
                    buffer.append(lastLine + "\n");
                }
            }
            try {
            	bufferedReader.close();
            } catch (IOException e) {}
            
        } catch (IOException x) {
            throw new RuntimeException(x);
        }
    }
    
    public String getData() {
		return buffer.toString();
	}
}

