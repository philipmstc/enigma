package net.shchoo.simple.enigma;

public interface Cipher {
    char forwards(char in);
    char backwards(char in);
}
