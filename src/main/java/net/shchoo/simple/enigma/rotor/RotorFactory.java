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
                notches.add(w[curr-1]);
            }
            else if (c == ':') {
                startingPos = curr;
            }
            else { 
                w[curr++] = c;
            }        
        }
        return new RotorImpl(w, notches, startingPos);
    }

    public static Rotor createRotor(String wiring, char startingPos) 
    {
        char[] w = new char[26];
        Collection<Character> notches = new ArrayList<>();
        int start = startingPos-'A';
        int curr = 0;
        for (int i = 0; i < wiring.length(); i++) {
            char c = wiring.charAt(i);
            if (c == '^') {
                notches.add(w[curr-1]);
            }
            else { 
                w[curr++] = c;
            }        
        }
        return new RotorImpl(w, notches, start);
    }
}
