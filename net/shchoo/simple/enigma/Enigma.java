package net.shchoo.simple.enigma;

import net.shchoo.simple.enigma.rotor.Reflector;
import net.shchoo.simple.enigma.rotor.RotorBox;

public class Enigma { 
    private final RotorBox rotorBox;
    private final PlugBoard plugBoard;
    private final Reflector reflector;
    
    public Enigma(
        RotorBox rotorBox,
        PlugBoard plugBoard,
        Reflector reflector) 
    {
        this.rotorBox = rotorBox;
        this.plugBoard = plugBoard;
        this.reflector = reflector;
    }

    public String encryptDecrypt(String message) 
    {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < message.length(); i++) 
        {
            Letter c = new Letter(message.charAt(i));
            sb.append(
                c.through(plugBoard)
                 .through(rotorBox)
                 .through(reflector)
                 .backThrough(rotorBox)
                 .backThrough(plugBoard)
            .out());
        }
        return sb.toString();
    }
}