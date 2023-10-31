package net.shchoo.simple.enigma;

public class Letter 
{
    private char value;
    
    public Letter(char value)
    {
        this.value = value;
    }

    public Letter through(Cipher cipher) 
    {
        return new Letter(cipher.forwards(value));
    }

    public Letter backThrough(Cipher cipher) 
    {
        return new Letter(cipher.backwards(value));
    }

    public char out()
    {
        return value;
    }
}
