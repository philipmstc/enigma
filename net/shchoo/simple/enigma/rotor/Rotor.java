package net.shchoo.simple.enigma.rotor;

import java.util.Collection;

import net.shchoo.simple.enigma.Cipher;

public class Rotor implements Cipher
{
    private final char[] forwardWiring;
    private final Collection<Character> notches;
    private final char[] backwardWiring;
    private int position;

    public Rotor(
        char[] wiring, 
        Collection<Character> notches,
        int position)
    {
        this.forwardWiring = wiring;
        this.backwardWiring = new char[wiring.length];
        for (int i = 0; i < wiring.length; i++) {
            backwardWiring[(wiring[i] - 'A') % 26] = wiring[i];
        }
        this.notches = notches;
        this.position = position;
    }

    public boolean turnOver() 
    {
        position = (position + 1) % 26;
        return notches.contains(forwardWiring[position]); 
    }

    @Override
    public char forwards(char in) 
    {
        return forwardWiring[(in - 'A' + position) % 26];
    }

    @Override
    public char backwards(char in) 
    {
        return backwardWiring[(in - 'A' + position) % 26];
    }
}
