package com.springboot.Rest.webservices.restfulwebservices.user;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class userNotFoundExceptions extends RuntimeException {

    public userNotFoundExceptions(String message) {
        super(message);
    }
}
