package pl.mpss.stmdhextojjson.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.mpss.stmdhextojjson.service.HexToJsonService;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class HexToJsonController {

    private final HexToJsonService hexToJsonService;

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