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
        this.value = cipher.forwards(value);
        return this;
    }

    public Letter backThrough(Cipher cipher) 
    {
       this.value = cipher.backwards(value);
       return this;
    }

    public char out()
    {
        return value;
    }
}
