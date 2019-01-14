package com.springboot.Rest.webservices.restfulwebservices.Helloworld;

import org.apache.tomcat.util.http.parser.AcceptLanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.Locale;

@RestController
public class HelloWorldController {
    // GEt
    //URL - /hello-world
    //method - "Hello world"
   //@GetMapping("/helloWorld")

    @Autowired
    private MessageSource messageSource;

    @GetMapping(path = "/Helloworld-internationalized")
    public String helloWorldInternationalized(@RequestHeader(name="Accept-Language") Locale locale)
    {
        return messageSource.getMessage("good.morning.message",null,locale);
    }
    @RequestMapping(method = RequestMethod.GET , path = "Helloworld/hellworld")
    public String helloworld()
    {
        return "Hellworld";
    }
    @RequestMapping(method = RequestMethod.GET , path = "/Helloworld")
    public Hellworld helloWorld()
    {
        return new Hellworld("Hi , Ma ");
    }
    @RequestMapping(method = RequestMethod.GET , path = "/Helloworld/path-variable/{name}")
    public Hellworld helloWorld(@PathVariable String name)
    {
        return new Hellworld(String.format("Hi Man ,%s",name));
    }
}
