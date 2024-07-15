package pl.mpss.stmdhextojjson.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HexToJsonControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void convertTest1() throws IOException {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream is = classloader.getResourceAsStream("block_2024-06-28T17_24_52.bin");
        byte[] bytes = is.readAllBytes();

        InputStream isJason = classloader.getResourceAsStream("block_2024-06-28T17_24_52.json");
        String expectedJson = new String(isJason.readAllBytes());

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authentication", "Bearer testDeviceId");
        HttpEntity<byte[]> entity = new HttpEntity<>(bytes, headers);

        ResponseEntity<String> response = restTemplate.exchange("/api/data", HttpMethod.PUT, entity, String.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedJson, response.getBody());
    }

    @Test
    void convertTest2() throws IOException {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream is = classloader.getResourceAsStream("block_2024-06-28T17_25_31.bin");
        byte[] bytes = is.readAllBytes();

        InputStream isJason = classloader.getResourceAsStream("block_2024-06-28T17_25_31.json");
        String expectedJson = new String(isJason.readAllBytes());

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authentication", "Bearer testDeviceId");
        HttpEntity<byte[]> entity = new HttpEntity<>(bytes, headers);

        ResponseEntity<String> response = restTemplate.exchange("/api/data", HttpMethod.PUT, entity, String.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedJson, response.getBody());
    }
}