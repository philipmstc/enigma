package net.shchoo.simple.enigma.rotor;

import java.util.List;
import java.util.function.Function;

import net.shchoo.simple.enigma.Cipher;

public class RotorBox implements Cipher{
    private final List<Rotor> rotors;

    public RotorBox(List<Rotor> rotors) {
        this.rotors = rotors;
    }


    @Override
    public char forwards(char in) {
        int currentRotor = 0;
        while (rotors.get(currentRotor++).turnOver());
        return rotors
            .stream()
            .map(rotor -> (Function<Character, Character>)rotor::forwards)
            .reduce(Function::andThen)
            .orElse(Function.identity())
            .apply(in);
            

    }

    @Override
    public char backwards(char in) {
        return rotors  
            .stream()
            .map(rotor -> (Function<Character, Character>)rotor::backwards)
            .reduce(Function::compose)
            .orElse(Function.identity())
            .apply(in);
    }
}
