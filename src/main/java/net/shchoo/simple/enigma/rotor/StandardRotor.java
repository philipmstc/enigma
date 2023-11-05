package net.shchoo.simple.enigma.rotor;

public enum StandardRotor{
                //  "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    I       ("EKMFLGDQVZNTOWYHXUSPAIBR^CJ"),
    II      ("AJDKSIRUXBLHWTMCQGZNPYF^VOE"),
    III     ("BDFHJLCPRTXVZNYEIW^GAKMUSQO"),
    IV      ("ESOVPZJAYQUIRHXLNFTGK^DCMWB"),
    V       ("VZBRGITYUPSDNHLXA^WMJQOFECK");

    private final String wiring;

    StandardRotor(String wiring) {
        this.wiring = wiring;
    }

    public Rotor startingAt(char pos) {
        return RotorFactory.createRotor(wiring, pos);
    }

    
}
