package com.example.zee;

public class NameValidation extends RegexpValidator{
    public NameValidation(String message) {
        // will allow people with hyphens in his name or surname. Supports also unicode
        super(message, "[\\p{L}- ]+");
    }
}
