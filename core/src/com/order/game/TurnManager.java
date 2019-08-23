package com.order.game;

import com.order.game.character.Character;

import java.util.ArrayList;
import java.util.Collections;

public class TurnManager {

    public TurnManager(){}

    public static ArrayList<Character> prepareQueue(ArrayList<Character> c){

        ArrayList<Character> queue = c;
        Collections.sort(queue);
        return queue;

    }


}
