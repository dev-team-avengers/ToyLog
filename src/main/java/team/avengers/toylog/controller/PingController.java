package team.avengers.toylog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
public class PingController {
    @Autowired
    private Environment env;

    @GetMapping(value = "/health")
    public String isAlive() {
        String profiles = String.join(", ", env.getActiveProfiles());
        String now = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        return "ToyLogApplication is running in [" + profiles + "] server. Now is " + now;
    }
}
