/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.theaigames.engine;

/**
 *
 * @author olivier
 */
import com.theaigames.engine.io.IOPlayer;
import java.util.ArrayList;

/**
 * Logic interface
 * 
 * Interface to implement when creating games.
 * 
 * @author Jackie Xu <jackie@starapple.nl>, Jim van Eeden <jim@starapple.nl>
 */
public interface Logic {
    public void setupGame(ArrayList<IOPlayer> players) throws Exception;
    public void playRound(int roundNumber) throws Exception;
    public boolean isGameWon();
    public void finish() throws Exception;
}

