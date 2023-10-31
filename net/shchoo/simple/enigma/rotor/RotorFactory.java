package net.shchoo.simple.enigma.rotor;

import java.util.ArrayList;
import java.util.Collection;

public class RotorFactory {
    public static Rotor createRotor(String wiring) {
        char[] w = new char[26];
        Collection<Character> notches = new ArrayList<>();
        int startingPos = 0; 
        int curr = 0;
        for (int i = 0; i < wiring.length(); i++) {
            char c = wiring.charAt(i);
            if (c == '^') {
                notches.add(w[curr]);
            }
            else if (c == ':') {
                startingPos = curr;
            }
            else { 
                w[curr++] = c;
            }        
        }
        return new Rotor(w, notches, startingPos);
    }
}
