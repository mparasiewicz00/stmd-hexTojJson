package pl.mpss.stmdhextojjson.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.mpss.stmdhextojjson.service.HexToJsonService;

@RestController
@RequestMapping("/api")
public class HexToJsonController {

    @Autowired
    private HexToJsonService hexToJsonService;

    @PutMapping("/data")
    public ResponseEntity<String> convertHexToJson(@RequestHeader("Authentication") String authHeader, @RequestBody byte[] data) {
        try {
            String json = hexToJsonService.convert(data);
            return ResponseEntity.ok(json);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error processing data");
        }
    }
}