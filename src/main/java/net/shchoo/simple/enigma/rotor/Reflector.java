package net.shchoo.simple.enigma.rotor;

import net.shchoo.simple.enigma.Cipher;

public class Reflector implements Cipher {

    private final char[] wiring;

    public Reflector() {
        this.wiring = new char[]{'E','J','M','Z','A','L','Y','X','V','B','W','F','C','R','Q','U','O','N','T','S','P','I','K','H','G','D'};
    }

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
