package com.order.game;

import com.order.game.character.Character;

import java.util.ArrayList;
import java.util.Collections;

public class TurnManager {

    public TurnManager(){}

    public static void prepareQueue(ArrayList<Character> c){
        Collections.sort(c);
    }


}
