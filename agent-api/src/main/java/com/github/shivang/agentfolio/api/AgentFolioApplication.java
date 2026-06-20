package com.github.shivang.agentfolio.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(
    scanBasePackages = "com.github.shivang.agentfolio"
)
public class AgentFolioApplication {

    public static void main(String[] args) {
        SpringApplication.run(AgentFolioApplication.class, args);
    }

}