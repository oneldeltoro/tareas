package com.example.demo;

import com.example.demo.controller.ManagingTareasController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import java.util.UUID;


@SpringBootTest(classes = TareasApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TareasApplicationTests {
    @Autowired
    private ManagingTareasController managingTareasController;
    /*//*/

    private String getUUID() {
        return UUID.randomUUID().toString();
    }

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void contextLoads() {
    }


}
