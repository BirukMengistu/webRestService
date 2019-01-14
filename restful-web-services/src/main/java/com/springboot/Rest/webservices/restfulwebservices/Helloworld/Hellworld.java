package com.springboot.Rest.webservices.restfulwebservices.Helloworld;

public class Hellworld {
    private String message;
    public Hellworld(String message)
    {
        this.message= message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return Hellworld.class.toString() ;
    }
}
