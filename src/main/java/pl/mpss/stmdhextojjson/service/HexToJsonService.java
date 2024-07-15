package pl.mpss.stmdhextojjson.service;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface HexToJsonService {
    String convert(byte[] bytes) throws JsonProcessingException;
}
