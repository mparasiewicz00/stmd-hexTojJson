package pl.mpss.stmdhextojjson.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class HexToJsonServiceTest {

    @Autowired
    private HexToJsonService hexToJsonService;

    byte[] bytes;
    String json;

    @Test
    void convertTest1() throws IOException, JsonProcessingException {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream is = classloader.getResourceAsStream("block_2024-06-28T17_24_52.bin");
        bytes = is.readAllBytes();

        InputStream isJason = classloader.getResourceAsStream("block_2024-06-28T17_24_52.json");
        json = new String(isJason.readAllBytes());

        String actual = hexToJsonService.convert(bytes);
        String expected = json;
        assertEquals(expected, actual);
    }

    @Test
    void convertTest2() throws IOException, JsonProcessingException {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream is = classloader.getResourceAsStream("block_2024-06-28T17_25_31.bin");
        bytes = is.readAllBytes();

        InputStream isJason = classloader.getResourceAsStream("block_2024-06-28T17_25_31.json");
        json = new String(isJason.readAllBytes());

        String actual = hexToJsonService.convert(bytes);
        String expected = json;
        assertEquals(expected, actual);
    }
}