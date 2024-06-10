package com.example.pocketHero.exceptions;

public class EmpleadoNotFoundException extends RuntimeException {
    public EmpleadoNotFoundException(Long id) {
    super("Cannot find the character with the " + id + " id");
    }
    }