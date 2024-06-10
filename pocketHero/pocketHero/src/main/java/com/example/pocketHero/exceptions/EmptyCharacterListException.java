package com.example.pocketHero.exceptions;

public class EmptyCharacterListException extends RuntimeException{
    public EmptyCharacterListException() {
        super("The character list is empty");
    }
    
}
