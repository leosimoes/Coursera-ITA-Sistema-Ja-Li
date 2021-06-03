package org.coursera.jali;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JaliApplication {

    public static void main(String[] args) {
        //System.setProperty("server.servlet.context-path", "/jali");
        SpringApplication.run(JaliApplication.class, args);
    }

}
