package net.shchoo.simple.enigma;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import net.shchoo.simple.enigma.rotor.*;

import org.junit.jupiter.api.Test;

public class EnigmaTest {
    
    private static class TestConfig { 
        String key;
        List<StandardRotor> rotors;
        String plugs;

        TestConfig(String key, List<StandardRotor> rotors, String plugs) {
            this.key = key;
            this.rotors = rotors;
            this.plugs = plugs;
        }

        Enigma from() {
            return new Enigma(
                new RotorBox(Arrays.asList(
                    rotors.get(0).startingAt(key.charAt(0)),
                    rotors.get(1).startingAt(key.charAt(1)),
                    rotors.get(2).startingAt(key.charAt(2)))),
                new PlugBoard(plugs),
                    new Reflector());
        }
    }

    @Test
    public void encryptedMessage_decryptsToSelf() { 
        
        TestConfig config = new TestConfig(
            "ABC", 
            Arrays.asList(
                StandardRotor.I, 
                StandardRotor.II, 
                StandardRotor.III),
            "AV BS CG DL FU HZ IN KM OW RX");
        
        Enigma encryptor = config.from();
        String secret = encryptor.encryptDecrypt("HELLOWORLD");
        assertEquals("QGQOPVYZXP", secret);
        Enigma decryptor = config.from();
        String message = decryptor.encryptDecrypt(secret);
        assertEquals("HELLOWORLD", message);
    }
}
