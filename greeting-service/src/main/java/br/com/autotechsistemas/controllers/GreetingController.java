package br.com.autotechsistemas.controllers;

import br.com.autotechsistemas.config.GreetingConfiguration;
import br.com.autotechsistemas.entities.Greeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private static final String template = "%s, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private GreetingConfiguration configuration;

    // http://localhost:8080/greeting?name=Raphael
    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "") String name){
        if(name.isEmpty()) name = configuration.getDefaultValue();
        return new Greeting(counter.incrementAndGet(), String.format(template, configuration.getGreeting(), name));
    }
}
