package net.shchoo.simple.enigma;

import java.util.Arrays;
import net.shchoo.simple.enigma.rotor.*;

import org.junit.jupiter.api.Test;

public class EnigmaTest {
    
    @Test
    public void encryptedMessage_decryptsToSelf() { 
        RotorBox rotors = new RotorBox(Arrays.asList(
            StandardRotor.I.startingAt('A'), 
            StandardRotor.II.startingAt('A'), 
            StandardRotor.III.startingAt('A')));
        Enigma enigma = new Enigma(
            rotors,
            new PlugBoard(), 
            new Reflector()
        );
        String message = "TEST";
        String encrypted = enigma.encryptDecrypt(message);
        System.out.println(encrypted);
        
        enigma = new Enigma(new RotorBox(Arrays.asList(
                StandardRotor.I.startingAt('A'), 
                StandardRotor.II.startingAt('A'), 
                StandardRotor.III.startingAt('A'))), 
            new PlugBoard(), 
            new Reflector());
        
        String decrypted = enigma.encryptDecrypt(encrypted);
        System.out.println(decrypted);
    }
}
