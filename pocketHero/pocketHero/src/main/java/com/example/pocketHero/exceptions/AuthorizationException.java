package com.example.pocketHero.exceptions;

public class AuthorizationException extends RuntimeException{
    public AuthorizationException(String message) {
        super("You don't have permission to see this");
    
}

}