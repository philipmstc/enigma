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
        Letter l = new Letter(cipher.forwards(value));
        System.out.println(this.value + "->" + l.value);
        return l;
    }

    public Letter backThrough(Cipher cipher) 
    {
        Letter l = new Letter(cipher.backwards(value));
        System.out.println(this.value + "->" + l.value);
        return l;
    }

    public char out()
    {
        return value;
    }
}
