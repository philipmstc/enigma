package net.shchoo.simple.enigma.rotor;

import net.shchoo.simple.enigma.Cipher;

public class Reflector implements Cipher {

    private final char[] wiring;

    public Reflector(char[] wiring) {
        this.wiring = wiring;
    }

    @Override
    public char backwards(char in) {
        throw new UnsupportedOperationException("Reflectors are one-way");
    }

    @Override
    public char forwards(char in) {
        return wiring[(in - 'A') % 26];
    }
    
}
