package net.shchoo.simple.enigma;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PlugBoard implements Cipher {
    private final Map<Character, Character> plugs;

    public PlugBoard() {
        this(new HashMap<>());
    }

    public PlugBoard(Map<Character, Character> plugs) {
        this.plugs = plugs;
    }

    public PlugBoard(String plugs) { 
        this.plugs = new HashMap<>();
        Arrays.asList(plugs.split(" "))
        .stream()
        .forEach(split -> add(split.charAt(0), split.charAt(1)));
    }
    
    public void add(char from, char to) { 
        if (plugs.containsKey(from) || plugs.containsKey(to)) { 
            throw new IllegalArgumentException("Letters can only be plugged once");
        }
        plugs.put(from, to);
        plugs.put(to, from);
    }

    @Override
    public char forwards(char in) {
        return plugs.getOrDefault(in, in);
    }

    @Override
    public char backwards(char in) {
        return plugs.getOrDefault(in, in);
    }

    
}
