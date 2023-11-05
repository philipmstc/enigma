package net.shchoo.simple.enigma.rotor;

import java.util.Collection;

public class RotorImpl implements Rotor
{
    private final char[] forwardWiring;
    private final Collection<Character> notches;
    private final char[] backwardWiring;
    private int position;

    public RotorImpl(
        char[] wiring, 
        Collection<Character> notches,
        int position)
    {
        this.forwardWiring = wiring;
        this.backwardWiring = new char[wiring.length];
        for (int i = 0; i < wiring.length; i++) {
            backwardWiring[(wiring[i] - 'A') % 26] = (char)('A' + i);
        }
        this.notches = notches;
        this.position = position;
    }

    @Override
    public boolean turnOver() 
    {
        position = (position + 1) % 26;
        return notches.contains(forwardWiring[position]); 
    }

    @Override
    public char forwards(char in) 
    {
        int index = (in - 'A') % 26;
        index = (index + position) % 26;
        char to =  forwardWiring[index];
        char actual = (char)('A' + (to - 'A' - position + 26) % 26);
        return actual;
    }

    @Override
    public char backwards(char in) 
    {
        int index = (in - 'A') % 26;
        index = (index + position) % 26;
        char to =  backwardWiring[index];
        char actual = (char)('A' + (to - 'A' - position + 26) % 26);
        return actual;
    }
}
