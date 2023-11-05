package net.shchoo.simple.enigma.rotor;

public enum StandardRotor{
                //  "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    I       ("EKMFLGDQVZNTOWYHXUSPAIBRCJ"),
    II      ("AJDKSIRUXBLHWTMCQGZNPYFVOE"),
    III     ("BDFHJLCPRTXVZNYEIWGAKMUSQO"),
    IV      ("ESOVPZJAYQUIRHXLNFTGKDCMWB"),
    V       ("VZBRGITYUPSDNHLXAWMJQOFECK");

    private final String wiring;

    StandardRotor(String wiring) {
        this.wiring = wiring;
    }

    public Rotor startingAt(char pos) {
        return RotorFactory.createRotor(wiring, pos);
    }

    
}
